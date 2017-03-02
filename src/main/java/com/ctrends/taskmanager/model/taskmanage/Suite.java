package com.ctrends.taskmanager.model.taskmanage;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="sys_suites")
public class Suite {
	
	@Id
	@Column(name = "id")
	@org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private UUID id;
	
	@Column(name="suite_seq", nullable = false)
	private int suiteSeq;

	@Column(name="suite_name")
	private String suiteName;
	
	public String getSuiteName() {
		return suiteName;
	}

	public void setSuiteName(String suiteName) {
		this.suiteName = suiteName;
	}

	@Column(name="suite_code")
	private String suiteCode;

	@Column(name="suite_short_name")
	private String suiteShortName;

	@Column(name="suite_full_name")
	private String suiteFullName;

	@Column(name="suite_icon")
	private String suiteIcon;

	@Column(name="suite_logo_path")
	private String suiteLogoPath;

	@Column(name="suite_description")
	private String suiteDescription;


	@Column(name="created_by_code")
	private String createdByCode;
	
	@Column(name="created_by_name")
	private String createdByName;
	
	@Column(name="created_by_username")
	private String createdByUsername;

	@Column(name="created_by_email")
	private String createdByEmail;
	
	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="updated_by_code")
	private String updatedByCode;
	
	@Column(name="updated_by_name")
	private String updatedByName;
	
	@Column(name="updated_by_username")
	private String updatedByUsername;

	@Column(name="updated_by_email")
	private String updatedByEmail;

	@Column(name="updated_at")
	private Timestamp updatedAt;
	
	@Column(name="suite_num_code")
	private String suiteNumCode;
	

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public int getSuiteSeq() {
		return suiteSeq;
	}

	public void setSuiteSeq(int suiteSeq) {
		this.suiteSeq = suiteSeq;
	}

	public String getSuiteCode() {
		return suiteCode;
	}

	public void setSuiteCode(String suiteCode) {
		this.suiteCode = suiteCode;
	}

	public String getSuiteShortName() {
		return suiteShortName;
	}

	public void setSuiteShortName(String suiteShortName) {
		this.suiteShortName = suiteShortName;
	}

	public String getSuiteFullName() {
		return suiteFullName;
	}

	public void setSuiteFullName(String suiteFullName) {
		this.suiteFullName = suiteFullName;
	}

	public String getSuiteIcon() {
		return suiteIcon;
	}

	public void setSuiteIcon(String suiteIcon) {
		this.suiteIcon = suiteIcon;
	}

	public String getSuiteLogoPath() {
		return suiteLogoPath;
	}

	public void setSuiteLogoPath(String suiteLogoPath) {
		this.suiteLogoPath = suiteLogoPath;
	}

	public String getSuiteDescription() {
		return suiteDescription;
	}

	public void setSuiteDescription(String suiteDescription) {
		this.suiteDescription = suiteDescription;
	}

	public String getCreatedByCode() {
		return createdByCode;
	}

	public void setCreatedByCode(String createdByCode) {
		this.createdByCode = createdByCode;
	}

	public String getCreatedByName() {
		return createdByName;
	}

	public void setCreatedByName(String createdByName) {
		this.createdByName = createdByName;
	}

	public String getCreatedByUsername() {
		return createdByUsername;
	}

	public void setCreatedByUsername(String createdByUsername) {
		this.createdByUsername = createdByUsername;
	}

	public String getCreatedByEmail() {
		return createdByEmail;
	}

	public void setCreatedByEmail(String createdByEmail) {
		this.createdByEmail = createdByEmail;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedByCode() {
		return updatedByCode;
	}

	public void setUpdatedByCode(String updatedByCode) {
		this.updatedByCode = updatedByCode;
	}

	public String getUpdatedByName() {
		return updatedByName;
	}

	public void setUpdatedByName(String updatedByName) {
		this.updatedByName = updatedByName;
	}

	public String getUpdatedByUsername() {
		return updatedByUsername;
	}

	public void setUpdatedByUsername(String updatedByUsername) {
		this.updatedByUsername = updatedByUsername;
	}

	public String getUpdatedByEmail() {
		return updatedByEmail;
	}

	public void setUpdatedByEmail(String updatedByEmail) {
		this.updatedByEmail = updatedByEmail;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getSuiteNumCode() {
		return suiteNumCode;
	}

	public void setSuiteNumCode(String suiteNumCode) {
		this.suiteNumCode = suiteNumCode;
	}
	
	
}
