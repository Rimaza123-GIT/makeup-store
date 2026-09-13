package com.example.makeup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.makeup.model.User;
import com.example.makeup.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User register(User user) {
        return repo.save(user);
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public User getUserById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public User updateUser(User user) {
        return repo.save(user);
    }

    public void deleteUser(Long id) {
        repo.deleteById(id);
    }

    public User login(String email, String password) {
        System.out.println("Email: " + email);

        User user = repo.findByEmail(email).orElse(null);

        System.out.println("User: " + user);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }


        }

