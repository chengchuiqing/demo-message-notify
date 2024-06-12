package com.example.kafkaproducer.service;

import com.example.kafkaproducer.dto.CommentMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(CommentMessage commentMessage) {
        kafkaTemplate.send("comment-topic", commentMessage);
    }
}