package com.agrovision.controller;

import com.agrovision.dto.ApiResponse;
import com.agrovision.dto.LoginRequest;
import com.agrovision.dto.RegisterRequest;
import com.agrovision.entity.User;
import com.agrovision.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserService userService;


    /* ================= REGISTER ================= */

    @PostMapping("/register")
    public ApiResponse registerUser(@RequestBody RegisterRequest request) {

        // check if user already exists
        if (userService.emailExists(request.getEmail())) {
            return new ApiResponse(false, "User already registered with this email", null);
        }

        // create new user
        User user = userService.registerUser(request);

        return new ApiResponse(true, "Registration successful", user);
    }



    /* ================= LOGIN ================= */

    @PostMapping("/login")
    public ApiResponse loginUser(@RequestBody LoginRequest request) {

        User user = userService.loginUser(request);

        if (user == null) {
            return new ApiResponse(false, "Invalid email or password", null);
        }

        return new ApiResponse(true, "Login successful", user);
    }
}
