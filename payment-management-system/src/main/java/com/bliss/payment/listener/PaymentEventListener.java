package com.bliss.payment.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentEventListener {

    // Método que escucha los mensajes del topic "payment-events"
    @KafkaListener(topics = "payment-events", groupId = "payment-group")  // El nombre del grupo de consumidores
    public void listen(String message) {
        System.out.println("Evento recibido en Kafka: " + message);  // Procesa el evento recibido
        // Aquí puedes realizar alguna acción adicional como actualizar el estado del pago o registrar la información
    }
}
