package com.example.kafkaconsumer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {
    // Kafka配置，若有需要可以在此处添加具体配置
}