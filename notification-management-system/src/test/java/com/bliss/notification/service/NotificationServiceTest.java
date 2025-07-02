package com.bliss.notification.service;

import com.bliss.notification.notificationmanagementsystem.NotificationManagementSystemApplication;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import com.bliss.notification.model.Notification;
import com.bliss.notification.repository.NotificationRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = NotificationManagementSystemApplication.class)
public class NotificationServiceTest {

    @Mock
    private NotificationRepository notificationRepository;

    @InjectMocks
    private NotificationService notificationService;

    @Test
    public void testCreateNotification() {
        Notification notification = new Notification();
        notification.setUserId(1L);
        notification.setMessage("Appointment reminder");
        notification.setStatus("Sent");

        Mockito.when(notificationRepository.save(Mockito.any(Notification.class))).thenReturn(notification);

        Notification createdNotification = notificationService.createNotification(notification);

        assertNotNull(createdNotification);
        assertEquals("Appointment reminder", createdNotification.getMessage());
        assertEquals("Sent", createdNotification.getStatus());
    }

    @Test
    public void testGetNotification() {
        Notification notification = new Notification();
        notification.setUserId(1L);
        notification.setMessage("Appointment reminder");
        notification.setStatus("Sent");

        Mockito.when(notificationRepository.findById(1L)).thenReturn(java.util.Optional.of(notification));

        Notification fetchedNotification = notificationService.getNotification(1L);

        assertNotNull(fetchedNotification);
        assertEquals("Appointment reminder", fetchedNotification.getMessage());
    }
}
