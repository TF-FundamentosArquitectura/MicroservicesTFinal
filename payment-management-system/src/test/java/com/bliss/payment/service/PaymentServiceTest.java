package com.bliss.payment.service;

import com.bliss.payment.paymentmanagementsystem.PaymentManagementSystemApplication;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import com.bliss.payment.model.Payment;
import com.bliss.payment.repository.PaymentRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = PaymentManagementSystemApplication.class)
public class PaymentServiceTest {

    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private PaymentService paymentService;

    @Test
    public void testCreatePayment() {
        Payment payment = new Payment();
        payment.setAppointmentId(1L);
        payment.setAmount(100.0);
        payment.setStatus("Pending");
        payment.setPaymentMethod("Credit Card");

        Mockito.when(paymentRepository.save(Mockito.any(Payment.class))).thenReturn(payment);

        Payment createdPayment = paymentService.createPayment(payment);

        assertNotNull(createdPayment);
        assertEquals(100.0, createdPayment.getAmount());
        assertEquals("Pending", createdPayment.getStatus());
    }

    @Test
    public void testGetPayment() {
        Payment payment = new Payment();
        payment.setAppointmentId(1L);
        payment.setAmount(100.0);
        payment.setStatus("Pending");
        payment.setPaymentMethod("Credit Card");

        Mockito.when(paymentRepository.findById(1L)).thenReturn(java.util.Optional.of(payment));

        Payment fetchedPayment = paymentService.getPayment(1L);

        assertNotNull(fetchedPayment);
        assertEquals(100.0, fetchedPayment.getAmount());
    }
}
