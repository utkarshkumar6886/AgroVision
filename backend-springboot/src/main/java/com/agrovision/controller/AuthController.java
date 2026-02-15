package com.agrovision.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.agrovision.entity.User;
import com.agrovision.service.UserService;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    // Show Login Page
    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    // Show Register Page
    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    // Register User (POST)
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {

        try {

            // Check if email already exists
            Optional<User> existingUser = userService.findByEmail(user.getEmail());

            if (existingUser.isPresent()) {
                model.addAttribute("errorMessage", "User already registered with this email!");
                return "register";
            }

            // Save user
            userService.registerUser(user);

            model.addAttribute("successMessage", "Registration successful! Please login.");
            return "login";

        } catch (Exception e) {
            model.addAttribute("errorMessage", "Something went wrong. Please try again.");
            return "register";
        }
    }

    // Login User
    @PostMapping("/login")
    public String loginUser(@RequestParam String email,
                            @RequestParam String password,
                            Model model) {

        Optional<User> user = userService.findByEmail(email);

        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return "upload"; // go to image upload page
        } else {
            model.addAttribute("errorMessage", "Invalid email or password!");
            return "login";
        }
    }
}
