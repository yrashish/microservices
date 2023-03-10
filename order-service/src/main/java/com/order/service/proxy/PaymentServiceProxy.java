package com.order.service.proxy;

import com.order.service.client.PaymentServiceFeignClient;
import com.payment.service.model.PaymentValueObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentServiceProxy {
    @Autowired
    private PaymentServiceFeignClient paymentServiceFeignClient;

    private final RestTemplate restTemplate;

    public PaymentServiceProxy(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public PaymentValueObject processPayment(PaymentValueObject paymentValueObject) {
/*        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> request = new HttpEntity<>(paymentValueObject, headers);

        String url = "http://payment-service:8081/payments";
        return restTemplate.postForObject(url, request, PaymentValueObject.class);*/

        return paymentServiceFeignClient.processPayment(paymentValueObject);
    }
}
