package com.agrovision.controller;

import com.agrovision.dto.ApiResponse;
import com.agrovision.dto.DetectionRequest;
import com.agrovision.entity.Detection;
import com.agrovision.service.DetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/detection")
@CrossOrigin(origins = "*")
public class DetectionController {

    @Autowired
    private DetectionService detectionService;

    /**
     * Upload image detection record
     */
    @PostMapping("/upload")
    public ResponseEntity<ApiResponse> uploadDetection(@RequestBody DetectionRequest request) {

        try {
            Detection detection = detectionService.saveDetection(request);

            return ResponseEntity.ok(
                    new ApiResponse(true, "Image uploaded successfully", detection)
            );

        } catch (Exception e) {

            return ResponseEntity.badRequest()
                    .body(new ApiResponse(false, e.getMessage(), null));
        }
    }
}
