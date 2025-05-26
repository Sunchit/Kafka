package com.codingdecoded.sunchit.kafka.consumer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${kafka.topic.driver-location}")
    private String topicName;
    
    @Value("${kafka.topic.partitions}")
    private int partitions;

    @Value("${kafka.topic.replicas}")
    private int replicas;

    @Bean
    public NewTopic driverLocationTopic() {
        return TopicBuilder.name(topicName)
                .partitions(partitions)
                .replicas(replicas)
                .build();
    }
} 