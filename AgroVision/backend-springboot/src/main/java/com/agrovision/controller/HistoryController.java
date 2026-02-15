package com.agrovision.controller;

import com.agrovision.entity.History;
import com.agrovision.service.HistoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    // SAVE HISTORY
    @PostMapping("/save")
    public History saveHistory(
            @RequestParam Long userId,
            @RequestParam Long detectionId,
            @RequestParam String activityType,
            @RequestParam String remarks) {

        return historyService.saveHistory(userId, detectionId, activityType, remarks);
    }

    // GET HISTORY BY USER
    @GetMapping("/user/{userId}")
    public List<History> getHistoryByUser(@PathVariable Long userId) {
        return historyService.getHistoryByUser(userId);
    }

    // GET HISTORY BY ID
    @GetMapping("/{id}")
    public History getHistoryById(@PathVariable Long id) {
        return historyService.getHistoryById(id);
    }

    // DELETE HISTORY
    @DeleteMapping("/delete/{id}")
    public String deleteHistory(@PathVariable Long id) {
        historyService.deleteHistory(id);
        return "History record deleted successfully";
    }
}
