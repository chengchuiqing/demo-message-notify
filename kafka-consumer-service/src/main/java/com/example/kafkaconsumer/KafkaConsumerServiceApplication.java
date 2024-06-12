package com.example.kafkaconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("com.example")
@SpringBootApplication
public class KafkaConsumerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaConsumerServiceApplication.class, args);
    }

}
