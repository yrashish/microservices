package com.order.service.repository;

import com.order.service.model.OrderValueObject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderValueObject, Long> {
}