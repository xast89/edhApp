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
        stompClient.subscribe('/topic/card', function (card) {
            showCard(JSON.parse(card.body).name, JSON.parse(card.body).id);
        });
        stompClient.subscribe('/user/queue/reply', function (message) {
            personal_onPage(message.body);
        });
        stompClient.subscribe('/topic/shareCard', function (id) {
            var card = JSON.parse(id.body)
            shareCard(card);
        });
        stompClient.subscribe('/user/queue/startGame', function (cardList) {
            deckList = JSON.parse(cardList.body);
            startGame_onPage();
        });
        stompClient.subscribe('/user/queue/shareOpponentCard', function (card) {
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


// TODO: poczytac o tym
function showCard(name, id) {
    var card = $('<div class="col-md-2 card" id="' + id + '">' + name + '</div>');
    card.appendTo("#myHand");
    card.data('cardObj', {id: id, name: name});
}


function shareCard(card) {
    if($('#myBF #'+card.id).length)
    {
        $('#myBF #'+card.id).remove();
    }
    $('<img id="' + card.id + '" src="' + card.src + '" draggable="true" ondragstart="drag(event)"/>')
        .appendTo('#'+card.destination)
        .css({"position": "absolute", "left": card.xPosition, "top": card.yPosition});
}

function shareOpponentCard(card) {

    $('<img id="' + card.id + '" src="' + card.src + '" draggable="true" ondragstart="drag(event)"/>')
        .appendTo('#opBF')
        .css({"position": "absolute", "left": card.xPosition, "top": card.yPosition});
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
    $('<img id="' + card.id + '" src="' + card.src + '" draggable="true" ondragstart="drag(event)"/>').appendTo(div);
}
function startGame_onPage() {

    var commander = deckList.pop();
    commnadZoneList.push(commander);

    $('<img id="' + commander.id + '" src="' + commander.src + '" draggable="true" ondragstart="drag(event)"/>')
    .appendTo("#commandZone")
    .css({"position": "absolute", "margin-left": "auto", "margin-right": "auto"});

    var step;
    for (step = 1; step < 8; step++) {
        var card = deckList.pop();
        handList.push(card);

        drawCardOnDiv(card, "#myHand")
    }
}

function allowDrop(ev) {
    ev.preventDefault();
}

function drag(ev) {
    ev.dataTransfer.setData("card", ev.target.id);
    ev.dataTransfer.setData("div",ev.target.parentNode.id);
    ev.dataTransfer.setData("offsetLeft", ev.clientX-ev.target.getBoundingClientRect().left);
    ev.dataTransfer.setData("offsetTop", ev.clientY-ev.target.getBoundingClientRect().top);
}

function getLeftOffset(ev) {

    var offsetLeft = Number(ev.dataTransfer.getData("offsetLeft"));
    var left = ev.pageX;
    var leftResult = (left-offsetLeft) + 'px';

    return leftResult;
}

function getTopOffset(ev) {

    var offsetTop = Number(ev.dataTransfer.getData("offsetTop"));
    var top = ev.pageY;
    var topResult =  (top - offsetTop) + 'px';

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
function drop(ev) {
    ev.preventDefault();
    var card_id = ev.dataTransfer.getData("card");
    var card_div = ev.dataTransfer.getData("div");

    stompClient.send("/app/shareCard", {},
        JSON.stringify(
            {
                'id':$('#' + card_id).attr('id'),
                'src':$('#' + card_id).attr('src'),
                'xPosition':getLeftOffset(ev),
                'yPosition':getTopOffset(ev),
                'destination': ev.target.id}));

    moveCardFromSourceToDestination(card_div, ev.target.id, card_id);
}

function showDeck() {
    alert(deckList[0]);
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
