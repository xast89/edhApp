package com;

import com.magic.Card;
import com.magic.CardRepository;

import java.util.Collections;
import java.util.List;

/**
 * Created by pawel on 07.03.17.
 */
public class MainTest {

    public static void main(String[] args) {

        CardRepository cardRepository = new CardRepository();

        System.out.println("Przed tasowaniem");
        List<Card> dereviDeck = cardRepository.getDereviDeck();

        for (Card card : dereviDeck) {
            System.out.println(card.getName());
        }
        Card commander = dereviDeck.remove(0);

        int size = dereviDeck.size();

        Collections.shuffle(dereviDeck);

        dereviDeck.add(0, commander);

        System.out.println(" ");
        System.out.println("Po tasowaniu");
        for (Card card : dereviDeck) {
            System.out.println(card.getName());
        }
    }
}
