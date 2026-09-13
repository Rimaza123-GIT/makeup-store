package com.example.makeup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.makeup.model.Wishlist;
import com.example.makeup.repository.WishlistRepository;

@Controller
public class WishlistController {

    @Autowired
    private WishlistRepository repository;

    @PostMapping("/wishlist/add")
    public String addWishlist(@RequestParam String productName,
                              @RequestParam double price,
                              @RequestParam String image) {

        Wishlist wishlist = new Wishlist();
        wishlist.setProductName(productName);
        wishlist.setPrice(price);
        wishlist.setImage(image);

        repository.save(wishlist);

        return "redirect:/wishlist";
    }

    @GetMapping("/wishlist")
    public String wishlist(Model model) {
        List<Wishlist> list = repository.findAll();
        model.addAttribute("wishlist", list);
        return "wishlist";
    }

    @GetMapping("/wishlist/delete/{id}")
    public String deleteWishlist(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/wishlist";
    }

}