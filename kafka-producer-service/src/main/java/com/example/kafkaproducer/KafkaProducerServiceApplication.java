package com.example.kafkaproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = {"com.example.kafkaproducer", "com.example.common"})
@SpringBootApplication
public class KafkaProducerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerServiceApplication.class, args);
    }

}
