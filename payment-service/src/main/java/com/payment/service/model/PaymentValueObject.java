package com.payment.service.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class PaymentValueObject {
        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        Long id;
        Long orderId;
        double amount;
        String paymentStatus;
}
