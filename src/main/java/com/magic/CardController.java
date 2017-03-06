package com.magic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by pawel on 05.03.17.
 */
@Controller
public class CardController {

    @Autowired
    private CardRepository cardRepository;

    @MessageMapping("/card")
    @SendTo("/topic/card")
    public Card getCard()
    {
        List<Card> cardList = cardRepository.getDereviDeck();

        if(cardList.size() != 0)
        {
            Card card = cardList.get((int) (Math.random() * cardList.size()));
//            cardRepository.getDereviDeck().remove(card);
            return card;
        }

        return null;
    }

    @MessageMapping("/removeCard")
    @SendTo("/topic/removeCard")
    public String removeCard(String id)
    {
        return id;
    }
}
