package com.example.makeup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.makeup.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}