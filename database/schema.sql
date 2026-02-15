-- =====================================================
-- AgroVision Database Schema
-- AI-Based Plant Disease Detection System
-- =====================================================

-- Create database
CREATE DATABASE IF NOT EXISTS agrovision_db;

-- Select database
USE agrovision_db;

-- =====================================================
-- TABLE: users
-- Stores user registration and login details
-- =====================================================

CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- =====================================================
-- TABLE: detection_results
-- Stores disease detection results and history
-- =====================================================

CREATE TABLE detection_results (
    detection_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,

    image_name VARCHAR(255) NOT NULL,
    image_path VARCHAR(255) NOT NULL,

    disease_name VARCHAR(100) NOT NULL,
    confidence DECIMAL(5,2) NOT NULL,

    cause TEXT,
    treatment TEXT,
    prevention TEXT,

    detected_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_user_detection
        FOREIGN KEY (user_id)
        REFERENCES users(user_id)
        ON DELETE CASCADE
);

-- =====================================================
-- INDEXES (for better performance)
-- =====================================================

CREATE INDEX idx_user_id ON detection_results(user_id);
CREATE INDEX idx_detected_at ON detection_results(detected_at);

-- =====================================================
-- END OF SCHEMA
-- =====================================================
