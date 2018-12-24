package com.timber.timberyard.auth.exporter.service;

import java.util.Optional;

import com.timber.timberyard.auth.model.Exporter;

public interface ExporterService {

	Exporter saveExporter(Exporter exporterForm);

	Optional<Exporter> getExporter(Long exporterId);

}
