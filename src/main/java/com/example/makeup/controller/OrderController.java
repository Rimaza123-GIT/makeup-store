package com.example.makeup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.makeup.model.Order;
import com.example.makeup.service.CartService;
import com.example.makeup.service.OrderService;

@Controller
public class OrderController {

    @Autowired
    private OrderService service;

    @Autowired
    private CartService cartService;




    @PostMapping("/placeOrder")
    public String placeOrder(Order order) {

        double totalPrice = cartService.getAllCartItems()
                .stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();

        order.setTotal(totalPrice);

        service.saveOrder(order);
        cartService.clearCart();

        return "success";
    }

    @GetMapping("/orders")
    public String viewOrders(Model model) {

        model.addAttribute("orders", service.getAllOrders());

        return "orders";
    }
}