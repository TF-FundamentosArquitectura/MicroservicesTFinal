package com.bliss.payment.paymentmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
// @EnableDiscoveryClient // Typically auto-configured
public class PaymentManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentManagementSystemApplication.class, args);
    }

}
