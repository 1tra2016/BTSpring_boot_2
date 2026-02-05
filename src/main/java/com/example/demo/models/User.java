package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_name", nullable = false)
    private String username;

    private String email;
    @Column(nullable = false)
    private String role;

    public User(Long id, String name, String email, String role) {
        this.id = id;
        this.username = name;
        this.email = email;
        this.role = role;
    }

    public User() {

    }
}
