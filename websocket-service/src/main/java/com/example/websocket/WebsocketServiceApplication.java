package com.example.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.example")
@SpringBootApplication
public class WebsocketServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsocketServiceApplication.class, args);
    }

}
