package com.example.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void saveSession(String userId, String sessionId) {
        redisTemplate.opsForValue().set("WS_SESSION_" + userId, sessionId, 1, TimeUnit.HOURS);
    }

    public String getSessionId(String userId) {
        return (String) redisTemplate.opsForValue().get("WS_SESSION_" + userId);
    }

    public void deleteSession(String userId) {
        redisTemplate.delete("WS_SESSION_" + userId);
    }
}