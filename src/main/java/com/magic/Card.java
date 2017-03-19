package com.magic;

/**
 * Created by pawel on 05.03.17.
 */
public class Card {

    private String name;
    private String id;
    private String src;

    public Card(String name, String number, String src) {
        this.name = name;
        this.id = number;
        this.src = src;
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

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    @Override
    public String toString() {
        //create JSON format
        return "{\"name\":\""+getName()+"\"," +
                "\"id\":\""+getId()+"\"," +
                "\"src\":\""+getSrc()+"\"}";
    }
}
