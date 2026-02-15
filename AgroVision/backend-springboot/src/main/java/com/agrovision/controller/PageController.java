package com.agrovision.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    // Login page
    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    // Upload page
    @GetMapping("/upload")
    public String uploadPage() {
        return "upload";
    }

    // History page
    @GetMapping("/history")
    public String historyPage() {
        return "history";
    }

    // Result page
    @GetMapping("/result")
    public String resultPage() {
        return "result";
    }
}
