package com.ctrends.taskmanager.dao.tman_sprint;

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
import com.ctrends.taskmanager.model.tman_sprint.SprintManager;
import com.ctrends.taskmanager.model.userstory.UserStory;

@Repository("sprintDAO")
public class SprintDAO implements ISprintDAO {

	
	@Autowired
	private SessionFactory sessionfactory;
	
	@Transactional
	@Override
	public List<SprintManager> getAllDoc() {
		Query query=sessionfactory.getCurrentSession().createQuery("From SprintManager");
		List<SprintManager> splist=query.list();
		return splist;
	}

	@Transactional
	@Override
	public SprintManager getDocById(UUID id) {
		Query query = sessionfactory.getCurrentSession().createQuery("From SprintManager WHERE id = :id");
		query.setParameter("id", id);
		List<SprintManager> pt = query.list();
		if(pt.size()>0){
			return pt.get(0);
		}
		return null;
	}

	@Override
	public List<SprintManager> getDocs(Map<String, String> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public UUID insertDoc(SprintManager doc) {
		UUID id = (UUID) sessionfactory.getCurrentSession().save(doc);
		sessionfactory.getCurrentSession().flush();
		return id;
	}
	
	@Transactional
	@Override
	public UUID updateDoc(SprintManager doc) {
		sessionfactory.getCurrentSession().saveOrUpdate(doc);
		sessionfactory.getCurrentSession().flush();
		return doc.getId();
	}

	@Transactional
	@Override
	public UUID deleteDoc(UUID id) {
		SprintManager app =	(SprintManager)sessionfactory.getCurrentSession()
				.load(SprintManager.class, id);
		sessionfactory.getCurrentSession().delete(app);
		sessionfactory.getCurrentSession().flush();
		return id;
	}

	
	@Transactional
	@Override
	public List<Suite> getAllSuites() {
		Query query=sessionfactory.getCurrentSession().createQuery("From Suite");
		List<Suite> suites=query.list();
		return suites;
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
	public List<PrivGroup> getPrivGroup(String suiteCode, String modeCode) {
		String hqlQuery = "from PrivGroup where suiteCode =:suiteCode and  modCode =:modCode order by privGrpCode";
		Query query = sessionfactory.getCurrentSession().createQuery(hqlQuery);
		query.setParameter("suiteCode", suiteCode);
		query.setParameter("modCode", modeCode);
		List<PrivGroup> privGroup = query.list();
		return privGroup;
	}

}