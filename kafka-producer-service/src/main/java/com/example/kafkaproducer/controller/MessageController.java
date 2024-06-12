package com.example.kafkaproducer.controller;

import com.example.kafkaproducer.dto.CommentMessage;
import com.example.kafkaproducer.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/onComment")
    public void sendMessage(@RequestBody CommentMessage commentMessage) {
        // 保存评论到数据库的逻辑...

        // 发布消息到Kafka
        messageService.sendMessage(commentMessage);
    }
}