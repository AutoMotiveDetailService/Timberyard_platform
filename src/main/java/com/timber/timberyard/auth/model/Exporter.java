package com.timber.timberyard.auth.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "exporter")
public class Exporter {

	private Long id;
    private String exporterName;
    private String exporterAddress;
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
