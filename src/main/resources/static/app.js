var stompClient = null;
var deckList = [];
var battleFieldList = [];

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
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
        stompClient.subscribe('/topic/removeCard', function (id) {
            deleteCard(id.body);
        });
        stompClient.subscribe('/topic/shareCard', function (id) {
            var card = JSON.parse(id.body)
            shareCard(card);
        });
        stompClient.subscribe('/user/queue/startGame', function (cardList) {
            deckList = JSON.parse(cardList.body);
            startGame_onPage();
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

function getCard() {
    stompClient.send("/app/card", {}, {});
}


// TODO: poczytac o tym
function showCard(name, id) {
    var card = $('<div class="col-md-2 card" id="' + id + '">' + name + '</div>');
    card.appendTo("#myHand");
    card.data('cardObj', {id: id, name: name});
}

function removeCard() {
    stompClient.send("/app/removeCard", {}, $("#idCardForRemove").val());
}

function deleteCard(id) {
    $('#' + id).remove();
}

function shareCard(card) {
    if($('#myBF #'+card.id).length)
    {
        $('#myBF #'+card.id).remove();

    }
    $('<img id="' + card.id + '" src="' + card.src + '" draggable="true" ondragstart="drag(event)"/>')
        .appendTo('#myBF')
        .css({"position": "absolute", "left": card.xPosition, "top": card.yPosition});
}

function startGame() {
    stompClient.send("/app/startGame", {}, {});
}

function personal() {
    stompClient.send("/app/personal", {}, $("#idCardForRemove").val());
}

function personal_onPage(message) {
    $("#myHand").append('<div class="col-md-2 card" >' + message + '</div>');
}

function startGame_onPage() {

    var commander = deckList.pop();
    battleFieldList.push(commander);
    $('<img id="' + commander.id + '" src="' + commander.src + '" draggable="true" ondragstart="drag(event)"/>').appendTo("#commandZone");

    var step;
    for (step = 1; step < 8; step++) {
        var card = deckList.pop();
        battleFieldList.push(card);
        $('<img id="' + card.id + '" src="' + card.src + '" draggable="true" ondragstart="drag(event)"/>').appendTo("#myHand");
    }
}

function allowDrop(ev) {
    ev.preventDefault();
}

function drag(ev) {
    ev.dataTransfer.setData("card", ev.target.id);
    ev.dataTransfer.setData("div",ev.target.parentNode.id);
}

function drop(ev) {
    ev.preventDefault();
    var card_id = ev.dataTransfer.getData("card");
    var card_div = ev.dataTransfer.getData("div");
    var left = ev.clientX + 'px';
    var top = ev.clientY + 'px';
//TODO: offset ; -> zapisac odleglosc od gornegp lewego rogu
    stompClient.send("/app/shareCard", {},
        JSON.stringify(
            {
                'id':$('#' + card_id).attr('id'),
                'src':$('#' + card_id).attr('src'),
                'xPosition':left,
                'yPosition':top}));

    if(card_div == "myHand")
    {
        $('#myHand #'+card_id).remove();
    }
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
    $("#getCard").click(function () {
        getCard();
    });
    $("#removeCard").click(function () {
        removeCard();
    });
    $("#startGame").click(function () {
        startGame();
    });
    $("#personal").click(function () {
        personal();
    });

});