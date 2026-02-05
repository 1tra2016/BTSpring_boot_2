package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(@RequestParam(required = false) String search) {
        List<User> users = userService.findAllUsers();
        if (search != null && !search.isEmpty()) {
            users = users.stream()
                    .filter(u -> u.getUsername().toLowerCase().contains(search.toLowerCase()))
                    .toList();
        }
        return ResponseEntity.ok(users);
    }
}
