package com.order.service.proxy;

import com.order.service.client.PaymentServiceFeignClient;
import com.payment.service.model.PaymentValueObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceProxy {
    @Autowired
    private PaymentServiceFeignClient paymentServiceFeignClient;

    public PaymentValueObject processPayment(PaymentValueObject paymentValueObject) {
        return paymentServiceFeignClient.processPayment(paymentValueObject);
    }
}
