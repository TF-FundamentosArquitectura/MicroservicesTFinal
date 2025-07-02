package com.bliss.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bliss.payment.model.Payment;
import com.bliss.payment.service.PaymentService;
import com.bliss.payment.service.PaymentEventPublisher;  // Importar el PaymentEventPublisher

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private PaymentEventPublisher paymentEventPublisher;  // Inyectar el PaymentEventPublisher

    // Endpoint para crear un pago
    @PostMapping("/create")
    public Payment createPayment(@RequestBody Payment payment) {
        // Crear el pago en la base de datos
        Payment createdPayment = paymentService.createPayment(payment);

        // Publicar un evento en Kafka
        String paymentMessage = "Pago procesado con éxito. ID: " + createdPayment.getId();
        paymentEventPublisher.publishEvent(paymentMessage);  // Publicar el evento a Kafka

        // Retornar el pago creado
        return createdPayment;
    }

    // Endpoint para obtener un pago por ID
    @GetMapping("/{id}")
    public Payment getPayment(@PathVariable Long id) {
        return paymentService.getPayment(id);
    }

    // Endpoint para actualizar el estado de un pago
    @PutMapping("/updateStatus/{id}")
    public void updatePaymentStatus(@PathVariable Long id, @RequestParam String status) {
        paymentService.updatePaymentStatus(id, status);
    }
}
