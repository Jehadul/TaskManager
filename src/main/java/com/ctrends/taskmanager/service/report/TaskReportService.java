package com.ctrends.taskmanager.service.report;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ctrends.taskmanager.dao.report.ITaskReportDAO;
import com.ctrends.taskmanager.model.tman.TaskLog;
import com.ctrends.taskmanager.model.tman.Tasks;

@Service("tasklogService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TaskReportService implements ITaskReportService{

	@Autowired
	ITaskReportDAO taskReportDao;
	
	@Override
	public Map<String, String> insert(Map<String, String[]> requestMap) {
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
	public List<Tasks> find(Map<String, String> params) {
		return taskReportDao.getDocs(params);
		//return null;
	}

	@Override
	public TaskLog getByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Tasks> getAll() {
		return taskReportDao.getAllDoc();
	}


	@Override
	public Tasks getById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}
	
/*	public HashMap<String, Object> getTaskReportElement(Map<String, Object> params) {
		HashMap<String, Object> searchResult = taskReportDao.getTaskReportElement(params);
		return searchResult;
	
	}*/


	@Override
	public List<TaskLog> findTwo(Map<String, Object> parameterMap) {
		return taskReportDao.getDocsTwo(parameterMap);
		
	}


	@Override
	public HashMap<String, Object> getTaskReportElement(Map<String, Object> parameterMap) {
		// TODO Auto-generated method stub
		return null;
	}

}
