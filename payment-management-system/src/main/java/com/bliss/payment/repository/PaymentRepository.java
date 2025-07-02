package com.bliss.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bliss.payment.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
