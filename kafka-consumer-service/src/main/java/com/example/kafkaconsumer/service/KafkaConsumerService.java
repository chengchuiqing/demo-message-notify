package com.example.kafkaconsumer.service;

import com.example.common.dto.MessageRequest;
import com.example.common.redis.RedisService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class KafkaConsumerService {

    @Autowired
    private RedisService redisService;

    private final RestTemplate restTemplate = new RestTemplate();

    @KafkaListener(topics = "comment-topic", groupId = "my-group")
    public void listen(String message) {
        try {
            // 假设message是JSON格式，解析为Map
            Map<String, String> msgMap = new ObjectMapper().readValue(message, Map.class);
            String userId = msgMap.get("recipientId");  // 接收人ID
            String comment = msgMap.get("comment");

            // 获取WebSocket会话ID
            String sessionId = redisService.getSessionId(userId);
            if (sessionId != null) {
                // 通过HTTP接口通知WebSocket服务发送消息
                MessageRequest request = new MessageRequest();
                request.setSessionId(sessionId);
                request.setMessage(comment);
                restTemplate.postForObject("http://localhost:8080/ws/send", request, Void.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}