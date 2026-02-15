package com.agrovision.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agrovision.entity.User;
import com.agrovision.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Register new user
    public User registerUser(User user) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException("Error while registering user: " + e.getMessage());
        }
    }

    // Find user by email
    public Optional<User> findByEmail(String email) {
        try {
            return userRepository.findByEmail(email);
        } catch (Exception e) {
            throw new RuntimeException("Error fetching user by email: " + e.getMessage());
        }
    }

    // Login validation
    public Optional<User> loginUser(String email, String password) {
        try {
            Optional<User> user = userRepository.findByEmail(email);

            if (user.isPresent() && user.get().getPassword().equals(password)) {
                return user;
            }

            return Optional.empty();

        } catch (Exception e) {
            throw new RuntimeException("Login failed: " + e.getMessage());
        }
    }
}
