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
@Table(name = "sys_privs")
public class Privilege {
	@Id
	@Column(name = "id")
	@org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private UUID id;

	@Column(name = "priv_code")
	private String privCode;

	@Column(name = "priv_name")
	private String privName;

	@Column(name = "priv_seq")
	private int privSeq;

	@Column(name = "object_type")
	private String objectType;

	@Column(name = "action_type")
	private String actionType;

	@Column(name = "link_group_code")
	private String linkGroupCode;

	@Column(name = "link_group_name")
	private String linkGroupName;

	@Column(name = "page_link")
	private String pageLink;

	@Column(name = "tcode")
	private String tcode;

	@Column(name = "description")
	private String description;

	@Column(name = "advice")
	private String advice;

	@Column(name = "super_admin")
	private boolean superAdmin;
	
	@Column(name = "auto_granted")
	private boolean autoGranted;
	
	@Column(name = "workflow")
	private boolean workflow;
	
	@Column(name = "device_web")
	private boolean deviceWeb;

	@Column(name = "device_mobile")
	private boolean deviceMobile;

	@Column(name = "device_tab")
	private boolean deviceTab;

	@Column(name = "work_status")
	private String workStatus;

	public boolean isDeviceWeb() {
		return deviceWeb;
	}

	public void setDeviceWeb(boolean deviceWeb) {
		this.deviceWeb = deviceWeb;
	}

	public boolean isDeviceMobile() {
		return deviceMobile;
	}

	public void setDeviceMobile(boolean deviceMobile) {
		this.deviceMobile = deviceMobile;
	}

	public boolean isDeviceTab() {
		return deviceTab;
	}

	public void setDeviceTab(boolean deviceTab) {
		this.deviceTab = deviceTab;
	}

	public String getWorkStatus() {
		return workStatus;
	}

	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}

	public int getPlannedEffort() {
		return plannedEffort;
	}

	public void setPlannedEffort(int plannedEffort) {
		this.plannedEffort = plannedEffort;
	}

	public int getActualEffort() {
		return actualEffort;
	}

	public void setActualEffort(int actualEffort) {
		this.actualEffort = actualEffort;
	}

	public String getAssigneeCode() {
		return assigneeCode;
	}

	public void setAssigneeCode(String assigneeCode) {
		this.assigneeCode = assigneeCode;
	}

	public String getAssigneeName() {
		return assigneeName;
	}

	public void setAssigneeName(String assigneeName) {
		this.assigneeName = assigneeName;
	}

	@Column(name = "planned_effort")
	private int plannedEffort;

	@Column(name = "actual_effort")
	private int actualEffort;

	@Column(name = "assignee_code")
	private String assigneeCode;

	@Column(name = "assignee_name")
	private String assigneeName;

	@Column(name = "suite_code")
	private String suiteCode;

	@Column(name = "suite_short_name")
	private String suiteShortName;

	@Column(name = "suite_full_name")
	private String suiteFullName;

	@Column(name = "suite_seq")
	private int suiteSeq;

	@Column(name = "mod_code")
	private String modCode;

	@Column(name = "mod_short_name")
	private String modShortName;

	@Column(name = "mod_full_name")
	private String modFullName;

	@Column(name = "mod_seq")
	private int modSeq;

	@Column(name = "priv_grp_code")
	private int privGrpCode;

	@Column(name = "priv_grp_name")
	private String privGrpName;

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

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getPrivCode() {
		return privCode;
	}

	public void setPrivCode(String privCode) {
		this.privCode = privCode;
	}

	public String getPrivName() {
		return privName;
	}

	public void setPrivName(String privName) {
		this.privName = privName;
	}

	public int getPrivSeq() {
		return privSeq;
	}

	public void setPrivSeq(int privSeq) {
		this.privSeq = privSeq;
	}

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getLinkGroupCode() {
		return linkGroupCode;
	}

	public void setLinkGroupCode(String linkGroupCode) {
		this.linkGroupCode = linkGroupCode;
	}

	public String getLinkGroupName() {
		return linkGroupName;
	}

	public void setLinkGroupName(String linkGroupName) {
		this.linkGroupName = linkGroupName;
	}

	public String getPageLink() {
		return pageLink;
	}

	public void setPageLink(String pageLink) {
		this.pageLink = pageLink;
	}

	public String getTcode() {
		return tcode;
	}

	public void setTcode(String tcode) {
		this.tcode = tcode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

	public boolean isSuperAdmin() {
		return superAdmin;
	}
	
	

	public void setSuperAdmin(boolean superAdmin) {
		this.superAdmin = superAdmin;
	}

	public boolean isAutoGranted() {
		return autoGranted;
	}

	public void setAutoGranted(boolean autoGranted) {
		this.autoGranted = autoGranted;
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

	public int getSuiteSeq() {
		return suiteSeq;
	}

	public void setSuiteSeq(int suiteSeq) {
		this.suiteSeq = suiteSeq;
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

	public int getModSeq() {
		return modSeq;
	}

	public void setModSeq(int modSeq) {
		this.modSeq = modSeq;
	}

	public int getPrivGrpCode() {
		return privGrpCode;
	}

	public void setPrivGrpCode(int privGrpCode) {
		this.privGrpCode = privGrpCode;
	}

	public String getPrivGrpName() {
		return privGrpName;
	}

	public void setPrivGrpName(String privGrpName) {
		this.privGrpName = privGrpName;
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

	public boolean isWorkflow() {
		return workflow;
	}

	public void setWorkflow(boolean workflow) {
		this.workflow = workflow;
	}

}