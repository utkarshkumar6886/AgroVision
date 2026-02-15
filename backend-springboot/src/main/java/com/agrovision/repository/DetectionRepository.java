package com.agrovision.repository;

import com.agrovision.entity.Detection;
import com.agrovision.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DetectionRepository extends JpaRepository<Detection, Long> {

    List<Detection> findByUser(User user);
}
