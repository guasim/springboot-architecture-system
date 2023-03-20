package com.guasim.dev.ms.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guasim.dev.ms.order.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
