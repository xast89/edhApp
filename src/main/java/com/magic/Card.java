package com.magic;

/**
 * Created by pawel on 05.03.17.
 */
public class Card {

    private String name;
    private String number;

    public Card(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
