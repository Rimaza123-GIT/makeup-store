package com.example.makeup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.makeup.model.Cart;
import com.example.makeup.service.CartService;

@Controller
public class CartController {

    @Autowired
    private CartService service;

    @PostMapping("/cart/add")
    public String addToCart(@RequestParam String productName,
                            @RequestParam double price,
                            @RequestParam int quantity) {

        Cart cart = new Cart();
        cart.setProductName(productName);
        cart.setPrice(price);
        cart.setQuantity(quantity);

        service.addToCart(cart);

        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String viewCart(Model model) {

        model.addAttribute("cartItems", service.getAllCartItems());

        double total = service.getAllCartItems()
                .stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();

        model.addAttribute("totalPrice", total);

        return "cart";
    }

    @GetMapping("/cart/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        service.removeItem(id);
        return "redirect:/cart";
    }
}