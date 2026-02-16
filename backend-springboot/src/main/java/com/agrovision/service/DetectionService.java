package com.agrovision.service;

import com.agrovision.dto.DetectionRequest;
import com.agrovision.entity.Detection;
import com.agrovision.entity.User;
import com.agrovision.repository.DetectionRepository;
import com.agrovision.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DetectionService {

    @Autowired
    private DetectionRepository detectionRepository;

    @Autowired
    private UserRepository userRepository;

    public Detection saveDetection(DetectionRequest request) {

        // 🔹 Fetch user entity using userId
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 🔹 Create new Detection object
        Detection detection = new Detection();

        // IMPORTANT: set User entity (not userId)
        detection.setUser(user);

        detection.setImageName(request.getImageName());
        detection.setImagePath(request.getImagePath());

        // Upload metadata
        detection.setUploadTime(LocalDateTime.now());
        detection.setStatus("UPLOADED");

        // Save to DB
        return detectionRepository.save(detection);
    }
}
