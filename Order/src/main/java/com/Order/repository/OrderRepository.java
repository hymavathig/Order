package com.Order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Order.model.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{

}
