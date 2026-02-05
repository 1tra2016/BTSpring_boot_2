package com.example.demo.repositories;

import com.example.demo.models.Priority;
import com.example.demo.models.Task;
import com.example.demo.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {
    private final List<Task> tasks = new ArrayList<>();
    private final UserRepository userRepository;

    public TaskRepository(UserRepository userRepository) {
        this.userRepository = userRepository;

        User user1 = userRepository.findById(1L);
        User user2 = userRepository.findById(2L);
        User user3 = userRepository.findById(3L);

        tasks.add(new Task(1L, "Setup project", "Create Spring Boot project", Priority.HIGH, user1));
        tasks.add(new Task(2L, "Design API", "Design REST endpoints", Priority.HIGH, user1));
        tasks.add(new Task(3L, "Write models", "Create Task models", Priority.MEDIUM, user2));
        tasks.add(new Task(4L, "Create repository", "Hardcode repository", Priority.MEDIUM, user2));
        tasks.add(new Task(5L, "Implement service", "Business logic layer", Priority.LOW, user3));
        tasks.add(new Task(6L, "Create controllers", "Expose REST API", Priority.HIGH, user3));
        tasks.add(new Task(7L, "Test API", "Use Postman", Priority.MEDIUM, user1));
        tasks.add(new Task(8L, "Fix bug", "Resolve startup error", Priority.HIGH, user2));
        tasks.add(new Task(9L, "Refactor code", "Improve structure", Priority.LOW, user3));
        tasks.add(new Task(10L, "Write report", "Prepare documentation", Priority.MEDIUM, user1));
    }

    public List<Task> findAll() {
        return tasks;
    }
}
