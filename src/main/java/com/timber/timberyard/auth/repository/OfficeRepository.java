package com.timber.timberyard.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.timber.timberyard.auth.model.Office;

public interface OfficeRepository extends JpaRepository<Office, Long> {
    Optional<Office> findById(Long id);
    
}
