package com.ctrends.taskmanager.dao.tman;

import java.util.List;

import java.util.Map;
import java.util.UUID;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ctrends.taskmanager.model.taskmanage.Module;
import com.ctrends.taskmanager.model.taskmanage.Suite;
import com.ctrends.taskmanager.model.tman.Tasks;

@Repository("tasksDao")
public class TasksDao implements ITasksDao {

	@Autowired
	private SessionFactory sessionfactory;
	
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

	@Transactional
	@Override
	public List<Suite> getAllSuites() {
		Query query=sessionfactory.getCurrentSession().createQuery("From Suite");
		List<Suite> suiteLi=query.list();
		suiteLi.get(0);
		return suiteLi;
	}

	@Transactional
	@Override
	public List<Module> getAllModules() {
		Query query=sessionfactory.getCurrentSession().createQuery("From Module");
		List<Module> moduleLi=query.list();
		moduleLi.get(0);
		return moduleLi;
	}

	@Transactional
	@Override
	public List<Module> getBySuit(String suitCode) {
		Query query = sessionfactory.getCurrentSession().createQuery("from Module where suiteCode =:suiteCode order by modSeq");
		query.setParameter("suiteCode", suitCode);
		List<Module> modList = query.list();
		
		return modList;
	}


}
