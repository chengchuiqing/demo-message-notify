package com.example.common.dto;


import lombok.Data;


/**
 * 会话通知的消息
 */
@Data
public class MessageRequest {
    private String sessionId;
    private String message;
}
