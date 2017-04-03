package com.ctrends.taskmanager.model.tman;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TaskReportView {

	private Date startdate;
	private Date stopdate;
	private Timestamp startTime;
	private Timestamp stopTime;
	private String taskId;
	private String taskCode;
	private String taskTitle;
	private String storyCode;
	private String storyTitle;
	private String suiteCode;
	private String suiteName;
	private String moduleCode;
	private String moduleName;
	private int privGrpCode;
	private String privGrpName;
	private double estimatedTime;
	private long spentTime;
	private long remainingTime;
	private String empCode;
	private String empName;
	private String username;
	private String companyName;
	private String companyCode;

	private List<TaskLog> taskLogList;
	private String totalDaySpentTime;

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getStopdate() {
		return stopdate;
	}

	public void setStopdate(Date stopdate) {
		this.stopdate = stopdate;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getStopTime() {
		return stopTime;
	}

	public void setStopTime(Timestamp stopTime) {
		this.stopTime = stopTime;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
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

	public double getEstimatedTime() {
		return estimatedTime;
	}

	public void setEstimatedTime(double estimatedTime) {
		this.estimatedTime = estimatedTime;
	}

	public long getSpentTime() {
		return spentTime;
	}

	public void setSpentTime(long spentTime) {
		this.spentTime = spentTime;
	}

	public long getRemainingTime() {
		return remainingTime;
	}

	public void setRemainingTime(long remainingTime) {
		this.remainingTime = remainingTime;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public List<TaskLog> getTaskLogList() {
		return taskLogList;
	}

	public void setTaskLogList(List<TaskLog> taskLogList) {
		this.taskLogList = taskLogList;
	}

	public String getTotalDaySpentTime() {
		return totalDaySpentTime;
	}

	public void setTotalDaySpentTime(String totalDaySpentTime) {
		this.totalDaySpentTime = totalDaySpentTime;
	}

}
