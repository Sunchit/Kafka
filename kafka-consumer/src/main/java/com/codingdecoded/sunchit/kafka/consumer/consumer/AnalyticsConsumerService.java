package com.codingdecoded.sunchit.kafka.consumer.consumer;

import com.codingdecoded.sunchit.kafka.consumer.model.DriverLocation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AnalyticsConsumerService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "${kafka.topic.driver-location}", groupId = "${analytics.consumer.group-id}")
    public void consume(ConsumerRecord<String, String> record) {
        try {
            String key = record.key();
            String value = record.value();

            DriverLocation location = objectMapper.readValue(value, DriverLocation.class);

            System.out.println("📊 Analytics consumer received location update for driver " + location.getDriverId());
            System.out.println("   Coordinates: " + location.getLatitude() + ", " + location.getLongitude());
            System.out.println("   Time: " + location.getTimestamp());

            processForAnalytics(location);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void processForAnalytics(DriverLocation location) {
        System.out.println("📈 Processing driver location for analytics: " + location.getDriverId());
    }
} 