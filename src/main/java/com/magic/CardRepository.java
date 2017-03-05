package com.magic;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pawel on 05.03.17.
 */
@Repository
public class CardRepository {

    List<Card> cardList = new ArrayList<>();

    public CardRepository()
    {
        cardList.add(createCard("Forest", 1));
        cardList.add(createCard("Plains", 2));
        cardList.add(createCard("Swamp", 3));
        cardList.add(createCard("Island", 4));
        cardList.add(createCard("Mountain", 5));

    }

    public List<Card> getCardList() {
        return cardList;
    }

    private Card createCard(String name, int number)
    {
        return new Card(name, number);
    }
}
