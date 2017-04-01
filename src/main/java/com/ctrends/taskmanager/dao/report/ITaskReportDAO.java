package com.ctrends.taskmanager.dao.report;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ctrends.taskmanager.dao.ICommonDAO;
import com.ctrends.taskmanager.model.tman.TaskLog;
import com.ctrends.taskmanager.model.tman.Tasks;

public interface ITaskReportDAO extends ICommonDAO<Tasks> {

	HashMap<String, Object> getTaskReportElement(Map<String, Object> params);

	List<TaskLog> getAllTaskLog(Map<String, Object> parameterMap);
	List<Tasks> getAllTasks(Map<String, Object> parameterMap);
	
	

}