package com.paraboliccheck.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paraboliccheck.entity.OrderModel;

public interface OrderRepository extends JpaRepository<OrderModel, Long> {

}
