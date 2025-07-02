package com.bliss.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bliss.payment.repository.PaymentRepository;
import com.bliss.payment.model.Payment;

import java.time.LocalDateTime;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment createPayment(Payment payment) {
        payment.setPaymentDate(LocalDateTime.now());  // Establecer la fecha del pago
        return paymentRepository.save(payment);
    }

    public Payment getPayment(Long id) {
        return paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("Payment not found"));
    }

    public void updatePaymentStatus(Long id, String status) {
        Payment payment = paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("Payment not found"));
        payment.setStatus(status);
        paymentRepository.save(payment);
    }
}
