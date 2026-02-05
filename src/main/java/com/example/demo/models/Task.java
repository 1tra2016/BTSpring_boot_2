package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Priority priority;

    @Column(name = "assigned_user_id")
    private Long assignedUserId;

    public Task(Long id, String title, String description, Priority priority, Long assignedUserId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.assignedUserId = assignedUserId;
    }

    public Task(String title, String description, Priority priority, Long assignedUserId) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.assignedUserId = assignedUserId;
    }

    public Task() {}
}
