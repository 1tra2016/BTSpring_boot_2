package com.example.demo.repositories;

import com.example.demo.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private final List<User> users = new ArrayList<>();

    public UserRepository() {
        users.add(new User(1L, "abc", "a@gmail.com", "ADMIN"));
        users.add(new User(2L, "bcd", "b@gmail.com", "USER"));
        users.add(new User(3L, "cde", "c@gmail.com", "USER"));
    }

    public List<User> findAll() {
        return users;
    }
    public User findById(Long id) {
        return users.stream()
                .filter(u -> u.getId() ==id)
                .findFirst()
                .orElse(null);
    }

    public User save(User user){
        if (users.stream().filter(u->u.getId()==user.getId()).findFirst() != null) {
            return null;
        }
        users.add(user);
        return user;
    }
    public User save(Long id, User newUser){
        User oldUser = findById(id);
        if (oldUser==null) {
            return null;
        }
        oldUser.setUsername(newUser.getUsername());
        oldUser.setEmail(newUser.getEmail());
        oldUser.setRole(newUser.getRole());
        return oldUser;
    }
    public boolean delete(Long id){
        User user = findById(id);
        return users.removeIf(u->u.getId()==id);
    }
}
