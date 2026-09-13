package com.example.makeup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.makeup.model.Product;
import com.example.makeup.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }


    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }


    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }


    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }


    public List<Product> searchProducts(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return productRepository.findAll();
        }
        return productRepository.findByNameContainingIgnoreCase(keyword);
    }


    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }
}