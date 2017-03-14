package com.ctrends.taskmanager.dao.userstory;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ctrends.taskmanager.model.taskmanage.Module;
import com.ctrends.taskmanager.model.taskmanage.PrivGroup;
import com.ctrends.taskmanager.model.taskmanage.Suite;
import com.ctrends.taskmanager.model.userstory.UserStory;

@Repository("userStoryDao")
public class UserStoryDAO implements IUserStoryDAO {
	
	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public List<UserStory> getAllDoc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserStory getDocById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserStory> getDocs(Map<String, String> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UUID insertDoc(UserStory doc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UUID updateDoc(UserStory doc) {
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
		return suiteLi;
	}

	@Transactional
	@Override
	public List<Module> getAllModules() {
		Query query=sessionfactory.getCurrentSession().createQuery("From Module");
		List<Module> moduleLi=query.list();
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

	@Transactional
	@Override
	public List<PrivGroup> getAllPrivGrps() {
		Query query=sessionfactory.getCurrentSession().createQuery("From PrivGroup");
		List<PrivGroup> privgrpLi=query.list();
		return privgrpLi;
	}
	
	@Transactional
	@Override
	public List<PrivGroup> getPrivGroup(String suiteCode, String modeCode) {
		String hqlQuery = "from PrivGroup where suiteCode =:suiteCode and  modCode =:modCode order by privGrpCode";
		Query query = sessionfactory.getCurrentSession().createQuery(hqlQuery);
		query.setParameter("suiteCode", suiteCode);
		query.setParameter("modCode", modeCode);
		List<PrivGroup> privGroup = query.list();
		return privGroup;
	}

}
