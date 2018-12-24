package com.timber.timberyard.auth.exporter.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timber.timberyard.auth.exporter.dao.ExporterRepository;
import com.timber.timberyard.auth.model.Exporter;

@Service
public class ExporterServiceImpl implements ExporterService {

	
	@Autowired
    private ExporterRepository exporterRepository;
	
	@Override
	public Exporter saveExporter(Exporter exporterForm) {
		return exporterRepository.save(exporterForm);
	}
	
	@Override
	public Optional<Exporter> getExporter(Long exporterId) {
		Optional<Exporter> exporter = exporterRepository.findById(exporterId);
		return exporter;
	}

}
