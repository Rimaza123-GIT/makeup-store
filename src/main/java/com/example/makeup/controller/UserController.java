package com.example.makeup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.makeup.model.User;
import com.example.makeup.service.UserService;

@Controller
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public String register(User user) {
        service.register(user);
        return "redirect:/home";
    }
    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password) {

        User user = service.login(email, password);

        if (user != null) {
            return "home";
        }

        return "login";
    }

    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @PutMapping
    public User update(@RequestBody User user) {
        return service.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteUser(id);
        return "User Deleted";
    }
}