package com.timber.timberyard.auth.exporter.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.timber.timberyard.auth.model.Exporter;

public interface ExporterRepository extends JpaRepository<Exporter, Long> {
    Optional<Exporter> findById(Long id);
}
