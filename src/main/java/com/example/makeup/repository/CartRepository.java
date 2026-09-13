package com.example.makeup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.makeup.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}