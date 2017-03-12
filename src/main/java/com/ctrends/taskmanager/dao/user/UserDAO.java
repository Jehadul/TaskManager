package com.ctrends.taskmanager.dao.user;


import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ctrends.taskmanager.model.user.User;

@Transactional
@Repository("userDAO")
public class UserDAO implements IUserDAO {

	@Autowired
	private SessionFactory sessionfactory;
	

	@Transactional
	@Override
	public List<User> getAllDoc() {

		Query query = sessionfactory.getCurrentSession().createQuery("From User");

		List<User> hrUsers = query.list();
		return hrUsers;
	}

	@Transactional
	@Override
	public User getDocById(UUID id) {
		Query query = sessionfactory.getCurrentSession().createQuery("From User WHERE id = :id");
		query.setParameter("id", id);
		List<User> hrUsers = query.list();
		return hrUsers.get(0);
	}

	@Override
	@Transactional
	public List<User> getDocs(Map<String, String> params) {
		Query query = sessionfactory.getCurrentSession()
				.createQuery("from User where empCode like :empCode and " + "empName like :empName");

		query.setParameter("empCode", "%" + params.get("empCode") + "%");
		query.setParameter("empName", "%" + params.get("empName") + "%");

		List<User> userList = query.list();
		if (userList == null) {
			throw new UsernameNotFoundException("does not exist.");
		}
		return userList;
	}


	@Transactional
	@Override
	public UUID insertDoc(User doc) {
		UUID id = (UUID) sessionfactory.getCurrentSession().save(doc);
		sessionfactory.getCurrentSession().flush();
		return id;
	}

	@Transactional
	@Override
	public UUID updateDoc(User doc) {
		sessionfactory.getCurrentSession().saveOrUpdate(doc);
		sessionfactory.getCurrentSession().flush();
		return doc.getId();
	}


	@Override
	public UUID deleteDoc(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

	/*Get Name of Current User*/
	@Override
	public String getCurrentUserName(){
		String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		
		return currentUserName;
	}
	
	/*Get Details of Current User*/
/*	
	public Map<String,String> getInfoCurrentUser(){
		Map<String, String> currentUser = new HashMap<String,String>();
		currentUser.put("userName", "CTS0101");
		currentUser.put("empCode", "CTS0101");
		currentUser.put("empName", "CTS0101");
		currentUser.put("empEmail", "CTS0101");
		return currentUser;
	}*/

	/*Get Details of Current User*/
	@Override
	public User getCurrentUser() {
		String currentUserName = this.getCurrentUserName();
		User userdetails = this.getByUsername(currentUserName);
		return userdetails;
	}

	/*Get Details according to userName*/
	@Override
    public User getByUsername(String username) throws UsernameNotFoundException {
        Query query = sessionfactory.getCurrentSession().createQuery("FROM User WHERE username = :username");
        query.setParameter("username", username);
        User user = (User) query.uniqueResult();
        if (user == null) {
            throw new UsernameNotFoundException("User with username '" + username + "' does not exist.");
        }
       /* System.out.println(user.getEmpName());*/
        return user;
    }
	
	@Override
	@Transactional
	public User getByUserName(String username) {
		Query query = sessionfactory.getCurrentSession().createQuery("FROM User WHERE username = :username");
		 query.setParameter("username",username);
	     User userDetails = (User) query.uniqueResult();
	     return  userDetails;
	}
	


}
