package com.agrovision.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "detections")
public class Detection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detectionId;

    private String imagePath;
    private Double confidenceScore;
    private String severityLevel;
    private String aiPredictionLabel;

    private LocalDateTime uploadTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "disease_id")
    private Disease disease;

    public Detection() {}

    public Long getDetectionId() { return detectionId; }

    public String getImagePath() { return imagePath; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }

    public Double getConfidenceScore() { return confidenceScore; }
    public void setConfidenceScore(Double confidenceScore) { this.confidenceScore = confidenceScore; }

    public String getSeverityLevel() { return severityLevel; }
    public void setSeverityLevel(String severityLevel) { this.severityLevel = severityLevel; }

    public String getAiPredictionLabel() { return aiPredictionLabel; }
    public void setAiPredictionLabel(String aiPredictionLabel) { this.aiPredictionLabel = aiPredictionLabel; }

    public LocalDateTime getUploadTime() { return uploadTime; }
    public void setUploadTime(LocalDateTime uploadTime) { this.uploadTime = uploadTime; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Disease getDisease() { return disease; }
    public void setDisease(Disease disease) { this.disease = disease; }
}
