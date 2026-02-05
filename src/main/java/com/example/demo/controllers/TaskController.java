package com.example.demo.controllers;

import com.example.demo.models.Task;
import com.example.demo.repositories.TaskRepository;
import com.example.demo.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(@RequestParam(required = false) String search) {
        List<Task> tasks = taskService.findAllTasks();
        if (search != null && !search.isEmpty()) {
            tasks = tasks.stream()
                    .filter(u -> u.getTitle().toLowerCase().contains(search.toLowerCase()))
                    .toList();
        }
        return ResponseEntity.ok(tasks);
    }
}
