package com.magic;

import com.utils.UserName;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pawel on 04.03.17.
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    private int licznik = 0;
    public Map<String, String> userSessionIdMap = new HashMap<>();

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic", "/queue");
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/gs-guide-websocket").setHandshakeHandler(new RandomUsernameHandshakeHandler()).withSockJS();
    }

    private class RandomUsernameHandshakeHandler extends DefaultHandshakeHandler {

        @Override
        protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {
//            WebSocketServerSockJsSession sockJsSession = ((SockJsWebSocketHandler) wsHandler).sockJsSession();
            Principal principal = request.getPrincipal();

            String[] split = request.getURI().getPath().split("/");
            String sessionId = split[split.length - 2];

            if (principal == null) {
                principal = new UsernamePasswordAuthenticationToken(UserName.userName.get(licznik), null);

                userSessionIdMap.put(UserName.userName.get(licznik), sessionId);
//                userSessionIdMap.put(UserName.userName.get(licznik), wsHandler1.);
                licznik++;
                if (licznik == 2) {
                    licznik = 0;
                }
            }

            return principal;
        }

    }
}
