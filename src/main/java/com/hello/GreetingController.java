package com.hello;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

/**
 * Created by pawel on 04.03.17.
 */
@Controller
public class GreetingController
{

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(@Payload HelloMessage message, SimpMessageHeaderAccessor headerAccessor) throws Exception
    {
        return new Greeting(headerAccessor.getUser().getName() + ": " + message.getName());
    }

}
