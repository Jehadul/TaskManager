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
	

}
