package com.ctrends.taskmanager.service.report;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ctrends.taskmanager.model.tman.TaskLog;
import com.ctrends.taskmanager.model.tman.Tasks;
import com.ctrends.taskmanager.service.ICommonService;

public interface ITaskReportService extends ICommonService<Tasks>{
	HashMap<String, Object> getTaskReportElement(Map<String, Object> parameterMap);
	
	public List<Tasks> find(Map<String, String> params);
	public TaskLog getByCode(String code);

	List<TaskLog> findTwo(Map<String, Object> parameterDate);
}
