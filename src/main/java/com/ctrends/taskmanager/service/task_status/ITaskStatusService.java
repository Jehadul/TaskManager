package com.ctrends.taskmanager.service.task_status;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.ctrends.taskmanager.model.task_status.TaskDetails;
import com.ctrends.taskmanager.model.tman.Tasks;
import com.ctrends.taskmanager.model.tman_sprint.SprintManagerDetails;
import com.ctrends.taskmanager.service.ICommonService;

public interface ITaskStatusService extends ICommonService<TaskDetails> {
	

	Map<String, Object> getSprintManagerBySprintCode(String sprintCode);

	UUID updateStatus(UUID id, String status);

	UUID updateStoryStatus(UUID id, String status);

}
