package com.magic;

/**
 * Created by pawel on 05.03.17.
 */
public class Card {

    private String name;
    private String id;

    public Card(String name, String number) {
        this.name = name;
        this.id = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
