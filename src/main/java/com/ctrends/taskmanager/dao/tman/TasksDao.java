package com.ctrends.taskmanager.dao.tman;

import java.util.List;

import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.ctrends.taskmanager.model.tman.Tasks;

@Repository("tasksDao")
public class TasksDao implements ITasksDao {

	@Override
	public List<Tasks> getAllDoc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tasks getDocById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tasks> getDocs(Map<String, String> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UUID insertDoc(Tasks doc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UUID updateDoc(Tasks doc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UUID deleteDoc(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
