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
import java.util.Map;

/**
 * Created by pawel on 05.03.17.
 */
@Controller
public class CardController {

    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private WebSocketConfig webSocketConfig;

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

    @MessageMapping("/startGame")
    public void startGame(SimpMessageHeaderAccessor headerAccessor) {
        List<Card> dereviDeck = cardRepository.getDereviDeck();
        Card commander = dereviDeck.remove(getCommanderCard(dereviDeck));
        Collections.shuffle(dereviDeck);
        dereviDeck.add(dereviDeck.size(), commander);

        SimpMessageHeaderAccessor ha = SimpMessageHeaderAccessor
                .create(SimpMessageType.MESSAGE);
        ha.setSessionId(headerAccessor.getSessionId());
        ha.setLeaveMutable(true);
        messagingTemplate.convertAndSendToUser(headerAccessor.getSessionId(), "/queue/startGame", dereviDeck, ha.getMessageHeaders());
    }

    private int getCommanderCard(List<Card> dereviDeck) {
        return dereviDeck.size()-1;
    }

    @MessageMapping("/shareCard")
    public void shareCard(@Payload Card message, SimpMessageHeaderAccessor headerAccessor )
    {

        for (Map.Entry<String, String> stringStringEntry : webSocketConfig.userSessionIdMap.entrySet())
        {
            if(!stringStringEntry.getValue().equals(headerAccessor.getSessionId()))
            {
                SimpMessageHeaderAccessor ha = SimpMessageHeaderAccessor
                        .create(SimpMessageType.MESSAGE);
                ha.setSessionId(stringStringEntry.getValue());
                ha.setLeaveMutable(true);
                messagingTemplate.convertAndSendToUser(stringStringEntry.getValue(), "/queue/shareOpponentCard", message, ha.getMessageHeaders());
            }
        }

//        for (String name : UserName.userName) {
//            if(!name.equals(headerAccessor.getUser().getName()))
//            {
//                messagingTemplate.convertAndSendToUser(name, "queue/shareOpponentCard", message);
//            }
//
//        }
//        return message;
    }
}
