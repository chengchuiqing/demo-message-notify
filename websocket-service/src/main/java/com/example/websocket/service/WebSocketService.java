package com.example.websocket.service;

import com.example.common.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class WebSocketService {

    @Autowired
    private RedisService redisService;

    private final ConcurrentHashMap<String, WebSocketSession> sessions = new ConcurrentHashMap<>();

    public void addSession(String userId, WebSocketSession session) {
        sessions.put(session.getId(), session);
        redisService.saveSession(userId, session.getId());
    }

    public void removeSession(String userId, String sessionId) {
        sessions.remove(sessionId);
        redisService.deleteSession(userId);
    }

    public void sendMessageToUser(String sessionId, String message) throws IOException {
        WebSocketSession session = sessions.get(sessionId);
        if (session != null && session.isOpen()) {
            session.sendMessage(new TextMessage(message));
        }
    }
}