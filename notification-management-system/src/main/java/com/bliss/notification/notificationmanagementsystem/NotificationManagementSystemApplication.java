package com.bliss.notification.notificationmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
// import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(scanBasePackages = "com.bliss.notification")
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = "com.bliss.notification.repository") // Also good to be explicit for JPA
@ComponentScan(basePackages = "com.bliss.notification") // Ensures all components, services are scanned
public class NotificationManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationManagementSystemApplication.class, args);
    }

}
