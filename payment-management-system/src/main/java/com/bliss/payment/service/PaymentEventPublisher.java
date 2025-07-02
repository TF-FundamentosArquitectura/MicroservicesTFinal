package com.bliss.payment.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentEventPublisher {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;  // KafkaTemplate para enviar eventos

    private static final String TOPIC = "payment-events";  // Nombre del topic de Kafka

    // Método para publicar un evento a Kafka
    public void publishEvent(String message) {
        kafkaTemplate.send(TOPIC, message);  // Publica el evento al topic "payment-events"
        System.out.println("Mensaje enviado a Kafka: " + message);  // Puedes eliminar esto en producción
    }
}
