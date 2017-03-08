package com.magic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by pawel on 08.03.17.
 */
@Controller
public class PersonalController {

    @Autowired
    public SimpMessageSendingOperations messagingTemplate;

    @MessageMapping("/personal")
    public void personalMessage(SimpMessageHeaderAccessor headerAccessor) {

        SimpMessageHeaderAccessor ha = SimpMessageHeaderAccessor
                .create(SimpMessageType.MESSAGE);
        ha.setSessionId(headerAccessor.getSessionId());
        ha.setLeaveMutable(true);
        messagingTemplate.convertAndSendToUser(headerAccessor.getSessionId(), "/queue/reply", "HEJ", ha.getMessageHeaders());
    }
}
