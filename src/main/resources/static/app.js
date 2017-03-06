var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetings', function (greeting) {
            showGreeting(JSON.parse(greeting.body).content);
        });
        stompClient.subscribe('/topic/card', function (card) {
            showCard(JSON.parse(card.body).name, JSON.parse(card.body).id);
        });
        stompClient.subscribe('/topic/removeCard', function (id) {
            deleteCard(id.body);
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

function sendName() {
    stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

function getCard() {
    stompClient.send("/app/card", {}, {});
}

function showCard(name, id) {
    $("#card").prepend('<div class="col-md-6" id="'+id+'">'+name+'</div>');
    // $("#card").prepend('<div class="col-md-6" id="'+id+'">'+name+'  ' + id + '</div>');
}

function removeCard() {
    // stompClient.send("/app/removeCard", {}, JSON.stringify({'id': $("#idCardForRemove").val()}));
    stompClient.send("/app/removeCard", {}, $("#idCardForRemove").val());
}

function deleteCard(id) {
    $('#'+id).remove();
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
    })
    $("#send").click(function () {
        sendName();
    });

});