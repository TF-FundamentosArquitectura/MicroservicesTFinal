package com.bliss.notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bliss.notification.model.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
