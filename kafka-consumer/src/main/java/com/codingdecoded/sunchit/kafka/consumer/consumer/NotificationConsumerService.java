package com.codingdecoded.sunchit.kafka.consumer.consumer;

import com.codingdecoded.sunchit.kafka.consumer.model.DriverLocation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumerService {

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "${kafka.topic.driver-location}", groupId = "${notification.consumer.group-id}")
    public void consume(ConsumerRecord<String, String> record) {
        try {
            String key = record.key();
            String value = record.value();

            DriverLocation location = objectMapper.readValue(value, DriverLocation.class);

            System.out.println("🔔 Notification consumer received location update for driver " + location.getDriverId());
            System.out.println("   Coordinates: " + location.getLatitude() + ", " + location.getLongitude());
            System.out.println("   Time: " + location.getTimestamp());

            sendNotifications(location);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendNotifications(DriverLocation location) {
        System.out.println("📱 Sending push notifications for driver: " + location.getDriverId());
    }
} 