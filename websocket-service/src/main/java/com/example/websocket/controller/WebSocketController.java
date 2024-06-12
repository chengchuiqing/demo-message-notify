package com.example.websocket.controller;

import com.example.common.dto.MessageRequest;
import com.example.websocket.service.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/ws")
public class WebSocketController {

    @Autowired
    private WebSocketService webSocketService;

    @PostMapping("/send")
    public void sendMessage(@RequestBody MessageRequest request) {
        try {
            webSocketService.sendMessageToUser(request.getSessionId(), request.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}