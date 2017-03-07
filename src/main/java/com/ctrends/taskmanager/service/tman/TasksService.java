package com.ctrends.taskmanager.service.tman;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ctrends.taskmanager.dao.tman.ITasksDao;
import com.ctrends.taskmanager.model.taskmanage.Module;
import com.ctrends.taskmanager.model.taskmanage.Suite;
import com.ctrends.taskmanager.model.tman.Tasks;

@Repository("tasksService")
public class TasksService implements ITasksService {

	@Autowired
	ITasksDao tasksDao;
	
	@Override
	public Map<String, String> insert(Map<String, String[]> requestMap) {
		Map<String, String> data = new HashMap<String,String>();
		
		Tasks tasks=new Tasks();
		tasks.setSuiteCode(requestMap.get("suite_code")[0]);
		tasks.setModuleCode(requestMap.get("module_code")[0]);
		tasks.setPrivGrpCode(Integer.parseInt(requestMap.get("priv_grp_code")[0]));
		tasks.setDescription(requestMap.get("description")[0]);
		tasks.setStoryCode(requestMap.get("story_code")[0]);
	    
		tasks.setTaskTitle(requestMap.get("task_title")[0]);
		tasks.setEstimatedTime(requestMap.get("estimated_time")[0]);
		tasks.setAsignee(requestMap.get("assignee")[0]);
		UUID id = tasksDao.insertDoc(tasks);
		data.put("id", id.toString());
		return data ;
	}

	@Override
	public List<Tasks> getAll() {
		List<Tasks> taskLi=tasksDao.getAllDoc();
		return taskLi;
	}

	@Override
	public Tasks getById(UUID id) {
		return tasksDao.getDocById(id);
	}

	
	
	
	@Override
	public Map<String, String> update(Map<String, String[]> requestMap) {
		Map<String, String> data = new HashMap<String, String>();
		
		//System.out.println(":::::"+requestMap.get("id")[0]);
		Tasks tasks = tasksDao.getDocById(UUID.fromString(requestMap.get("id")[0]));
		
		tasks.setSuiteCode(requestMap.get("suite_code")[0]);
		tasks.setModuleCode(requestMap.get("module_code")[0]);	
		tasks.setPrivGrpCode(Integer.parseInt(requestMap.get("priv_grp_code")[0]));
		tasks.setDescription(requestMap.get("description")[0]);
		tasks.setStoryCode(requestMap.get("story_code")[0]);
	    
		tasks.setTaskTitle(requestMap.get("task_title")[0]);
		tasks.setEstimatedTime(requestMap.get("estimated_time")[0]);
		tasks.setAsignee(requestMap.get("assignee")[0]);		
		
		UUID id = tasksDao.updateDoc(tasks);
		data.put("id", id.toString());
		return data;
	}
	
	@Override
	public Map<String, String> updateTasklist(Map<String, String[]> requestMap) {
		Map<String, String> data = new HashMap<String, String>();
		
		//System.out.println(":::::"+requestMap.get("id")[0]);
		Tasks tasks = tasksDao.getDocById(UUID.fromString(requestMap.get("id")[0]));
  
		tasks.setTaskTitle(requestMap.get("task_title")[0]);
		tasks.setEstimatedTime(requestMap.get("estimated_time")[0]);
		tasks.setSpentTime(requestMap.get("spent_time")[0]);
		tasks.setRemainingTime(requestMap.get("remaining_time")[0]);
		tasks.setAsignee(requestMap.get("assignee")[0]);		
		
		UUID id = tasksDao.updateDoc(tasks);
		data.put("id", id.toString());
		return data;
	}

	@Override
	public UUID delete(Map<String, String[]> requestMap) {
		UUID id = tasksDao.deleteDoc(UUID.fromString(requestMap.get("id")[0]));
		return id;
	}

	@Override
	public List<Tasks> find(Map<String, String> params) {
		List<Tasks> searchResult = tasksDao.getDocs(params);
		//System.out.println("............."+searchResult+"zihad");
		return searchResult;
	}

}
