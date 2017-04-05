package com.ctrends.taskmanager.service.task_status;

import java.util.List;
import java.util.Map;

import com.ctrends.taskmanager.model.task_status.TaskDetails;
import com.ctrends.taskmanager.model.tman.Tasks;
import com.ctrends.taskmanager.model.tman_sprint.SprintManagerDetails;
import com.ctrends.taskmanager.service.ICommonService;

public interface ITaskStatusService extends ICommonService<TaskDetails> {
	

	Map<String, Object> getSprintManagerBySprintCode(String sprintCode);

	List<Tasks> getTaskByStoryCode(Map<String, String> allStoryCode);

	Map<String, String> manageselection(Map<String, String[]> map);

}
