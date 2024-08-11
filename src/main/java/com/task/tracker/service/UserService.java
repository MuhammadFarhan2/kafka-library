package com.task.tracker.service;

import com.tasktracker.exercise.model.User;
import com.tasktracker.exercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
    public void createUser(User user) {
        userRepository.save(user);
    }

    public boolean checkUserIdExist(int userId) {
        return userRepository.findById(userId) == null ? false: true;
    }
}
