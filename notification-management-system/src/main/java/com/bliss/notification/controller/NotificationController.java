package com.bliss.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bliss.notification.model.Notification;
import com.bliss.notification.service.NotificationService;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/create")
    public Notification createNotification(@RequestBody Notification notification) {
        return notificationService.createNotification(notification);
    }

    @GetMapping("/{id}")
    public Notification getNotification(@PathVariable Long id) {
        return notificationService.getNotification(id);
    }
}
