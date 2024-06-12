package com.example.kafkaproducer.dto;

import lombok.Data;

@Data
public class CommentMessage {
    private String recipientId;  // 接收人
    private String commenterId;  // 评论人
    private String comment;
}
