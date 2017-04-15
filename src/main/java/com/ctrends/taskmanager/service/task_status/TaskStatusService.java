package com.ctrends.taskmanager.service.task_status;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctrends.taskmanager.dao.task_status.ITaskStatusDAO;
import com.ctrends.taskmanager.dao.tman.ITasksDao;
import com.ctrends.taskmanager.dao.tman_sprint.ISprintDAO;
import com.ctrends.taskmanager.model.task_status.TaskDetails;
import com.ctrends.taskmanager.model.tman.Tasks;
import com.ctrends.taskmanager.model.tman_sprint.SprintManager;
import com.ctrends.taskmanager.model.tman_sprint.SprintManagerDetails;

@Service("taskStatusService")
public class TaskStatusService implements ITaskStatusService {
	
	@Autowired
	ITaskStatusDAO taskStatusDAO;
	
	@Autowired
	ITasksDao tasksDao;
	
	@Autowired
	ISprintDAO sprintDao;

	@Override
	public Map<String, String> insert(Map<String, String[]> requestMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaskDetails> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaskDetails getById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> update(Map<String, String[]> requestMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UUID delete(Map<String, String[]> requestMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getSprintManagerBySprintCode(String sprintCode) {
		
		Map<String, String> request = new HashMap<String, String>();
		
		request.put("sprintCode", sprintCode);
		Map<String, Object> sprintdetail = taskStatusDAO.getSprintManager(request);
		
		
		return sprintdetail;
		 
	}

	@Override
	public UUID updateStatus(UUID id, String status) {
		Tasks task = tasksDao.getDocById(id);
		task.setTaskStatus(status);
		UUID returnId = taskStatusDAO.updateTaskStatus(task);
		return returnId;
	}

	@Override
	public UUID updateStoryStatus(UUID id, String status) {
		SprintManagerDetails story = sprintDao.getSprintDetailsById(id);
		story.setStoryStatus(status);
		UUID returnId = taskStatusDAO.updateStoryStatus(story);
		return returnId;
	}

}
