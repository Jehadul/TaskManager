package com.ctrends.taskmanager.model.userstory;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tman_user_stories")
public class UserStory {
	@Id
	@Column(name = "id")
	@org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private UUID id;
	
	@Column(name="user_story_code")
	private String userStoryCode;
	
	@Column(name="user_story_title")
	private String userStoryTitle;
	
	@Column(name="description")
	private String description;
	
	@Column(name="acceptance_criteria")
	private String acceptanceCriteria;
	
	@Column(name="business_value")
	private String businessValue;
	
	@Column(name="size")
	private int size;
	
	@Column(name="suite_code")
	private String suiteCode;
	
	@Column(name="suite_name")
	private String suiteName;
	
	@Column(name="module_code")
	private String moduleCode;
	
	@Column(name="module_name")
	private String moduleName;
	
	@Column(name="priv_grp_code")
	private int privGrpCode;
	
	@Column(name="priv_grp_name")
	private String privGrpName;
	
	@Column(name="privilege_code")
	private String privilegeCode;
	
	@Column(name="privilege_name")
	private String privilegeName;
	
	@Column(name="priority")
	private String priority;
	
	@Column(name="priority_code")
	private int priorityCode;
	
	@Column(name="story_order")
	private String storyOrder;
	
	@Column(name="story_status")
	private String storyStatus;
	
	@Column(name="doa_type_code")
	private String doaTypeCode;

	@Column(name="doa_type_name")
	private String doaTypeName;

	@Column(name="doa_amount")
	private double doaAmount;

	@Column(name="doa_currency_code")
	private String doaCurrencyCode;

	@Column(name="doa_currency_name")
	private String doaCurrencyName;

	@Column(name="created_by_code")
	private String createdByCode;
	
	@Column(name="created_by_name")
	private String createdByName;
	
	@Column(name="created_by_username")
	private String createdByUsername;

	@Column(name="created_by_email")
	private String createdByEmail;

	@Column(name="created_by_company_code")
	private String createdByCompanyCode;

	@Column(name="created_by_company_name")
	private String createdByCompanyName;
	
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

	@Column(name="updated_by_company_code")
	private String updatedByCompanyCode;

	@Column(name="updated_by_company_name")
	private String updatedByCompanyName;

	@Column(name="updated_at")
	private Timestamp updatedAt;
	
	@Column(name="submitted_by_code")
	private String submittedByCode;
	
	@Column(name="submitted_by_name")
	private String submittedByName;
	
	@Column(name="submitted_by_username")
	private String submittedByUsername;

	@Column(name="submitted_by_email")
	private String submittedByEmail;

	@Column(name="submitted_by_company_code")
	private String submittedByCompanyCode;

	@Column(name="submitted_by_company_name")
	private String submittedByCompanyName;

	@Column(name="submitted_at")
	private Timestamp submittedAt;
	
	@Column(name="approved_by_code")
	private String approvedByCode;
	
	@Column(name="approved_by_name")
	private String approvedByName;
	
	@Column(name="approved_by_username")
	private String approvedByUsername;
	
	@Column(name="approved_by_email")
	private String approvedByEmail;

	@Column(name="approved_by_company_code")
	private String approvedByCompanyCode;

	@Column(name="approved_by_company_name")
	private String approvedByCompanyName;

	@Column(name="approved_at")
	private Timestamp approvedAt;

	@Column(name="locked_by_code")
	private String lockedByCode;
	
	@Column(name="locked_by_name")
	private String lockedByName;
	
	@Column(name="locked_by_username")
	private String lockedByUsername;
	
	@Column(name="locked_by_email")
	private String lockedByEmail;

	@Column(name="locked_by_company_code")
	private String lockedByCompanyCode;

	@Column(name="locked_by_company_name")
	private String lockedByCompanyName;

	@Column(name="locked_at")
	private Timestamp lockedAt;

	@Column(name="is_locked")
	private boolean isLocked;

	@Column(name="status")
	private String status;

	@Column(name="wf_status")
	private String wfStatus;
	

	@Column(name="client_code")
	private String clientCode;
	
	@Column(name="client_name")
	private String clientName;
	
	@Column(name="company_code")
	private String companyCode;
	
	@Column(name="company_name")
	private String companyName;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getUserStoryCode() {
		return userStoryCode;
	}

	public void setUserStoryCode(String userStoryCode) {
		this.userStoryCode = userStoryCode;
	}

	public String getUserStoryTitle() {
		return userStoryTitle;
	}

	public void setUserStoryTitle(String userStoryTitle) {
		this.userStoryTitle = userStoryTitle;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAcceptanceCriteria() {
		return acceptanceCriteria;
	}

	public void setAcceptanceCriteria(String acceptanceCriteria) {
		this.acceptanceCriteria = acceptanceCriteria;
	}

	public String getBusinessValue() {
		return businessValue;
	}

	public void setBusinessValue(String businessValue) {
		this.businessValue = businessValue;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getSuiteCode() {
		return suiteCode;
	}

	public void setSuiteCode(String suiteCode) {
		this.suiteCode = suiteCode;
	}

	public String getSuiteName() {
		return suiteName;
	}

	public void setSuiteName(String suiteName) {
		this.suiteName = suiteName;
	}

	public String getModuleCode() {
		return moduleCode;
	}

	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
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

	public String getPrivilegeCode() {
		return privilegeCode;
	}

	public void setPrivilegeCode(String privilegeCode) {
		this.privilegeCode = privilegeCode;
	}

	public String getPrivilegeName() {
		return privilegeName;
	}

	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	public int getPriorityCode() {
		return priorityCode;
	}

	public void setPriorityCode(int priorityCode) {
		this.priorityCode = priorityCode;
	}

	public String getStoryOrder() {
		return storyOrder;
	}

	public void setStoryOrder(String storyOrder) {
		this.storyOrder = storyOrder;
	}
	
	public String getStoryStatus() {
		return storyStatus;
	}

	public void setStoryStatus(String storyStatus) {
		this.storyStatus = storyStatus;
	}

	public String getDoaTypeCode() {
		return doaTypeCode;
	}

	public void setDoaTypeCode(String doaTypeCode) {
		this.doaTypeCode = doaTypeCode;
	}

	public String getDoaTypeName() {
		return doaTypeName;
	}

	public void setDoaTypeName(String doaTypeName) {
		this.doaTypeName = doaTypeName;
	}

	public double getDoaAmount() {
		return doaAmount;
	}

	public void setDoaAmount(double doaAmount) {
		this.doaAmount = doaAmount;
	}

	public String getDoaCurrencyCode() {
		return doaCurrencyCode;
	}

	public void setDoaCurrencyCode(String doaCurrencyCode) {
		this.doaCurrencyCode = doaCurrencyCode;
	}

	public String getDoaCurrencyName() {
		return doaCurrencyName;
	}

	public void setDoaCurrencyName(String doaCurrencyName) {
		this.doaCurrencyName = doaCurrencyName;
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

	public String getSubmittedByCode() {
		return submittedByCode;
	}

	public void setSubmittedByCode(String submittedByCode) {
		this.submittedByCode = submittedByCode;
	}

	public String getSubmittedByName() {
		return submittedByName;
	}

	public void setSubmittedByName(String submittedByName) {
		this.submittedByName = submittedByName;
	}

	public String getSubmittedByUsername() {
		return submittedByUsername;
	}

	public void setSubmittedByUsername(String submittedByUsername) {
		this.submittedByUsername = submittedByUsername;
	}

	public String getSubmittedByEmail() {
		return submittedByEmail;
	}

	public void setSubmittedByEmail(String submittedByEmail) {
		this.submittedByEmail = submittedByEmail;
	}

	public String getSubmittedByCompanyCode() {
		return submittedByCompanyCode;
	}

	public void setSubmittedByCompanyCode(String submittedByCompanyCode) {
		this.submittedByCompanyCode = submittedByCompanyCode;
	}

	public String getSubmittedByCompanyName() {
		return submittedByCompanyName;
	}

	public void setSubmittedByCompanyName(String submittedByCompanyName) {
		this.submittedByCompanyName = submittedByCompanyName;
	}

	public Timestamp getSubmittedAt() {
		return submittedAt;
	}

	public void setSubmittedAt(Timestamp submittedAt) {
		this.submittedAt = submittedAt;
	}

	public String getApprovedByCode() {
		return approvedByCode;
	}

	public void setApprovedByCode(String approvedByCode) {
		this.approvedByCode = approvedByCode;
	}

	public String getApprovedByName() {
		return approvedByName;
	}

	public void setApprovedByName(String approvedByName) {
		this.approvedByName = approvedByName;
	}

	public String getApprovedByUsername() {
		return approvedByUsername;
	}

	public void setApprovedByUsername(String approvedByUsername) {
		this.approvedByUsername = approvedByUsername;
	}

	public String getApprovedByEmail() {
		return approvedByEmail;
	}

	public void setApprovedByEmail(String approvedByEmail) {
		this.approvedByEmail = approvedByEmail;
	}

	public String getApprovedByCompanyCode() {
		return approvedByCompanyCode;
	}

	public void setApprovedByCompanyCode(String approvedByCompanyCode) {
		this.approvedByCompanyCode = approvedByCompanyCode;
	}

	public String getApprovedByCompanyName() {
		return approvedByCompanyName;
	}

	public void setApprovedByCompanyName(String approvedByCompanyName) {
		this.approvedByCompanyName = approvedByCompanyName;
	}

	public Timestamp getApprovedAt() {
		return approvedAt;
	}

	public void setApprovedAt(Timestamp approvedAt) {
		this.approvedAt = approvedAt;
	}

	public String getLockedByCode() {
		return lockedByCode;
	}

	public void setLockedByCode(String lockedByCode) {
		this.lockedByCode = lockedByCode;
	}

	public String getLockedByName() {
		return lockedByName;
	}

	public void setLockedByName(String lockedByName) {
		this.lockedByName = lockedByName;
	}

	public String getLockedByUsername() {
		return lockedByUsername;
	}

	public void setLockedByUsername(String lockedByUsername) {
		this.lockedByUsername = lockedByUsername;
	}

	public String getLockedByEmail() {
		return lockedByEmail;
	}

	public void setLockedByEmail(String lockedByEmail) {
		this.lockedByEmail = lockedByEmail;
	}

	public String getLockedByCompanyCode() {
		return lockedByCompanyCode;
	}

	public void setLockedByCompanyCode(String lockedByCompanyCode) {
		this.lockedByCompanyCode = lockedByCompanyCode;
	}

	public String getLockedByCompanyName() {
		return lockedByCompanyName;
	}

	public void setLockedByCompanyName(String lockedByCompanyName) {
		this.lockedByCompanyName = lockedByCompanyName;
	}

	public Timestamp getLockedAt() {
		return lockedAt;
	}

	public void setLockedAt(Timestamp lockedAt) {
		this.lockedAt = lockedAt;
	}

	public boolean isLocked() {
		return isLocked;
	}

	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getWfStatus() {
		return wfStatus;
	}

	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
}