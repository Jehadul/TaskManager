package com.ctrends.taskmanager.dao.userstory;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ctrends.taskmanager.dao.user.IUserDAO;
import com.ctrends.taskmanager.model.tman.Tasks;
import com.ctrends.taskmanager.model.user.User;
import com.ctrends.taskmanager.model.userstory.UserStory;

@Repository("userStoryDao")
public class UserStoryDAO implements IUserStoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	IUserDAO userDAO;
	

	@Transactional
	@Override
	public List<UserStory> getAllDoc() {
		Query query=sessionFactory.getCurrentSession().createQuery("From UserStory Order By priorityCode");
		List<UserStory> userStoryLi=query.list();
		return userStoryLi;
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

	@Transactional
	@Override
	public List<UserStory> getDocs(Map<String, String> params) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from UserStory where userStoryCode like :userStoryCode and "+"userStoryTitle like :userStoryTitle");
		
		query.setParameter("userStoryCode", "%" + params.get("userStoryCode") + "%");
		query.setParameter("userStoryTitle", "%" + params.get("userStoryTitle") + "%");
		
		List<UserStory> userStoryLi = query.list();
				
		return userStoryLi;
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

	@Transactional
	@Override
	public UUID deleteDoc(UUID id) {
		UserStory app =	(UserStory)sessionFactory.getCurrentSession()
				.load(UserStory.class, id);
		sessionFactory.getCurrentSession().delete(app);
		sessionFactory.getCurrentSession().flush();
		return id;
	}
	
	@Transactional
	@Override
	public boolean checkUnique(Map<String, String> requestMap) {
		// TODO Auto-generated method stub
		User currentUser = userDAO.getCurrentUser();
		String companyCode = currentUser.getCompanyCode();
		Query query = sessionFactory.getCurrentSession().createQuery("FROM UserStory WHERE userStoryCode =:userStoryCode AND companyCode=:companyCode");
		query.setParameter("companyCode",companyCode);
		query.setParameter("userStoryCode", requestMap.get("userStoryCode"));
		
		
		
		UserStory userstory = (UserStory) query.uniqueResult();

	    if (userstory == null) {
        	return true;
        }
        else{
        	return false;
        }
		
		
	}
	

}
