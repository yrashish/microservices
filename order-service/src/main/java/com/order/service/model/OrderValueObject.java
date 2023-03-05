package com.order.service.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class OrderValueObject {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String customerName;
    private String productName;
    private Double price;
    private String paymentStatus;

}
