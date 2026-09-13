package com.example.makeup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.makeup.model.Product;
import com.example.makeup.service.ProductService;

@Controller
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public String products(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String category,
            Model model) {

        List<Product> products;

        if (keyword != null && !keyword.isEmpty()) {
            products = service.searchProducts(keyword);
        } else if (category != null && !category.isEmpty()) {
            products = service.getProductsByCategory(category);
        } else {
            products = service.getAllProducts();
        }

        model.addAttribute("products", products);
        model.addAttribute("keyword", keyword);
        model.addAttribute("category", category);

        return "product";
    }

    @GetMapping("/product/{id}")
    public String productDetails(@PathVariable Long id, Model model) {

        Product product = service.getProductById(id);

        model.addAttribute("product", product);

        return "product-Details";
    }
}