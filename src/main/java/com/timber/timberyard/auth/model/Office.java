package com.timber.timberyard.auth.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "office")
public class Office {

	private Long id;

	private String officeName;
	
	private String propritorName;
	
	private String licenceNumber;
	
	private String licenceIssueDate;
	
	private Long termNumber;
	
	private String prefixName;
	
	private String lotNumber;
	
	private String address;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public String getPropritorName() {
		return propritorName;
	}

	public void setPropritorName(String propritorName) {
		this.propritorName = propritorName;
	}

	public String getLicenceNumber() {
		return licenceNumber;
	}

	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}

	public String getLastNumber() {
		return lotNumber;
	}

	public void setLastNumber(String lastNumber) {
		this.lotNumber = lastNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLicenceIssueDate() {
		return licenceIssueDate;
	}

	public void setLicenceIssueDate(String licenceIssueDate) {
		this.licenceIssueDate = licenceIssueDate;
	}

	public Long getTermNumber() {
		return termNumber;
	}

	public void setTermNumber(Long termNumber) {
		this.termNumber = termNumber;
	}

	public String getPrefixName() {
		return prefixName;
	}

	public void setPrefixName(String prefixName) {
		this.prefixName = prefixName;
	}
	
	
}
