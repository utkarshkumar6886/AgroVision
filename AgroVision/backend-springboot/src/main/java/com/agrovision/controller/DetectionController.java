package com.agrovision.controller;

import com.agrovision.entity.Detection;
import com.agrovision.service.DetectionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detection")
public class DetectionController {

    @Autowired
    private DetectionService detectionService;

    // SAVE DETECTION RESULT
    @PostMapping("/save")
    public Detection saveDetection(
            @RequestParam Long userId,
            @RequestParam Long diseaseId,
            @RequestParam String imagePath,
            @RequestParam Double confidenceScore,
            @RequestParam String severityLevel,
            @RequestParam String aiPredictionLabel) {

        return detectionService.saveDetection(
                userId,
                diseaseId,
                imagePath,
                confidenceScore,
                severityLevel,
                aiPredictionLabel
        );
    }

    // GET DETECTIONS BY USER
    @GetMapping("/user/{userId}")
    public List<Detection> getUserDetections(@PathVariable Long userId) {
        return detectionService.getDetectionsByUser(userId);
    }

    // GET DETECTION BY ID
    @GetMapping("/{id}")
    public Detection getDetectionById(@PathVariable Long id) {
        return detectionService.getDetectionById(id);
    }

    // DELETE DETECTION
    @DeleteMapping("/delete/{id}")
    public String deleteDetection(@PathVariable Long id) {
        detectionService.deleteDetection(id);
        return "Detection record deleted successfully";
    }
}
