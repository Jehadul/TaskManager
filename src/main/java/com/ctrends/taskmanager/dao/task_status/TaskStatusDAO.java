package com.ctrends.taskmanager.dao.task_status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.ctrends.taskmanager.model.task_status.TaskDetails;
import com.ctrends.taskmanager.model.tman.Tasks;
import com.ctrends.taskmanager.model.tman_sprint.SprintManagerDetails;

@Repository("taskStatusDAO")
public class TaskStatusDAO implements ITaskStatusDAO {
	
	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public List<TaskDetails> getAllDoc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaskDetails getDocById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaskDetails> getDocs(Map<String, String> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UUID insertDoc(TaskDetails doc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UUID updateDoc(TaskDetails doc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UUID deleteDoc(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public Map<String, Object> getSprintManager(Map<String, String> request) {
		
		Map <String, Object> allList1=new HashMap<String, Object>();
		
		
		Query query = sessionfactory.getCurrentSession()
				.createQuery("FROM SprintManagerDetails WHERE sprintCode =:sprintCode");
		query.setParameter("sprintCode", request.get("sprintCode"));
		

		List <Object> allTasks=new ArrayList<>();
		
		List<SprintManagerDetails> sprintManagerDetail = query.list();
		
		for(int i=0; i<sprintManagerDetail.size(); i++){
			Query q = sessionfactory.getCurrentSession()
					.createQuery("FROM Tasks WHERE storyCode =:storyCode");
			
			q.setParameter("storyCode", sprintManagerDetail.get(i).getSprintStoryCode());
			
			List <Tasks> taskList= q.list();
			
			allTasks.add(i, taskList);
			
		}
		if (sprintManagerDetail == null) {
			throw new UsernameNotFoundException("does not exist.");
		}
		allList1.put("sprintManagerDetail", sprintManagerDetail);
		
		allList1.put("task", allTasks);
		
		return allList1;
	}
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Tasks> getTaskByStoryCode(Map<String, String> request) {
		
		System.out.println(request.get("storyCodeAll")+"storyCodeAll");
		Query query = sessionfactory.getCurrentSession()
				.createQuery("FROM Tasks WHERE storyCode =:storyCode");
		query.setParameter("storyCode", request.get("storyCode"));
		
		//query.setBoolean("isEnabled", Boolean.TRUE);

		
		List<Tasks> taskDetail = query.list();
		
		System.out.println("taskdetail::::::::::::::"+taskDetail.size() );
		
		if (taskDetail == null) {
			throw new UsernameNotFoundException("does not exist.");
		}
		return taskDetail;
	}

}
