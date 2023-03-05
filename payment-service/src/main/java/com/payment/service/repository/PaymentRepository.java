package com.payment.service.repository;

import com.payment.service.model.PaymentValueObject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentValueObject, Long> {
}
