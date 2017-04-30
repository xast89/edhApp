var stompClient = null;
var commnadZoneList = [];
var deckList = [];
var handList = [];
var battleFieldList = [];
var graveyardList = [];
var map = {}; // or var map = {};
map['commandZone'] = commnadZoneList;
map['deck'] = deckList;
map['graveyard'] = graveyardList;
map['myBF'] = battleFieldList;
map['myHand'] = handList;

var distanceFromTop = 220;


function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    setStartButton(false);
}

function connect() {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/user/queue/reply', function (message) {
            personal_onPage(message.body);
        });
        stompClient.subscribe('/topic/shareCard', function (id) {
            var card = JSON.parse(id.body)
            //shareCard(card);
        });
        stompClient.subscribe('/user/queue/startGame', function (cardList) {
            deckList = JSON.parse(cardList.body);
            startGame_onPage();
        });
        stompClient.subscribe('/user/queue/shareOpponentCard', function (card) {
            var card = JSON.parse(card.body);
            shareOpponentCard(card);
        });
        stompClient.subscribe('/user/queue/tapCard', function (card) {
            var card = JSON.parse(card.body);
            tapCard(card);
        });
        stompClient.subscribe('/user/queue/removeCard', function (card) {
            var card = JSON.parse(card.body);
            removeCard(card);
        });
    });
}

function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function drawCard() {
    var card = deckList.pop();
    handList.push(card);

    drawCardOnDiv(card, "#myHand");
}

function setStartButton(value) {
    $("#startGame").prop("disabled", value);
}
function startGame() {
    setStartButton(true);
    stompClient.send("/app/startGame", {}, JSON.stringify({'commander': $("#commander option:selected").text()}));
}

function personal_onPage(message) {
    $("#myHand").append('<div class="col-md-2 card" >' + message + '</div>');
}

function drawCardOnDiv(card, div) {
    $('<img id="' + card.id + '" ' +
        'src="' + card.src + '" ' +
        'draggable="true" ' +
        'ondragstart="drag(event)" ' +
        'onclick="bigDisplay(\'' + card.src + '\')"/>')
        .appendTo(div);
}
function startGame_onPage() {

    var commander = deckList.pop();
    commnadZoneList.push(commander);

    $('<img id="' + commander.id + '" ' +
        'src="' + commander.src + '" ' +
        'draggable="true" ' +
        'ondragstart="drag(event)" ' +
        'onclick="bigDisplay(\'' + commander.src + '\')"/>')
        .appendTo("#commandZone")
        .css({"position": "absolute", "margin-left": "auto", "margin-right": "auto"});

    var step;
    for (step = 1; step < 8; step++) {
        var card = deckList.pop();
        handList.push(card);

        drawCardOnDiv(card, "#myHand");
    }
}

function allowDrop(ev) {
    ev.preventDefault();
}

function getLeftOffset(ev) {

    var offsetLeft = Number(ev.dataTransfer.getData("offsetLeft"));
    var left = ev.pageX;
    var leftResult = (left - offsetLeft) + 'px';

    return leftResult;
}

function getTopOffset(ev) {

    var offsetTop = Number(ev.dataTransfer.getData("offsetTop"));
    var top = ev.pageY - distanceFromTop;
    var topResult = (top - offsetTop) + 'px';

    return topResult;
}

function moveCardFromSourceToDestination(sourceDiv, evTarget, card_id) {
    if (sourceDiv == "myHand" && evTarget.id != "myHand" && evTarget.tagName != 'IMG') {
        $('#myHand #' + card_id).remove();

        var step;
        for (step = 0; step < handList.length; step++) {
            if (handList[step].id == card_id) {
                var card = handList.splice(step, 1);
                if (evTarget.id == 'deck') {
                    deckList.push(card[0]);
                }
                else if (evTarget.id = 'myBF') {
                    battleFieldList.push(card[0]);
                }
                else if (evTarget.id = 'graveyard') {
                    graveyardList.push(card[0]);
                }
            }
        }
    }

    //else if (sourceDiv == "commandZone") {
    //    $('#commandZone #' + card_id).remove();
    //
    //    var step;
    //    for (step = 0; step < commnadZoneList.length; step++) {
    //        if (commnadZoneList[step].id == card_id) {
    //            var card = commnadZoneList.splice(step, 1);
    //            map[destinationDiv].push(card);
    //        }
    //    }
    //}

    else if (sourceDiv == "myBF" && (evTarget.id == 'deck' || evTarget.id == 'graveyard') && evTarget.tagName != 'IMG') {
        $('#myBF #' + card_id).remove();

        var step;
        for (step = 0; step < battleFieldList.length; step++) {
            if (battleFieldList[step].id == card_id) {
                var card = battleFieldList.splice(step, 1);
                if (evTarget.id == 'deck') {
                    deckList.push(card[0]);
                }
                else {
                    graveyardList.push(card[0]);
                }
            }
        }
    }
    else if (sourceDiv == "myBF" && evTarget.id == 'myHand' && evTarget.tagName != 'IMG') {
        //$('#myBF #' + card_id).remove();

        var step;
        for (step = 0; step < battleFieldList.length; step++) {
            if (battleFieldList[step].id == card_id) {
                var card = battleFieldList.splice(step, 1);
                if (evTarget.id == 'myHand') {
                    handList.push(card[0]);
                }
            }
        }
    }
}

function removeCard(card) {
    $('#opBF #' + card.id).remove();

}

function drag(ev) {
    ev.dataTransfer.setData("card", ev.target.id);
    ev.dataTransfer.setData("src", ev.target.src);
    ev.dataTransfer.setData("sourceDiv", ev.target.parentNode.id);
    ev.dataTransfer.setData("offsetLeft", ev.clientX - ev.target.getBoundingClientRect().left);
    ev.dataTransfer.setData("offsetTop", ev.clientY - ev.target.getBoundingClientRect().top);
}
//TODO: ZDEBUGOWAC CZEMU SIE WYWALA PRZERZUCANIE KART Z REKI DO DECKA/GRAVE I Z COMMANDZONE
function drop(ev) {
    if (ev.target.tagName != 'DIV') {
        return;
    }
    ev.preventDefault();
    var card_id = ev.dataTransfer.getData("card");
    var card_src = ev.dataTransfer.getData("src");
    var card_sourceDiv = ev.dataTransfer.getData("sourceDiv");

    var xPosition = getLeftOffset(ev)
    var yPosition = getTopOffset(ev)

    if ((ev.target.id) == "myBF") {
        stompClient.send("/app/shareCard", {},
            JSON.stringify(
                {
                    'id': $('#' + card_id).attr('id'),
                    'src': $('#' + card_id).attr('src'),
                    'skill': $('#' + card_id).attr('title'),
                    'xPosition': xPosition,
                    'yPosition': yPosition,
                    'sourceDiv': card_sourceDiv,
                    'destinationDiv': ev.target.id
                }));

        if ($('#myBF #' + card_id).length) {
            $('#myBF #' + card_id).remove();
        }
        if ($('#commandZone #' + card_id).length) {
            $('#commandZone #' + card_id).remove();
        }
        $('<img id="' + card_id + '" ' +
            'src="' + card_src + '" ' +
            'onclick="bigDisplay(\'' + card_src + '\')" ' +
            'ondblclick ="tap(\'' + card_id + '\')"' +
            'draggable="true" ' +
            'ondragstart="drag(event)"/>')
        //.on('mouseover', bigDisplay(card_src))
            .appendTo('#myBF')
            .css({
                "position": "absolute", "left": xPosition,
                "top": yPosition
            })
            //.on('mouseover', bigDisplay(card_src) )
            //.on('mouseout', removeBigDisplay() )
            //.on('onmouseout', removeBigDisplay() )
        ;
    }
    if (ev.target.id == 'myHand' && card_sourceDiv != "myHand") {
        if ($('#myBF #' + card_id).length) {
            $('#myBF #' + card_id).remove();
        }

        $('<img id="' + card_id + '" ' +
            'src="' + card_src + '" ' +
            'draggable="true" ' +
            'ondragstart="drag(event)" ' +
            'onclick="bigDisplay(\'' + card_src + '\')"/>')
            .appendTo('#myHand');

        stompClient.send("/app/removeCard", {},
            JSON.stringify(
                {
                    'id': $('#' + card_id).attr('id'),
                    'sourceDiv': card_sourceDiv,
                    'destinationDiv': ev.target.id
                }));

    }
    if (ev.target.id != 'myHand' && ev.target.id != 'commandZone' && ev.target.id != 'myBF' && card_sourceDiv != "myHand") {
        stompClient.send("/app/removeCard", {},
            JSON.stringify(
                {
                    'id': $('#' + card_id).attr('id'),
                    'sourceDiv': card_sourceDiv,
                    'destinationDiv': ev.target.id
                }));

        if ($('#myBF #' + card_id).length) {
            $('#myBF #' + card_id).remove();
        }

    }
    if (ev.target.id == 'commandZone') {
        if ($('#'+card_sourceDiv +' #' + card_id).length) {
            $('#'+card_sourceDiv +' #' + card_id).remove();
        }
        $('<img id="' + card_id + '" ' +
            'src="' + card_src + '" ' +
            'draggable="true" ' +
            'ondragstart="drag(event)" ' +
            'onclick="bigDisplay(\'' + card_src + '\')"/>')
            .appendTo('#commandZone');

        stompClient.send("/app/removeCard", {},
            JSON.stringify(
                {
                    'id': $('#' + card_id).attr('id'),
                    'sourceDiv': card_sourceDiv,
                    'destinationDiv': ev.target.id
                }));
    }

    moveCardFromSourceToDestination(card_sourceDiv, ev.target, card_id);
}

function bigDisplay(src) {
    $('div#bigDisplay > img').remove();
    $('<img id="bla" class="big-display" src="' + src + '"  />').appendTo("#bigDisplay");

}


function tap(id) {

    if ($('#' + id).hasClass('tap')) {
        $('#' + id).removeClass('tap');

        stompClient.send("/app/tapCard", {},
            JSON.stringify(
                {
                    'id': $('#' + id).attr('id'),
                    'tap': 'no'
                }));
    }
    else {
        $('#' + id).addClass('tap');
        stompClient.send("/app/tapCard", {},
            JSON.stringify(
                {
                    'id': $('#' + id).attr('id'),
                    'tap': 'yes'
                }));
    }

}

function removeBigDisplay() {
    $('div#bigDisplay > img').remove();
}

function shareOpponentCard(card) {

    if ($('#opBF #' + card.id).length) {
        $('#opBF #' + card.id).remove();
    }

    $('<img id="' + card.id + '" ' +
        'src="' + card.src + '" ' +
        'draggable="true" ' +
        'ondragstart="drag(event)" ' +
        'onmouseenter="bigDisplay(\'' + card.src + '\')" + ' +
        'onmouseleave="removeBigDisplay()" />')
        .appendTo('#opBF')
        .css({
            "position": "absolute", "left": card.xPosition, "top": card.yPosition
        });
}

function tapCard(card) {

    if ((card.tap).localeCompare('yes') == 0) {
        $('#opBF #' + card.id).addClass('tap');
    } else {
        $('#opBF #' + card.id).removeClass('tap');
    }
}


////////////////////////////////////////////////////////////////////

function showDeck() {
    $('#deck p select').remove();
    $('#deck p').append('<select id="deckCard">');
    deckList.forEach(function (card) {
        $('#deck p select').append('<option>' + card.name + '</option>')
    });
}

function fromDeckOntoYourHand() {

    var selectedCard = $("#deckCard option:selected").text();

    var step;
    for (step = 0; step < deckList.length; step++) {
        if (deckList[step].name == selectedCard) {
            var card2 = deckList.splice(step, 1);
            var card = card2[0];
            handList.push(card);


            $('<img id="' + card.id + '" ' +
                'src="' + card.src + '" ' +
                'draggable="true" ' +
                'ondragstart="drag(event)" ' +
                'onclick="bigDisplay(\'' + card.src + '\')"/>')
                .appendTo('#myHand');
        }
    }
    $('#deck p select').remove();
    shuffleDeck();
}

function shuffleDeck() {
    shuffle(deckList);
}

function shuffle(array) {
    var currentIndex = array.length, temporaryValue, randomIndex;

    // While there remain elements to shuffle...
    while (0 !== currentIndex) {

        // Pick a remaining element...
        randomIndex = Math.floor(Math.random() * currentIndex);
        currentIndex -= 1;

        // And swap it with the current element.
        temporaryValue = array[currentIndex];
        array[currentIndex] = array[randomIndex];
        array[randomIndex] = temporaryValue;
    }

    return array;
}


function showGraveyard() {
    $('#graveyard p select').remove();
    $('#graveyard p').append('<select id="graveyardCard">');
    graveyardList.forEach(function (card) {
        $('#graveyard p select').append('<option>' + card.name + '</option>')
    });
}

function fromGraveyardOntoYourHand() {

    var selectedCard = $("#graveyardCard option:selected").text();

    var step;
    for (step = 0; step < graveyardList.length; step++) {
        if (graveyardList[step].name == selectedCard) {
            var card2 = graveyardList.splice(step, 1);
            var card = card2[0];
            handList.push(card);


            $('<img id="' + card.id + '" ' +
                'src="' + card.src + '" ' +
                'draggable="true" ' +
                'ondragstart="drag(event)" ' +
                'onclick="bigDisplay(\'' + card.src + '\')"/>')
                .appendTo('#myHand');
        }
    }
    $('#graveyard p select').remove();
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $("#connect").click(function () {
        connect();
    });
    $("#disconnect").click(function () {
        disconnect();
    });
    $("#startGame").click(function () {
        startGame();
    });
    $("#drawCard").click(function () {
        drawCard();
    });

});
