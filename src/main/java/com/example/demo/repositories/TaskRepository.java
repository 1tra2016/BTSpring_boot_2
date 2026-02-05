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
    private Long currentId = 11l;

    public TaskRepository(UserRepository userRepository) {
        this.userRepository = userRepository;

        tasks.add(new Task(1L, "Setup project", "Create Spring Boot project", Priority.HIGH, 1l));
        tasks.add(new Task(2L, "Design API", "Design REST endpoints", Priority.HIGH, 2l));
        tasks.add(new Task(3L, "Write models", "Create Task models", Priority.MEDIUM, 2l));
        tasks.add(new Task(4L, "Create repository", "Hardcode repository", Priority.MEDIUM, 2l));
        tasks.add(new Task(5L, "Implement service", "Business logic layer", Priority.LOW, 3l));
        tasks.add(new Task(6L, "Create controllers", "Expose REST API", Priority.HIGH, 3l));
        tasks.add(new Task(7L, "Test API", "Use Postman", Priority.MEDIUM, 1l));
        tasks.add(new Task(8L, "Fix bug", "Resolve startup error", Priority.HIGH, 2l));
        tasks.add(new Task(9L, "Refactor code", "Improve structure", Priority.LOW, 3l));
        tasks.add(new Task(10L, "Write report", "Prepare documentation", Priority.MEDIUM, 1l));
    }

    public List<Task> findAll() {
        return tasks;
    }
    public void save(Task task){
        task.setId(currentId++);
        tasks.add(task);
    }
}
