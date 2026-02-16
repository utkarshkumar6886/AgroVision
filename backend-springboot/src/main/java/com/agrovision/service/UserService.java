package com.agrovision.service;

import com.agrovision.dto.LoginRequest;
import com.agrovision.dto.RegisterRequest;
import com.agrovision.entity.User;
import com.agrovision.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    /* ================= CHECK EMAIL EXISTS ================= */

    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }


    /* ================= REGISTER USER ================= */

    public User registerUser(RegisterRequest request) {

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setPhone(request.getPhone());

        user.setRole("USER");
        user.setStatus("ACTIVE");
        user.setRegistrationDate(LocalDateTime.now());

        return userRepository.save(user);
    }


    /* ================= LOGIN USER ================= */

    public User loginUser(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail());

        if (user == null) {
            return null;
        }

        // password match check
        if (!user.getPassword().equals(request.getPassword())) {
            return null;
        }

        return user;
    }
}
