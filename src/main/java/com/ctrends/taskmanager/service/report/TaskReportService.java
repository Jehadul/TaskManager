package com.ctrends.taskmanager.service.report;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ctrends.taskmanager.bean.Utility;
import com.ctrends.taskmanager.dao.report.ITaskReportDAO;
import com.ctrends.taskmanager.dao.report.TaskReportDAO;
import com.ctrends.taskmanager.model.tman.TaskLog;
import com.ctrends.taskmanager.model.tman.TaskReportView;
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
	
	public HashMap<String, Object> getTaskReportElement(Map<String, Object> params) {
		HashMap<String, Object> searchResult = taskReportDao.getTaskReportElement(params);
		return searchResult;
	
	}

/*
	@Override
	public List<TaskLog> findAllTaskLog(Map<String, Object> parameterMap) {
		return taskReportDao.getAllTaskLog(parameterMap);
		
	}


	@Override
	public HashMap<String, Object> getTaskReportElement(Map<String, Object> parameterMap) {
		// TODO Auto-generated method stub
		return null;
	}
*/
/*
	@Override
	public List<Tasks> findAllTasks(Map<String, Object> parameterMap) {
		return taskReportDao.getAllTasks(parameterMap);
	}
*/

	@Override
	public List<TaskReportView> findUserWiseDailyTasks(Map<String, String> parameterMap) {
		// TODO Auto-generated method stub
		return taskReportDao.getUserWiseDailyTasks(parameterMap);
	}

	@Override
	public Map<String, Object> getDailySummaryReportElement(Map<String, String> params) {
		
		TaskLog tasklog = new TaskLog();
		//java.sql.Date reportDate = (Date) Utility.toSqlDate(params.get("startDate"));
		java.sql.Date reportDate = (Date) Utility.toSqlDate(params.get("startDate"));
		tasklog.setStopDate(reportDate);
		Map<String, Object> map = taskReportDao.getAllDocByToDate(tasklog);
		return map;
	}


}