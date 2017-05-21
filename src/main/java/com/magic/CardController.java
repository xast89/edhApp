package com.magic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.stereotype.Controller;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by pawel on 05.03.17.
 */
@Controller
public class CardController
{

    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private WebSocketConfig webSocketConfig;

    @Autowired
    public SimpMessageSendingOperations messagingTemplate;

    private List<Card> deck;

    @MessageMapping("/card")
    @SendTo("/topic/card")
    public Card getCard()
    {
        List<Card> cardList = cardRepository.getDereviDeck();

        if (cardList.size() != 0)
        {
            Card card = cardList.get((int) (Math.random() * cardList.size()));
            return card;
        }

        return null;
    }

    @MessageMapping("/startGame")
    public void startGame(Information information, SimpMessageHeaderAccessor headerAccessor)
    {
        if (information.getCommander().equals("Derevi"))
        {
            deck = cardRepository.getDereviDeck();
        }
        else
        {
            deck = cardRepository.getXenagosDeck();
        }
        Card commander = deck.remove(getCommanderCard(deck));
        Collections.shuffle(deck);
        deck.add(deck.size(), commander);

        SimpMessageHeaderAccessor ha = SimpMessageHeaderAccessor
                .create(SimpMessageType.MESSAGE);
        ha.setSessionId(headerAccessor.getSessionId());
        ha.setLeaveMutable(true);
        messagingTemplate.convertAndSendToUser(headerAccessor.getSessionId(), "/queue/startGame", deck, ha.getMessageHeaders());
    }

    private int getCommanderCard(List<Card> dereviDeck)
    {
        return dereviDeck.size() - 1;
    }

    @MessageMapping("/shareCard")
    public void shareCard(@Payload Card message, SimpMessageHeaderAccessor headerAccessor)
    {

        for (Map.Entry<String, String> stringStringEntry : webSocketConfig.userSessionIdMap.entrySet())
        {
            if (!stringStringEntry.getValue().equals(headerAccessor.getSessionId()))
            {
                SimpMessageHeaderAccessor ha = SimpMessageHeaderAccessor
                        .create(SimpMessageType.MESSAGE);
                ha.setSessionId(stringStringEntry.getValue());
                ha.setLeaveMutable(true);
                messagingTemplate.convertAndSendToUser(stringStringEntry.getValue(), "/queue/shareOpponentCard", message, ha.getMessageHeaders());
            }
        }
    }

    @MessageMapping("/removeCard")
    public void removeCard(@Payload Card message, SimpMessageHeaderAccessor headerAccessor)
    {

        for (Map.Entry<String, String> stringStringEntry : webSocketConfig.userSessionIdMap.entrySet())
        {
            if (!stringStringEntry.getValue().equals(headerAccessor.getSessionId()))
            {
                SimpMessageHeaderAccessor ha = SimpMessageHeaderAccessor
                        .create(SimpMessageType.MESSAGE);
                ha.setLeaveMutable(true);
                ha.setSessionId(stringStringEntry.getValue());
                messagingTemplate.convertAndSendToUser(stringStringEntry.getValue(), "/queue/removeCard", message, ha.getMessageHeaders());
            }
        }
    }

    @MessageMapping("/tapCard")
    public void tapCard(@Payload Card message, SimpMessageHeaderAccessor headerAccessor)
    {
        for (Map.Entry<String, String> stringStringEntry : webSocketConfig.userSessionIdMap.entrySet())
        {
            if (!stringStringEntry.getValue().equals(headerAccessor.getSessionId()))
            {
                SimpMessageHeaderAccessor ha = SimpMessageHeaderAccessor
                        .create(SimpMessageType.MESSAGE);
                ha.setLeaveMutable(true);
                ha.setSessionId(stringStringEntry.getValue());
                messagingTemplate.convertAndSendToUser(stringStringEntry.getValue(), "/queue/tapCard", message, ha.getMessageHeaders());
            }
        }
    }

    @MessageMapping("/getOpponentsInfo")
    public void getOpponentsInformation(SimpMessageHeaderAccessor headerAccessor)
    {
        for (Map.Entry<String, String> stringStringEntry : webSocketConfig.userSessionIdMap.entrySet())
        {
            if (!stringStringEntry.getValue().equals(headerAccessor.getSessionId()))
            {
                SimpMessageHeaderAccessor ha = SimpMessageHeaderAccessor
                        .create(SimpMessageType.MESSAGE);
                ha.setLeaveMutable(true);
                ha.setSessionId(stringStringEntry.getValue());
                messagingTemplate.convertAndSendToUser(stringStringEntry.getValue(), "/queue/getInfo", new Object(), ha.getMessageHeaders());
            }
        }
    }

    @MessageMapping("/shareOpponentsInfo")
    public void shareOpponentsInformation(@Payload List<String> deckList, SimpMessageHeaderAccessor headerAccessor)
    {
        for (Map.Entry<String, String> stringStringEntry : webSocketConfig.userSessionIdMap.entrySet())
        {
            if (!stringStringEntry.getValue().equals(headerAccessor.getSessionId()))
            {
                SimpMessageHeaderAccessor ha = SimpMessageHeaderAccessor
                        .create(SimpMessageType.MESSAGE);
                ha.setLeaveMutable(true);
                ha.setSessionId(stringStringEntry.getValue());
                messagingTemplate.convertAndSendToUser(stringStringEntry.getValue(), "/queue/shareInfo", deckList, ha.getMessageHeaders());
            }
        }
    }

    @MessageMapping("/saveHand")
    public void saveHand(@Payload String line, SimpMessageHeaderAccessor headerAccessor)
    {
        try
        {
            PrintWriter printWriter = new PrintWriter("Hello1.txt");
            printWriter.write(line);

            printWriter.flush();
            printWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @MessageMapping("/loadHand")
    public void loadHand(@Payload String line, SimpMessageHeaderAccessor headerAccessor)
    {

        List<Card> loadHand = new ArrayList<>();

        BufferedReader br = null;
        FileReader fr = null;

        try
        {

            fr = new FileReader("Hello1.txt");
            br = new BufferedReader(fr);

            String sCurrentLine = null;

            br = new BufferedReader(new FileReader("Hello1.txt"));

            List<String> hand = new ArrayList<>();
            List<String> result = new ArrayList<>();

            while ((sCurrentLine = br.readLine()) != null)
            {
                System.out.println(sCurrentLine);
                String[] split = sCurrentLine.substring(1, sCurrentLine.length() - 1).split("},");
                hand = Arrays.asList(split);
            }

            for (String s : hand)
            {
                result.add(s + "}");
            }

            for (String s : result)
            {
                JsonReader jsonReader = Json.createReader(new StringReader(s));
                JsonObject object = jsonReader.readObject();

                loadHand.add(
                        new Card(object.get("name").toString().substring(1,object.get("name").toString().length()-1),
                                object.get("id").toString().substring(1,object.get("id").toString().length()-1),
                                object.get("src").toString().substring(1,object.get("src").toString().length()-1)));

                jsonReader.close();
            }

            SimpMessageHeaderAccessor ha = SimpMessageHeaderAccessor
                    .create(SimpMessageType.MESSAGE);
            ha.setSessionId(headerAccessor.getSessionId());
            ha.setLeaveMutable(true);
            messagingTemplate.convertAndSendToUser(headerAccessor.getSessionId(), "/queue/loadHand", loadHand, ha.getMessageHeaders());

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
