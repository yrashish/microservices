package com.payment.service.controller;

import com.payment.service.model.PaymentValueObject;
import com.payment.service.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/payments")
public class PaymentController {
    @Autowired
    private PaymentRepository paymentRepository;

    @PostMapping("/payments")
    public PaymentValueObject processPayment(@RequestBody PaymentValueObject paymentValueObject) {
        // perform payment processing logic here
        paymentValueObject.setPaymentStatus("success");
        return paymentRepository.save(paymentValueObject);
    }
}
