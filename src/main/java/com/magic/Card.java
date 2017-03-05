package com.magic;

/**
 * Created by pawel on 05.03.17.
 */
public class Card {

    private String name;
    private int number;

    public Card(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
