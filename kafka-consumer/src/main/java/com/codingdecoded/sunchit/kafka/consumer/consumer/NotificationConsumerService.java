package com.codingdecoded.sunchit.kafka.consumer.consumer;

import com.codingdecoded.sunchit.kafka.consumer.model.DriverLocation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumerService {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(
            topics = "${kafka.topic.driver-location}",
            groupId = "${spring.kafka.consumer.notification.group-id}",
            concurrency = "1"
    )
    public void consume(ConsumerRecord<String, String> record) {
        try {
            String value = record.value();
            DriverLocation location = objectMapper.readValue(value, DriverLocation.class);

            System.out.println("🔔 [App Notification] Received driver update:");
            System.out.println("   Driver ID: " + location.getDriverId());
            System.out.println("   Coordinates: " + location.getLatitude() + ", " + location.getLongitude());
            System.out.println("   Timestamp: " + location.getTimestamp());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
