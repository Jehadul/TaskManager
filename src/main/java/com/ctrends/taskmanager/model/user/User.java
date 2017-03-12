package com.ctrends.taskmanager.model.user;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ac_users")
public class User {
	@Id
	@Column(name = "id")
	@org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private UUID id;
	
	 
	@Column(name="emp_code")
	private String empCode;
	
	@Column(name="emp_name")
	private String empName;
	
	@Column(name="desig")
	private String desig;
	
	@Column(name="email")
	private String email;
	
	@Column(name="pwd")
	private String pwd;
	
	@Column(name="secret_key")
	private String secretKey;
	
	@Column(name="pwd2")
	private String pwd2;
	
	@Column(name="pwd3")
	private String pwd3;
	
	@Column(name="pwd4")
	private String pwd4;
	
	@Column(name="last_access_ip")
	private String lastAccessIp;
	
	@Column(name="last_access_datetime")
	private String lastAccessDatetime;
	
	@Column(name="curr_access_ip")
	private String currAccessIp;
	
	@Column(name="curr_access_datetime")
	private String currAccessDatetime;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="middle_name")
	private String middleName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="last_password_changed")
	private Timestamp lastPasswordChanged;
	
	@Column(name="user_status")
	private String userStatus;
	
	@Column(name="force_password_change_on_nextlogin")
	private String forcePasswordChangeOnNextlogin;
	
	@Column(name="username")
	private String username;
	
	@Column(name="role_code")
	private String roleCode;
	
	@Column(name="role_name")
	private String roleName;
	
	@Column(name="remember_token")
	private String rememberToken;
	
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
	
	@Column(name="submitted_by_code")
	private String submittedByCode;
	
	@Column(name="submitted_by_name")
	private String submittedByName;
	
	@Column(name="submitted_by_username")
	private String submittedByUsername;
	
	@Column(name="submitted_by_email")
	private String submittedByEmail;
	
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
	
	@Column(name="locked_at")
	private Timestamp lockedAt;
	
	@Column(name="is_locked")
	private Boolean isLocked;
	
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
	
	@Column(name="branch_code")
	private String branchCode;
	
	@Column(name="branch_name")
	private String branchName;
	
	@Column(name="division_code")
	private String divisionCode;
	
	@Column(name="division_name")
	private String divisionName;
	
	@Column(name="department_code")
	private String departmentCode;
	
	@Column(name="department_name")
	private String departmentName;
	
	@Column(name="profit_center_code")
	private String profitCenterCode;
	
	@Column(name="profit_center_name")
	private String profitCenteName;
	
	@Column(name="cost_center_code")
	private String costCenterCode;
	
	@Column(name="cost_center_name")
	private String costCenterName;
	
	@Column(name="ui_theme")
	private String uiTheme;
	
	@Column(name="ui_header_fixed")
	private boolean uiHeaderFixed;
	
	@Column(name="ui_footer_fixed")
	private boolean uiFooterFixed;
	
	@Column(name="ui_sidebar_fixed")
	private boolean uiSidebarFixed;
	
	@Column(name="ui_sidebar_closed")
	private boolean uiSidebarClosed;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDesig() {
		return desig;
	}

	public void setDesig(String desig) {
		this.desig = desig;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getPwd2() {
		return pwd2;
	}

	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}

	public String getPwd3() {
		return pwd3;
	}

	public void setPwd3(String pwd3) {
		this.pwd3 = pwd3;
	}

	public String getPwd4() {
		return pwd4;
	}

	public void setPwd4(String pwd4) {
		this.pwd4 = pwd4;
	}

	public String getLastAccessIp() {
		return lastAccessIp;
	}

	public void setLastAccessIp(String lastAccessIp) {
		this.lastAccessIp = lastAccessIp;
	}

	public String getLastAccessDatetime() {
		return lastAccessDatetime;
	}

	public void setLastAccessDatetime(String lastAccessDatetime) {
		this.lastAccessDatetime = lastAccessDatetime;
	}

	public String getCurrAccessIp() {
		return currAccessIp;
	}

	public void setCurrAccessIp(String currAccessIp) {
		this.currAccessIp = currAccessIp;
	}

	public String getCurrAccessDatetime() {
		return currAccessDatetime;
	}

	public void setCurrAccessDatetime(String currAccessDatetime) {
		this.currAccessDatetime = currAccessDatetime;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Timestamp getLastPasswordChanged() {
		return lastPasswordChanged;
	}

	public void setLastPasswordChanged(Timestamp lastPasswordChanged) {
		this.lastPasswordChanged = lastPasswordChanged;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getForcePasswordChangeOnNextlogin() {
		return forcePasswordChangeOnNextlogin;
	}

	public void setForcePasswordChangeOnNextlogin(String forcePasswordChangeOnNextlogin) {
		this.forcePasswordChangeOnNextlogin = forcePasswordChangeOnNextlogin;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRememberToken() {
		return rememberToken;
	}

	public void setRememberToken(String rememberToken) {
		this.rememberToken = rememberToken;
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

	public Timestamp getLockedAt() {
		return lockedAt;
	}

	public void setLockedAt(Timestamp lockedAt) {
		this.lockedAt = lockedAt;
	}

	public Boolean getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(Boolean isLocked) {
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

	public String getDivisionCode() {
		return divisionCode;
	}

	public void setDivisionCode(String divisionCode) {
		this.divisionCode = divisionCode;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getProfitCenterCode() {
		return profitCenterCode;
	}

	public void setProfitCenterCode(String profitCenterCode) {
		this.profitCenterCode = profitCenterCode;
	}

	public String getProfitCenteName() {
		return profitCenteName;
	}

	public void setProfitCenteName(String profitCenteName) {
		this.profitCenteName = profitCenteName;
	}

	public String getCostCenterCode() {
		return costCenterCode;
	}

	public void setCostCenterCode(String costCenterCode) {
		this.costCenterCode = costCenterCode;
	}

	public String getCostCenterName() {
		return costCenterName;
	}

	public void setCostCenterName(String costCenterName) {
		this.costCenterName = costCenterName;
	}

	public String getUiTheme() {
		return uiTheme;
	}

	public void setUiTheme(String uiTheme) {
		this.uiTheme = uiTheme;
	}

	public boolean isUiHeaderFixed() {
		return uiHeaderFixed;
	}

	public void setUiHeaderFixed(boolean uiHeaderFixed) {
		this.uiHeaderFixed = uiHeaderFixed;
	}

	public boolean isUiFooterFixed() {
		return uiFooterFixed;
	}

	public void setUiFooterFixed(boolean uiFooterFixed) {
		this.uiFooterFixed = uiFooterFixed;
	}

	public boolean isUiSidebarFixed() {
		return uiSidebarFixed;
	}

	public void setUiSidebarFixed(boolean uiSidebarFixed) {
		this.uiSidebarFixed = uiSidebarFixed;
	}

	public boolean isUiSidebarClosed() {
		return uiSidebarClosed;
	}

	public void setUiSidebarClosed(boolean uiSidebarClosed) {
		this.uiSidebarClosed = uiSidebarClosed;
	}
/*	public Approver toApprover(){
		Approver approver = new Approver(this.empCode, 
										 this.empName, 
										 this.email, 
										 this.username,
										 this.companyCode, 
										 this.companyName);
		System.out.println(this.empCode);
		return approver;

	}*/
}
