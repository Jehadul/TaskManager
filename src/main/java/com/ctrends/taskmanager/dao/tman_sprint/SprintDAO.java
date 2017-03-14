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
import com.ctrends.taskmanager.model.tman.Tasks;
import com.ctrends.taskmanager.model.tman_sprint.SprintManager;

@Repository("sprintDAO")
public class SprintDAO implements ISprintDAO {

	
	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public List<SprintManager> getAllDoc() {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public UUID updateDoc(SprintManager doc) {
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
		List<Suite> suites=query.list();
		return suites;
	}

	@Override
	public List<PrivGroup> getAllPrivGrps() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Module> getAllModules() {
		// TODO Auto-generated method stub
		return null;
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
