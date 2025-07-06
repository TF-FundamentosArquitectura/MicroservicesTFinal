package com.bliss.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.bliss.user.repository.UserRepository;
import com.bliss.user.model.User; // Assuming User model has getId(), getUsername(), getEmail()

import java.time.LocalDateTime;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    private static final String USER_REGISTERED_TOPIC = "user-events-topic";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate; // Using Object, ideally a specific DTO/User object after JSON serialization

    public User registerUser(User user) {
        user.setCreatedDate(LocalDateTime.now());
        User savedUser = userRepository.save(user);
        log.info("User saved to database with ID: {}", savedUser.getId());

        // Create a simple representation of the user for the Kafka message
        // In a real app, this would be a well-defined DTO.
        UserEventDto userEvent = new UserEventDto(savedUser.getId(), savedUser.getUsername(), savedUser.getEmail());

        try {
            kafkaTemplate.send(USER_REGISTERED_TOPIC, savedUser.getId().toString(), userEvent);
            log.info("User registered event published to Kafka topic '{}' for user ID: {}", USER_REGISTERED_TOPIC, savedUser.getId());
        } catch (Exception e) {
            log.error("Error publishing user registered event to Kafka for user ID: {}. Error: {}", savedUser.getId(), e.getMessage(), e);
            // Potentially handle the error, e.g., retry, or mark user for later notification
        }
        return savedUser;
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setRole(user.getRole());
        return userRepository.save(existingUser);
    }
}