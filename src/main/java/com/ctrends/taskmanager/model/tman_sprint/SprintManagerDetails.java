package com.ctrends.taskmanager.model.tman_sprint;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tman_sprint_details")
public class SprintManagerDetails {
	
	@Id
	@Column(name = "id")
	@org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(name = "suite_code")
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
	
	@Column(name = "sprint_story_code")
	private String sprintStoryCode;

	@Column(name = "sprint_story_Name")
	private String sprintStoryName;
	
	@Column(name = "sprint_code")
	private String sprintCode;
	
	@Column(name = "sprint_name")
	private String sprintName;
	
	@Column(name = "sprint_id")
	private UUID sprintId;
	
	@Column(name = "branch_code")
	private String branchCode;

	@Column(name = "branch_name")
	private String branchName;

	@Column(name = "client_code")
	private String clientCcode;

	@Column(name = "client_name")
	private String clientName;

	@Column(name = "company_code")
	private String companyCode;

	@Column(name = "company_name")
	private String companyCame;

	@Column(name = "costcenter_code")
	private String costcenterCode;

	@Column(name = "costcenter_name")
	private String costcenterName;

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

	@Column(name = "profitcenter_code")
	private String profitcenterCode;

	@Column(name = "profitcenter_name")
	private String profitcenterName;

	@Column(name = "status")
	private String status;

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

	public String getSprintCode() {
		return sprintCode;
	}

	
	public String getSprintName() {
		return sprintName;
	}

	public void setSprintName(String sprintName) {
		this.sprintName = sprintName;
	}

	public void setSprintCode(String sprintCode) {
		this.sprintCode = sprintCode;
	}
	
	public UUID getSprintId() {
		return sprintId;
	}

	public void setSprintId(UUID sprintId) {
		this.sprintId = sprintId;
	}

	public String getSprintStoryCode() {
		return sprintStoryCode;
	}

	public void setSprintStoryCode(String sprintStoryCode) {
		this.sprintStoryCode = sprintStoryCode;
	}

	public String getSprintStoryName() {
		return sprintStoryName;
	}

	public void setSprintStoryName(String sprintStoryName) {
		this.sprintStoryName = sprintStoryName;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getClientCcode() {
		return clientCcode;
	}

	public void setClientCcode(String clientCcode) {
		this.clientCcode = clientCcode;
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

	public String getCompanyCame() {
		return companyCame;
	}

	public void setCompanyCame(String companyCame) {
		this.companyCame = companyCame;
	}

	public String getCostcenterCode() {
		return costcenterCode;
	}

	public void setCostcenterCode(String costcenterCode) {
		this.costcenterCode = costcenterCode;
	}

	public String getCostcenterName() {
		return costcenterName;
	}

	public void setCostcenterName(String costcenterName) {
		this.costcenterName = costcenterName;
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

	
	public String getProfitcenterCode() {
		return profitcenterCode;
	}

	public void setProfitcenterCode(String profitcenterCode) {
		this.profitcenterCode = profitcenterCode;
	}

	public String getProfitcenterName() {
		return profitcenterName;
	}

	public void setProfitcenterName(String profitcenterName) {
		this.profitcenterName = profitcenterName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	
	
	
}
