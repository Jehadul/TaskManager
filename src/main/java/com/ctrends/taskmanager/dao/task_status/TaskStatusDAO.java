package com.ctrends.taskmanager.dao.task_status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
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

		Map<String, Object> allTaskList = new HashMap<String, Object>();
		
		Query query = sessionfactory.getCurrentSession()
				.createQuery("FROM SprintManagerDetails WHERE sprintCode =:sprintCode");
		query.setParameter("sprintCode", request.get("sprintCode"));

		List<Object> toDoAllTask = new ArrayList<>();
		List<Object> toInProgressAllTask = new ArrayList<>();
		List<Object> toReviewAllTask = new ArrayList<>();
		
		
		List<SprintManagerDetails> sprintManagerDetail = query.list();		//1
		String[] storyCode = new String[sprintManagerDetail.size()+1];		//3
		for (int i = 0; i < sprintManagerDetail.size(); i++) {				//2
			storyCode[i]=sprintManagerDetail.get(i).getSprintStoryCode();
		}
		
		Criteria toDoCr = sessionfactory.getCurrentSession().createCriteria(Tasks.class);
		toDoCr.add(Restrictions.in("storyCode", storyCode));
		toDoCr.add(Restrictions.eq("taskStatus", "To Do"));
		List<Tasks> toDoTaskList = toDoCr.list();
		toDoAllTask.add(toDoTaskList);
		
		Criteria toInProgressCr = sessionfactory.getCurrentSession().createCriteria(Tasks.class);
		toInProgressCr.add(Restrictions.in("storyCode", storyCode));
		toInProgressCr.add(Restrictions.eq("taskStatus", "In Progress"));
		List<Tasks> toInProgressTaskList = toInProgressCr.list();
		toInProgressAllTask.add(toInProgressTaskList);
		
		Criteria toBeReviewSql = sessionfactory.getCurrentSession().createCriteria(Tasks.class);
		toBeReviewSql.add(Restrictions.in("storyCode", storyCode));
		toBeReviewSql.add(Restrictions.eq("taskStatus", "To Be Review"));
		List<Tasks> toBeReviewTaskList = toBeReviewSql.list();
		toReviewAllTask.add(toBeReviewTaskList);
		
		
		for(Tasks t:toBeReviewTaskList){
			System.out.println(t.getId().toString());
		}
		
		
		allTaskList.put("sprintManagerDetail", sprintManagerDetail);

		allTaskList.put("toDoAllTask", toDoAllTask);
		allTaskList.put("toInProgressAllTask", toInProgressAllTask);
		allTaskList.put("toReviewAllTask", toReviewAllTask);

		return allTaskList;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Tasks> getTaskByStoryCode(Map<String, String> request) {

		System.out.println(request.get("storyCodeAll") + "storyCodeAll");
		Query query = sessionfactory.getCurrentSession().createQuery("FROM Tasks WHERE storyCode =:storyCode");
		query.setParameter("storyCode", request.get("storyCode"));

		// query.setBoolean("isEnabled", Boolean.TRUE);

		List<Tasks> taskDetail = query.list();

		System.out.println("taskdetail::::::::::::::" + taskDetail.size());

		if (taskDetail == null) {
			throw new UsernameNotFoundException("does not exist.");
		}
		return taskDetail;
	}
	
	@Transactional
	@Override
	public UUID updateTaskStatus(Tasks doc) {
		sessionfactory.getCurrentSession().saveOrUpdate(doc);
		sessionfactory.getCurrentSession().flush();
		return doc.getId();
	}

}
