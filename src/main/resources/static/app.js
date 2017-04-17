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

var distanceFromTop = 180;


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
    stompClient.send("/app/startGame", {}, {});
}

function personal_onPage(message) {
    $("#myHand").append('<div class="col-md-2 card" >' + message + '</div>');
}

function drawCardOnDiv(card, div) {
    $('<img id="' + card.id + '" ' +
        'src="' + card.src + '" ' +
        'draggable="true" ' +
        'ondragstart="drag(event)" ' +
        'onclick="bigDisplay(\'' + card.src + '\')" ' +
        'title="' + card.skill + '" />').appendTo(div);
}
function startGame_onPage() {

    var commander = deckList.pop();
    commnadZoneList.push(commander);

    $('<img id="' + commander.id + '" ' +
        'src="' + commander.src + '" ' +
        'draggable="true" ' +
        'ondragstart="drag(event)" ' +
        'onclick="bigDisplay(\'' + commander.src + '\')" ' +
        'title="' + commander.skill + '" />')
        .appendTo("#commandZone")
        .css({"position": "absolute", "margin-left": "auto", "margin-right": "auto"});

    var step;
    for (step = 1; step < 2; step++) {
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

function moveCardFromSourceToDestination(sourceDiv, destinationDiv, card_id) {
    if (sourceDiv == "myHand") {
        $('#myHand #' + card_id).remove();

        var step;
        for (step = 0; step < handList.length; step++) {
            if (handList[step].id == card_id) {
                var card = handList.splice(step, 1);
                map[destinationDiv].push(card);
            }
        }
    }

    else if (sourceDiv == "commandZone") {
        $('#commandZone #' + card_id).remove();

        var step;
        for (step = 0; step < commnadZoneList.length; step++) {
            if (commnadZoneList[step].id == card_id) {
                var card = commnadZoneList.splice(step, 1);
                map[destinationDiv].push(card);
            }
        }
    }

    // else if (sourceDiv == "graveyard") {
    //     $('#graveyard #' + card_id).remove();
    //
    //     var step;
    //     for (step = 0; step < graveyardList.length; step++) {
    //         if (graveyardList[step].id == card_id) {
    //             var card = graveyardList.splice(step, 1);
    //             map[destinationDiv].push(card);
    //         }
    //     }
    // }
}

function drag(ev) {
    ev.dataTransfer.setData("card", ev.target.id);
    ev.dataTransfer.setData("src", ev.target.src);
    ev.dataTransfer.setData("skill", ev.target.title);
    ev.dataTransfer.setData("div", ev.target.parentNode.id);
    ev.dataTransfer.setData("offsetLeft", ev.clientX - ev.target.getBoundingClientRect().left);
    ev.dataTransfer.setData("offsetTop", ev.clientY - ev.target.getBoundingClientRect().top);
}

function drop(ev) {
    ev.preventDefault();
    var card_id = ev.dataTransfer.getData("card");
    var card_div = ev.dataTransfer.getData("div");
    var card_src = ev.dataTransfer.getData("src");
    var card_skill = ev.dataTransfer.getData("skill");

    var xPosition = getLeftOffset(ev)
    var yPosition = getTopOffset(ev)

    stompClient.send("/app/shareCard", {},
        JSON.stringify(
            {
                'id': $('#' + card_id).attr('id'),
                'src': $('#' + card_id).attr('src'),
                'skill': $('#' + card_id).attr('title'),
                'xPosition': xPosition,
                'yPosition': yPosition
                //'destination': ev.target.id
            }));

    if ($('#myBF #' + card_id).length) {
        $('#myBF #' + card_id).remove();
    }
    $('<img id="' + card_id + '" ' +
        'src="' + card_src + '" ' +
        'onclick="bigDisplay(\'' + card_src + '\')" ' +
            //'onmouseup="removeBigDisplay()" ' +
        'ondblclick ="tap(\'' + card_src + '\')"' +
            //'onkeypress ="tap(event)"' +
            //'onkeypress ="tap(event)"' +
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

    moveCardFromSourceToDestination(card_div, ev.target.id, card_id);
}

function bigDisplay(src) {
    $('div#bigDisplay > img').remove();
    $('<img id="bla" class="big-display" src="' + src + '"  />').appendTo("#bigDisplay");

}


function tap(src) {
    //jQuery.noConflict();
    //jQuery('#' + id).rotate(90);
    //jQuery('#'+id).rotateLeft([angle=90]);
    //$('#'+id).toggle(function() {
    //    $(this).rotate({ endDeg:180, persist:true });
    //}    );
    //$('#'+id).click(function() {
    //    $(this).rotate({ startDeg:-25, endDeg:0, easing:'ease-in' });
    //});


    var newSrc = src.substring(0, src.length - 4) + '_t.jpg';
    $('img[src="' + src + '"]').attr('src', newSrc);

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
        'onmouseenter="bigDisplay(\'' + card.src + '\')" />')
        .appendTo('#opBF')
        .css({
            "position": "absolute", "left": card.xPosition, "top": card.yPosition
        });
}

function showDeck() {
    alert(deckList[0].name);
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
