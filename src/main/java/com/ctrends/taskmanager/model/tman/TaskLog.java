package com.ctrends.taskmanager.model.tman;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="task_logs")
public class TaskLog {
	@Id
	@Column(name = "id")
	@org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private UUID id;
	
	@Column(name="start_time")
	String startTime;
	
	@Column(name="stop_time")
	String stopTime;
	
	@Column(name="date")
	Date date;
	
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

	@Column(name="profitcenter_code")
	private String profitcenterCode;
	
	@Column(name="profitcenter_name")
	private String profitcenterName;
	
	@Column(name="costcenter_code")
	private String costcenterCode;
	
	@Column(name="costcenter_name")
	private String costcenterName;

}
