package com.magic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.stereotype.Controller;

import java.util.Collections;
import java.util.List;

/**
 * Created by pawel on 05.03.17.
 */
@Controller
public class CardController {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    public SimpMessageSendingOperations messagingTemplate;

    @MessageMapping("/card")
    @SendTo("/topic/card")
    public Card getCard() {
        List<Card> cardList = cardRepository.getDereviDeck();

        if (cardList.size() != 0) {
            Card card = cardList.get((int) (Math.random() * cardList.size()));
            return card;
        }

        return null;
    }

    @MessageMapping("/removeCard")
    @SendTo("/topic/removeCard")
    public String removeCard(String id) {
        return id;
    }

    @MessageMapping("/startGame")
    public void startGame(SimpMessageHeaderAccessor headerAccessor) {
        List<Card> dereviDeck = cardRepository.getDereviDeck();
        Card commander = dereviDeck.remove(0);
        Collections.shuffle(dereviDeck);
        dereviDeck.add(0, commander);

        SimpMessageHeaderAccessor ha = SimpMessageHeaderAccessor
                .create(SimpMessageType.MESSAGE);
        ha.setSessionId(headerAccessor.getSessionId());
        ha.setLeaveMutable(true);
        messagingTemplate.convertAndSendToUser(headerAccessor.getSessionId(), "/queue/startGame", dereviDeck, ha.getMessageHeaders());
    }

    @MessageMapping("/shareCard")
    @SendTo("/topic/shareCard")
    public String shareCard(@Payload String message, SimpMessageHeaderAccessor headerAccessor)
    {
        return message;

    }
}
