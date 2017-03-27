var stompClient = null;
var deckList = [];
var commnadZoneList = [];
var handList = [];
var battleFieldList = [];

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

//zagranie z reki na bf (zmienic nazwe funckcji!)
function shareCard(card) {
    if($('#myBF #'+card.id).length)
    {
        $('#myBF #'+card.id).remove();

    }
    $('<img id="' + card.id + '" src="' + card.src + '" draggable="true" ondragstart="drag(event)"/>')
        .appendTo('#myBF')
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
                'yPosition':getTopOffset(ev)}));

    if(card_div == "myHand")
    {
        $('#myHand #'+card_id).remove();

        var step;
        for (step = 0; step < handList.length; step++) {
            if(handList[step].id == card_id)
            {
                var card = handList.splice(step,1);;

                battleFieldList.push(card);
            }

        }

    }
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
