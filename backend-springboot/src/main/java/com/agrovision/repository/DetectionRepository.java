package com.agrovision.repository;

import com.agrovision.entity.Detection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetectionRepository extends JpaRepository<Detection, Long> {

    // fetch detections for a specific user (used in history phase)
    List<Detection> findByUserId(Long userId);
}
