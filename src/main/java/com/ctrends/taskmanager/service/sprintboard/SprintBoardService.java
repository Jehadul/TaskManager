package com.ctrends.taskmanager.service.sprintboard;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.ctrends.taskmanager.dao.tman_sprint.ISprintDAO;
import com.ctrends.taskmanager.model.tman_sprint.SprintManager;

public class SprintBoardService implements ISprintBoardService {

	@Autowired
	ISprintDAO sprintDAO;
	
	
	@Override
	public Map<String, String> insert(Map<String, String[]> requestMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SprintManager> getAll() {
		return sprintDAO.getAllDoc();
	}

	@Override
	public SprintManager getById(UUID id) {
		// TODO Auto-generated method stub
		return sprintDAO.getDocById(id);
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
