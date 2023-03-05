package com.order.service.client;

import com.payment.service.model.PaymentValueObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@Service
@FeignClient(name = "payment-service", url = "http://localhost:8081")
public interface PaymentServiceFeignClient {
    @PostMapping("/payments")
    PaymentValueObject processPayment(@RequestBody PaymentValueObject paymentValueObject);
}
