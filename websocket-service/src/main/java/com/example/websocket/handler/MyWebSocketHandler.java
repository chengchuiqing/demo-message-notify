package com.example.websocket.handler;

import com.example.websocket.service.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Map;


@Component
public class MyWebSocketHandler extends TextWebSocketHandler {

    @Autowired
    private WebSocketService webSocketService;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        Map<String, Object> attributes = session.getAttributes();
        String userId = attributes.get("userId").toString();
        webSocketService.addSession(userId, session);
        System.out.println("Connected: " + userId);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        Map<String, Object> attributes = session.getAttributes();
        String userId = attributes.get("userId").toString();
        webSocketService.removeSession(userId, session.getId());
        System.out.println("Disconnected: " + userId);
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        // 处理接收到的消息
    }
}