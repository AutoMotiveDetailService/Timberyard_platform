package com.timber.timberyard.auth.exporter.model;

public class ExporterResponse {

	private Long id;
	
	private String exporterName;
	
	private String exporterAddress;

	public ExporterResponse(Long id, String exporterName, String exporterAddress) {
		this.id = id;
		this.exporterName = exporterName;
		this.exporterAddress = exporterAddress;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExporterName() {
		return exporterName;
	}

	public void setExporterName(String exporterName) {
		this.exporterName = exporterName;
	}

	public String getExporterAddress() {
		return exporterAddress;
	}

	public void setExporterAddress(String exporterAddress) {
		this.exporterAddress = exporterAddress;
	}
	
	
	
}
