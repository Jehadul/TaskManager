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
import com.ctrends.taskmanager.model.taskmanage.Privilege;
import com.ctrends.taskmanager.model.taskmanage.Suite;
import com.ctrends.taskmanager.model.tman.Tasks;
import com.ctrends.taskmanager.model.userstory.UserStory;

@Repository("userStoryDao")
public class UserStoryDAO implements IUserStoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<UserStory> getAllDoc() {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	@Override
	public UserStory getDocById(UUID id) {
		Query query = sessionFactory.getCurrentSession().createQuery("From UserStory WHERE id = :id");
		query.setParameter("id", id);
		List<UserStory> pt = query.list();
		if(pt.size()>0){
			return pt.get(0);
		}
		return null;
	}

	@Override
	public List<UserStory> getDocs(Map<String, String> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public UUID insertDoc(UserStory doc) {
		UUID id = (UUID) sessionFactory.getCurrentSession().save(doc);
		sessionFactory.getCurrentSession().flush();
		return id;
	}
	
	@Transactional
	@Override
	public UUID updateDoc(UserStory doc) {
		sessionFactory.getCurrentSession().saveOrUpdate(doc);
		sessionFactory.getCurrentSession().flush();
		return doc.getId();
	}

	@Override
	public UUID deleteDoc(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
