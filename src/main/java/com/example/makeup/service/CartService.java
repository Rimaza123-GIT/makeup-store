package com.example.makeup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.makeup.model.Cart;
import com.example.makeup.repository.CartRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository repo;

    public Cart addToCart(Cart cart) {
        return repo.save(cart);
    }

    public List<Cart> getAllCartItems() {
        return repo.findAll();
    }

    public void removeItem(Long id) {
        repo.deleteById(id);
    }
    public void clearCart() {
        repo.deleteAll();
    }
}