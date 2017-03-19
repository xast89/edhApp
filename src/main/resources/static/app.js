var stompClient = null;
var cardArray = null;

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
        stompClient.subscribe('/user/queue/startGame', function (cardList) {
            cardArray = JSON.parse(cardList.body);
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

    // $("#commandZone").append( cardArray[0].name );
    // $("#commandZone").append( cardArray[0].name );
    // $('<img id="drag1" src="'+cardArray[0].id+'.jpg"/>').appendTo("#commandZone");
    // http://magiccards.info/scans/en/c13/186.jpg
    $('<img id="' + cardArray[0].id + '" src="' + cardArray[0].src + '" draggable="true" ondragstart="drag(event)"/>').appendTo("#commandZone");
    delete cardArray[0];

    var step;
    for (step = 1; step < 8; step++) {
        $('<img id="' + cardArray[step].id + '" src="' + cardArray[step].src + '" draggable="true" ondragstart="drag(event)"/>').appendTo("#myHand");
    }
}

function allowDrop(ev) {
    ev.preventDefault();
}

function drag(ev) {
    ev.dataTransfer.setData("card", ev.target.id);
}

function drop(ev) {
    ev.preventDefault();
    var card_id = ev.dataTransfer.getData("card");
    var left = ev.clientX + 'px';
    var top = ev.clientY + 'px';

    $('#' + card_id).appendTo(ev.target).css({"position": "absolute", "left": left, "top": top});

    var card = document.getElementById("card_id").src;

    // var car = {type:"Fiat", model:"500", color:"white"};
    var data = {
        src: "\'" + $('#' + card_id).attr('src') + "\'",
        id: "\'" + $('#' + card_id).attr('id') + "\'"
        // left: "\'" + $('#' + card_id).attr('id') + "\'",
    };

    stompClient.send("/app/shareCard", {}, data);

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