package com.example.makeup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.makeup.service.CartService;

@Controller
public class CheckoutController {

    @Autowired
    private CartService cartService;

    @GetMapping("/checkout")
    public String checkout(Model model) {

        double totalPrice = cartService.getAllCartItems()
                .stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();

        model.addAttribute("totalPrice", totalPrice);

        return "checkout";
    }
}