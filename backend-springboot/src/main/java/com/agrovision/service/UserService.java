package com.agrovision.service;

import com.agrovision.dto.ApiResponse;
import com.agrovision.dto.LoginRequest;
import com.agrovision.dto.RegisterRequest;
import com.agrovision.entity.User;
import com.agrovision.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // ---------------- REGISTER USER ----------------
    public ApiResponse registerUser(RegisterRequest request) {

        // Check if email already exists
        if (userRepository.existsByEmail(request.getEmail())) {
            return new ApiResponse(false, "Email already registered");
        }

        // Create new user
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setPhone(request.getPhone());
        user.setRole("USER");
        user.setStatus("ACTIVE");
        user.setRegistrationDate(LocalDateTime.now());

        userRepository.save(user);

        return new ApiResponse(true, "User registered successfully");
    }

    // ---------------- LOGIN USER ----------------
    public ApiResponse loginUser(LoginRequest request) {

        Optional<User> optionalUser = userRepository.findByEmail(request.getEmail());

        if (optionalUser.isEmpty()) {
            return new ApiResponse(false, "User not found");
        }

        User user = optionalUser.get();

        // Check password
        if (!user.getPassword().equals(request.getPassword())) {
            return new ApiResponse(false, "Invalid password");
        }

        return new ApiResponse(true, "Login successful", user);
    }
}
