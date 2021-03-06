package com.ctrends.taskmanager.service.tman;

import java.util.List;
import java.util.Map;

import com.ctrends.taskmanager.model.tman.TaskLog;
import com.ctrends.taskmanager.model.tman.Tasks;
import com.ctrends.taskmanager.service.ICommonService;

public interface ITasksService extends ICommonService<Tasks>{
	
	public List<Tasks> find(Map<String, String> params);

	public Map<String, String> insertTaskLog(Map<String, String> requestMap);

	public Map<String, String> updateTimeLog(Map<String, String> requestMap);

	public List<Tasks> getAllByCurrentUser();

	public List<Tasks> getCurrentTaskByCurrentUser();
	public TaskLog getRunningTaskLogByCurrentUser();

	public List<Tasks> getTaskByStoryCode(String storyCode);
}
