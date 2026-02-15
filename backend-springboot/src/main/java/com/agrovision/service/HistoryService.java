package com.agrovision.service;

import com.agrovision.entity.History;
import com.agrovision.entity.User;
import com.agrovision.entity.Detection;
import com.agrovision.repository.HistoryRepository;
import com.agrovision.repository.UserRepository;
import com.agrovision.repository.DetectionRepository;
import com.agrovision.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class HistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DetectionRepository detectionRepository;

    // SAVE HISTORY RECORD
    public History saveHistory(Long userId,
                               Long detectionId,
                               String activityType,
                               String remarks) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with ID: " + userId));

        Detection detection = detectionRepository.findById(detectionId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Detection not found with ID: " + detectionId));

        History history = new History();
        history.setUser(user);
        history.setDetection(detection);
        history.setActivityType(activityType);
        history.setRemarks(remarks);
        history.setTimestamp(LocalDateTime.now());

        return historyRepository.save(history);
    }

    // GET HISTORY BY USER
    public List<History> getHistoryByUser(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with ID: " + userId));

        return historyRepository.findByUser(user);
    }

    // GET HISTORY BY ID
    public History getHistoryById(Long id) {

        return historyRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("History not found with ID: " + id));
    }

    // DELETE HISTORY
    public void deleteHistory(Long id) {

        History history = historyRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("History not found with ID: " + id));

        historyRepository.delete(history);
    }
}
