package com.magic;

import java.io.Serializable;

/**
 * Created by pawel on 05.03.17.
 */
public class Card implements Serializable
{

    private String name;
    private String id;
    private String src;
    private String xPosition;
    private String yPosition;
    private String tap;
    private String sourceDiv;
    private String destinationDiv;

    public Card(String name, String id, String src)
    {
        this.name = name;
        this.id = id;
        this.src = src;
    }

    public Card()
    {

    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getSrc()
    {
        return src;
    }

    public void setSrc(String src)
    {
        this.src = src;
    }

    public String getxPosition()
    {
        return xPosition;
    }

    public void setxPosition(String xPosition)
    {
        this.xPosition = xPosition;
    }

    public String getyPosition()
    {
        return yPosition;
    }

    public void setyPosition(String yPosition)
    {
        this.yPosition = yPosition;
    }

    public String getDestinationDiv()
    {
        return destinationDiv;
    }

    public void setDestinationDiv(String destinationDiv)
    {
        this.destinationDiv = destinationDiv;
    }

    public String getTap()
    {
        return tap;
    }

    public void setTap(String tap)
    {
        this.tap = tap;
    }

    public String getSourceDiv() {
        return sourceDiv;
    }

    public void setSourceDiv(String sourceDiv) {
        this.sourceDiv = sourceDiv;
    }

    @Override
    public String toString()
    {
        // create JSON format
        return "{\"name\":\"" + getName() + "\"," +
                "\"id\":\"" + getId() + "\"," +
                "\"src\":\"" + getSrc() + "\"}";
    }
}
