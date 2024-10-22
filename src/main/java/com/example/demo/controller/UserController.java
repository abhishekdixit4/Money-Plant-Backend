package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

   @PostMapping
public ResponseEntity<Map<String, User>> createUser(@RequestBody User user) {
    User savedUser = userRepository.save(user);
    Map<String, User> response = new HashMap<>();
    response.put("user", savedUser);
    return ResponseEntity.ok(response);
}

    @GetMapping // Maps to GET requests to /api/users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}