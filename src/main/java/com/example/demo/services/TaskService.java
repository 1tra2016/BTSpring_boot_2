package com.example.demo.services;


import com.example.demo.models.Task;
import com.example.demo.models.User;
import com.example.demo.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserService userService;

    @Autowired
    public TaskService(TaskRepository taskRepository, UserService  userService) {
        this.taskRepository = taskRepository;
        this.userService = userService;
        
    }

    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    public Task addTask(Task newTask) {
        Long userId = newTask.getAssignedUserId();

        if (userId == null) {
            return null;
        }

        User user = userService.findUserById(userId);
        if (user == null) {
            return null;
        }

        taskRepository.addTask(newTask);
        return newTask;
    }

    public Task  updateTask(Long id, Task newTask) {
        return taskRepository.save(id, newTask);
    }

    public boolean deleteById(Long id){
        Task task = taskRepository.findById(id);
        if (task == null) return false;
        return taskRepository.deleteById(id);
    }
}
