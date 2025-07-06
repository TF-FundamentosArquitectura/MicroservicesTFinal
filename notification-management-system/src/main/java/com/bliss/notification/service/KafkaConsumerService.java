package com.bliss.notification.service;

import com.bliss.notification.model.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class KafkaConsumerService {

    private static final Logger log = LoggerFactory.getLogger(KafkaConsumerService.class);
    private static final String USER_REGISTERED_TOPIC = "user-events-topic";

    @Autowired
    private NotificationRepository notificationRepository; // Re-using existing repository

    @KafkaListener(topics = USER_REGISTERED_TOPIC, groupId = "notification-group",
                   containerFactory = "kafkaListenerContainerFactory") // Assuming a container factory is configured for UserEventDto
    public void listenUserRegisteredEvent(@Payload UserEventDto userEvent) {
        log.info("Received user_registered event from Kafka topic '{}': {}", USER_REGISTERED_TOPIC, userEvent.toString());

        try {
            // Create a notification based on the event
            Notification notification = new Notification();
            notification.setUserId(userEvent.getId()); // Assuming Notification model has a userId field
            notification.setMessage("Welcome " + userEvent.getUsername() + "! Your registration is successful.");
            notification.setType("USER_REGISTRATION");
            notification.setCreatedDate(LocalDateTime.now());
            notification.setRead(false); // Default to unread

            notificationRepository.save(notification);
            log.info("Notification saved for user ID: {}. Message: {}", userEvent.getId(), notification.getMessage());

            // Here you would typically trigger an actual notification mechanism (email, SMS, push notification)
            // For this task, logging is sufficient to show the message was processed.
            System.out.println("SIMULATING SENDING NOTIFICATION: " + notification.getMessage() + " (User ID: " + userEvent.getId() + ")");

        } catch (Exception e) {
            log.error("Error processing user_registered event for user ID {}: {}", userEvent.getId(), e.getMessage(), e);
            // Handle error, maybe send to a dead-letter queue or log for manual intervention
        }
    }
}
