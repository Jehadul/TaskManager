package com.ctrends.taskmanager.model.tman_sprint;

import java.sql.Date;

import javax.persistence.Column;

public class SprintView {
	private String sprintCode;
	private String sprintName;	
	private Date startDate;
	private Date endDate;
	private double estimatedTime;	
	private long spentTime;	
	private long remainingTime;
	public String getSprintCode() {
		return sprintCode;
	}
	public void setSprintCode(String sprintCode) {
		this.sprintCode = sprintCode;
	}
	public String getSprintName() {
		return sprintName;
	}
	public void setSprintName(String sprintName) {
		this.sprintName = sprintName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(estimatedTime);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (remainingTime ^ (remainingTime >>> 32));
		result = prime * result + (int) (spentTime ^ (spentTime >>> 32));
		result = prime * result + ((sprintCode == null) ? 0 : sprintCode.hashCode());
		result = prime * result + ((sprintName == null) ? 0 : sprintName.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SprintView other = (SprintView) obj;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (Double.doubleToLongBits(estimatedTime) != Double.doubleToLongBits(other.estimatedTime))
			return false;
		if (remainingTime != other.remainingTime)
			return false;
		if (spentTime != other.spentTime)
			return false;
		if (sprintCode == null) {
			if (other.sprintCode != null)
				return false;
		} else if (!sprintCode.equals(other.sprintCode))
			return false;
		if (sprintName == null) {
			if (other.sprintName != null)
				return false;
		} else if (!sprintName.equals(other.sprintName))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "SprintView [sprintCode=" + sprintCode + ", sprintName=" + sprintName + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", estimatedTime=" + estimatedTime + ", spentTime=" + spentTime
				+ ", remainingTime=" + remainingTime + "]";
	}
	
}
