package com.agrovision.controller;

import com.agrovision.dto.ApiResponse;
import com.agrovision.dto.LoginRequest;
import com.agrovision.dto.RegisterRequest;
import com.agrovision.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    // ---------------- REGISTER API ----------------
    @PostMapping("/register")
    public ResponseEntity<ApiResponse> registerUser(@RequestBody RegisterRequest request) {

        ApiResponse response = userService.registerUser(request);
        return ResponseEntity.ok(response);
    }

    // ---------------- LOGIN API ----------------
    @PostMapping("/login")
    public ResponseEntity<ApiResponse> loginUser(@RequestBody LoginRequest request) {

        ApiResponse response = userService.loginUser(request);
        return ResponseEntity.ok(response);
    }
}
