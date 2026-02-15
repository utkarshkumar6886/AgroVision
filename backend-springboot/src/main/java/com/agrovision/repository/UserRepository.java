package com.agrovision.repository;

import com.agrovision.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Check if email already exists
    boolean existsByEmail(String email);

    // Login authentication
    Optional<User> findByEmailAndPassword(String email, String password);

    // Find user by email
    Optional<User> findByEmail(String email);
}
