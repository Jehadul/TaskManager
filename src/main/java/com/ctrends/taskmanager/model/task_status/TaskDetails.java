package com.ctrends.taskmanager.model.task_status;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task_details")
public class TaskDetails {
	
	@Id
	@Column(name = "id")
	@org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private UUID id;
	
	@Column(name="story_code")
	private String storyCode;

	@Column(name="story_title")
	private String storyTitle;

	@Column(name="story_desc")
	private String storyDesc;
	
	@Column(name="story_qa_status")
	private Boolean isStoryQaStatus;

	@Column(name="task_code")
	private String taskCode;

	@Column(name="task_title")
	private String taskTitle;
	
	@Column(name="task_inprogress_status")
	private Boolean isTaskInprogressStatus;
	
	@Column(name = "estimated_time")
	private double estimatedTime;
	
	@Column(name = "remaining_time")
	private double remainingTime;

	@Column(name="task_code_inprogress")
	private String taskCodeInprogress;

	@Column(name="task_title_inprogress")
	private String taskTitleInprogress;
	
	@Column(name="review_hide_status")
	private Boolean isReviewHideStatus;

	@Column(name="story_code_qa")
	private String storyCodeQa;

	@Column(name="story_title_qa")
	private String storyTitleQa;

	@Column(name="story_desc_qa")
	private String storyDescQa;
	
	@Column(name="qa_status")
	private Boolean isQaStatus;
	
	@Column(name="created_at_timestamp")
	private Timestamp createdAtTimestamp;

	@Column(name="created_by_code")
	private String createdByCode;

	@Column(name="created_by_company_code")
	private String createdByCompanyCode;

	@Column(name="created_by_company_name")
	private String createdByCompanyName;

	@Column(name="created_by_email")
	private String createdByEmail;

	@Column(name="created_by_name")
	private String createdByName;

	@Column(name="created_by_username")
	private String createdByUsername;
	
	@Column(name="updated_at_timestamp")
	private Timestamp updatedAtTimestamp;

	@Column(name="updated_by_code")
	private String updatedByCode;

	@Column(name="updated_by_company_code")
	private String updatedByCompanyCode;

	@Column(name="updated_by_company_name")
	private String updatedByCompanyName;

	@Column(name="updated_by_email")
	private String updatedByEmail;

	@Column(name="updated_by_name")
	private String updatedByName;

	@Column(name="updated_by_username")
	private String updatedByUsername;

	public UUID getId() {
		return id;
	}

	public String getStoryCode() {
		return storyCode;
	}

	public void setStoryCode(String storyCode) {
		this.storyCode = storyCode;
	}

	public String getStoryTitle() {
		return storyTitle;
	}

	public void setStoryTitle(String storyTitle) {
		this.storyTitle = storyTitle;
	}

	public String getStoryDesc() {
		return storyDesc;
	}

	public void setStoryDesc(String storyDesc) {
		this.storyDesc = storyDesc;
	}

	public Boolean getIsStoryQaStatus() {
		return isStoryQaStatus;
	}

	public void setIsStoryQaStatus(Boolean isStoryQaStatus) {
		this.isStoryQaStatus = isStoryQaStatus;
	}

	public String getTaskCode() {
		return taskCode;
	}

	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}

	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	public Boolean getIsTaskInprogressStatus() {
		return isTaskInprogressStatus;
	}

	public void setIsTaskInprogressStatus(Boolean isTaskInprogressStatus) {
		this.isTaskInprogressStatus = isTaskInprogressStatus;
	}

	public double getEstimatedTime() {
		return estimatedTime;
	}

	public void setEstimatedTime(double estimatedTime) {
		this.estimatedTime = estimatedTime;
	}

	public double getRemainingTime() {
		return remainingTime;
	}

	public void setRemainingTime(double remainingTime) {
		this.remainingTime = remainingTime;
	}

	public String getTaskCodeInprogress() {
		return taskCodeInprogress;
	}

	public void setTaskCodeInprogress(String taskCodeInprogress) {
		this.taskCodeInprogress = taskCodeInprogress;
	}

	public String getTaskTitleInprogress() {
		return taskTitleInprogress;
	}

	public void setTaskTitleInprogress(String taskTitleInprogress) {
		this.taskTitleInprogress = taskTitleInprogress;
	}

	public Boolean getIsReviewHideStatus() {
		return isReviewHideStatus;
	}

	public void setIsReviewHideStatus(Boolean isReviewHideStatus) {
		this.isReviewHideStatus = isReviewHideStatus;
	}

	public String getStoryCodeQa() {
		return storyCodeQa;
	}

	public void setStoryCodeQa(String storyCodeQa) {
		this.storyCodeQa = storyCodeQa;
	}

	public String getStoryTitleQa() {
		return storyTitleQa;
	}

	public void setStoryTitleQa(String storyTitleQa) {
		this.storyTitleQa = storyTitleQa;
	}

	public String getStoryDescQa() {
		return storyDescQa;
	}

	public void setStoryDescQa(String storyDescQa) {
		this.storyDescQa = storyDescQa;
	}

	public Boolean getIsQaStatus() {
		return isQaStatus;
	}

	public void setIsQaStatus(Boolean isQaStatus) {
		this.isQaStatus = isQaStatus;
	}

	public Timestamp getCreatedAtTimestamp() {
		return createdAtTimestamp;
	}

	public void setCreatedAtTimestamp(Timestamp createdAtTimestamp) {
		this.createdAtTimestamp = createdAtTimestamp;
	}

	public String getCreatedByCode() {
		return createdByCode;
	}

	public void setCreatedByCode(String createdByCode) {
		this.createdByCode = createdByCode;
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

	public String getCreatedByEmail() {
		return createdByEmail;
	}

	public void setCreatedByEmail(String createdByEmail) {
		this.createdByEmail = createdByEmail;
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

	public Timestamp getUpdatedAtTimestamp() {
		return updatedAtTimestamp;
	}

	public void setUpdatedAtTimestamp(Timestamp updatedAtTimestamp) {
		this.updatedAtTimestamp = updatedAtTimestamp;
	}

	public String getUpdatedByCode() {
		return updatedByCode;
	}

	public void setUpdatedByCode(String updatedByCode) {
		this.updatedByCode = updatedByCode;
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

	public String getUpdatedByEmail() {
		return updatedByEmail;
	}

	public void setUpdatedByEmail(String updatedByEmail) {
		this.updatedByEmail = updatedByEmail;
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

	public void setId(UUID id) {
		this.id = id;
	}
	
	

}
