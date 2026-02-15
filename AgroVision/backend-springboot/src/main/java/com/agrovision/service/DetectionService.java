package com.agrovision.service;

import com.agrovision.entity.Detection;
import com.agrovision.entity.User;
import com.agrovision.entity.Disease;
import com.agrovision.repository.DetectionRepository;
import com.agrovision.repository.UserRepository;
import com.agrovision.repository.DiseaseRepository;
import com.agrovision.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DetectionService {

    @Autowired
    private DetectionRepository detectionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DiseaseRepository diseaseRepository;

    // SAVE DETECTION RESULT
    public Detection saveDetection(Long userId,
                                   Long diseaseId,
                                   String imagePath,
                                   Double confidenceScore,
                                   String severityLevel,
                                   String aiPredictionLabel) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with ID: " + userId));

        Disease disease = diseaseRepository.findById(diseaseId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Disease not found with ID: " + diseaseId));

        Detection detection = new Detection();
        detection.setUser(user);
        detection.setDisease(disease);
        detection.setImagePath(imagePath);
        detection.setConfidenceScore(confidenceScore);
        detection.setSeverityLevel(severityLevel);
        detection.setAiPredictionLabel(aiPredictionLabel);
        detection.setUploadTime(LocalDateTime.now());

        return detectionRepository.save(detection);
    }

    // GET DETECTIONS BY USER
    public List<Detection> getDetectionsByUser(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with ID: " + userId));

        return detectionRepository.findByUser(user);
    }

    // GET DETECTION BY ID
    public Detection getDetectionById(Long id) {

        return detectionRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Detection not found with ID: " + id));
    }

    // DELETE DETECTION
    public void deleteDetection(Long id) {

        Detection detection = detectionRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Detection not found with ID: " + id));

        detectionRepository.delete(detection);
    }
}
