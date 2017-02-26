package com.ctrends.taskmanager.service.tman;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.ctrends.taskmanager.model.tman.Tasks;

@Repository("tasksService")
public class TasksService implements ITasksService {

	@Override
	public Map<String, String> insert(Map<String, String[]> requestMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tasks> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tasks getById(UUID id) {
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

}
