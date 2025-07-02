package com.bliss.notification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bliss.notification.repository.NotificationRepository;
import com.bliss.notification.model.Notification;

import java.time.LocalDateTime;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public Notification createNotification(Notification notification) {
        notification.setCreatedDate(LocalDateTime.now());  // Establecer la fecha de creación
        return notificationRepository.save(notification);
    }

    public Notification getNotification(Long id) {
        return notificationRepository.findById(id).orElseThrow(() -> new RuntimeException("Notification not found"));
    }
}
