package com.bliss.review.reviewmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableEurekaServer
public class ReviewManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReviewManagementSystemApplication.class, args);
    }
}
