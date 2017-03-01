package com.ctrends.taskmanager.model.taskmanage;

import java.sql.Date;
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
@Table(name = "sys_modules")
public class Module {
	@Id
	@Column(name = "id")
	@org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private UUID id;
	
	@Column(name ="suite_code")
	private String suiteCode;

	@Column(name ="suite_seq")
	private Integer suiteSeq;

	@Column(name ="suite_short_name")
	private String suiteShortName;

	@Column(name ="suite_full_name")
	private String suiteFullName;

	@Column(name ="mod_seq")
	private Integer modSeq;

	@Column(name ="mod_code")
	private String modCode;

	@Column(name ="mod_short_name")
	private String modShortName;

	@Column(name ="mod_full_name")
	private String modFullName;

	@Column(name ="mod_logo_path")
	private String modLogoPath;

	@Column(name ="mod_description_1")
	private String modDescription1;

	@Column(name ="mod_description_2")
	private String modDescription2;

	@Column(name ="mod_description_3")
	private String modDescription3;

	@Column(name = "created_by_code")
	  private String createdByCode;

	  @Column(name = "created_by_name")
	  private String createdByName;

	  @Column(name = "created_by_username")
	  private String createdByUsername;

	  @Column(name = "created_by_email")
	  private String createdByEmail;

	  @Column(name = "created_by_company_code")
	  private String createdByCompanyCode;

	  @Column(name = "created_by_company_name")
	  private String createdByCompanyName;

	  @Column(name = "created_at")
	  private Timestamp createdAt;

	  @Column(name = "updated_by_code")
	  private String updatedByCode;

	  @Column(name = "updated_by_name")
	  private String updatedByName;

	  @Column(name = "updated_by_username")
	  private String updatedByUsername;

	  @Column(name = "updated_by_email")
	  private String updatedByEmail;

	  @Column(name = "updated_by_company_code")
	  private String updatedByCompanyCode;

	  @Column(name = "updated_by_company_name")
	  private String updatedByCompanyName;

	  @Column(name = "updated_at")
	  private Timestamp updatedAt;


	  @Column(name = "module_num_code")
	  private String moduleNumCode;

	  @Column(name = "module_icon")
	  private String moduleIcon;

	  @Column(name = "limiting_item")
	  private String limitingItem;
	  

	public String getLimitingItem() {
		return limitingItem;
	}

	public void setLimitingItem(String limitingItem) {
		this.limitingItem = limitingItem;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getSuiteCode() {
		return suiteCode;
	}

	public void setSuiteCode(String suiteCode) {
		this.suiteCode = suiteCode;
	}

	public Integer getSuiteSeq() {
		return suiteSeq;
	}

	public void setSuiteSeq(Integer suiteSeq) {
		this.suiteSeq = suiteSeq;
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

	public Integer getModSeq() {
		return modSeq;
	}

	public void setModSeq(Integer modSeq) {
		this.modSeq = modSeq;
	}

	public String getModCode() {
		return modCode;
	}

	public void setModCode(String modCode) {
		this.modCode = modCode;
	}

	public String getModShortName() {
		return modShortName;
	}

	public void setModShortName(String modShortName) {
		this.modShortName = modShortName;
	}

	public String getModFullName() {
		return modFullName;
	}

	public void setModFullName(String modFullName) {
		this.modFullName = modFullName;
	}

	public String getModLogoPath() {
		return modLogoPath;
	}

	public void setModLogoPath(String modLogoPath) {
		this.modLogoPath = modLogoPath;
	}

	public String getModDescription1() {
		return modDescription1;
	}

	public void setModDescription1(String modDescription1) {
		this.modDescription1 = modDescription1;
	}

	public String getModDescription2() {
		return modDescription2;
	}

	public void setModDescription2(String modDescription2) {
		this.modDescription2 = modDescription2;
	}

	public String getModDescription3() {
		return modDescription3;
	}

	public void setModDescription3(String modDescription3) {
		this.modDescription3 = modDescription3;
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

	public String getCreatedByCompanyCode() {
		return createdByCompanyCode;
	}

	public void setCreatedByCompanyCode(String createdByCompanyCode) {
		this.createdByCompanyCode = createdByCompanyCode;
	}

	public String getCreatedByCompanyName() {
		return createdByCompanyName;
	}

	public void setCreatedByCompanyName(String createdByCompanyName) {
		this.createdByCompanyName = createdByCompanyName;
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

	public String getUpdatedByCompanyCode() {
		return updatedByCompanyCode;
	}

	public void setUpdatedByCompanyCode(String updatedByCompanyCode) {
		this.updatedByCompanyCode = updatedByCompanyCode;
	}

	public String getUpdatedByCompanyName() {
		return updatedByCompanyName;
	}

	public void setUpdatedByCompanyName(String updatedByCompanyName) {
		this.updatedByCompanyName = updatedByCompanyName;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getModuleNumCode() {
		return moduleNumCode;
	}

	public void setModuleNumCode(String moduleNumCode) {
		this.moduleNumCode = moduleNumCode;
	}

	public String getModuleIcon() {
		return moduleIcon;
	}

	public void setModuleIcon(String moduleIcon) {
		this.moduleIcon = moduleIcon;
	}
	  
	  
	  
	  
}
