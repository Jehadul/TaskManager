package com.ctrends.taskmanager.dao.task_status;

import java.util.List;
import java.util.Map;

import com.ctrends.taskmanager.dao.ICommonDAO;
import com.ctrends.taskmanager.model.task_status.TaskDetails;
import com.ctrends.taskmanager.model.tman.Tasks;
import com.ctrends.taskmanager.model.tman_sprint.SprintManagerDetails;

public interface ITaskStatusDAO extends ICommonDAO<TaskDetails> {



	Map<String, Object> getSprintManager(Map<String, String> request);

	List<Tasks> getTaskByStoryCode(Map<String, String> request);

}
