package com.order.service.controller;

import com.order.service.model.OrderValueObject;
import com.order.service.proxy.PaymentServiceProxy;
import com.order.service.repository.OrderRepository;
import com.payment.service.model.PaymentValueObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentServiceProxy paymentServiceProxy;

    @PostMapping("/orders")
    public OrderValueObject createOrder(@RequestBody OrderValueObject orderValueObject) {
        orderValueObject.setPaymentStatus("pending");
        OrderValueObject savedOrderValueObject = orderRepository.save(orderValueObject);

        PaymentValueObject paymentValueObject = new PaymentValueObject();
        paymentValueObject.setOrderId(savedOrderValueObject.getId());
        paymentValueObject.setAmount(savedOrderValueObject.getPrice());
        paymentValueObject.setPaymentStatus("pending");
        PaymentValueObject savedPaymentValueObject = paymentServiceProxy.processPayment(paymentValueObject);

        return orderRepository.save(savedOrderValueObject);
    }

    @GetMapping("/orders/{id}")
    public OrderValueObject getOrder(@PathVariable Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }
}

