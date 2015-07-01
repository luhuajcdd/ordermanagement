package com.dehua.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dehua.order.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
