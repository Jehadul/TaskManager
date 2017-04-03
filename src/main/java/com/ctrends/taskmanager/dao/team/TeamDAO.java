package com.ctrends.taskmanager.dao.team;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ctrends.taskmanager.dao.user.IUserDAO;
import com.ctrends.taskmanager.model.team.Team;
import com.ctrends.taskmanager.model.tman.Tasks;
import com.ctrends.taskmanager.model.user.User;
import com.ctrends.taskmanager.service.user.IUserService;

@Repository("teamDao")
public class TeamDAO implements ITeamDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	IUserDAO userDAO;

	@Autowired
	IUserService userService;
	
	@Transactional
	@Override
	public List<Team> getAllDoc() {
		User currentUser = userService.getCurrentUser();
		Query query = sessionFactory.getCurrentSession().createQuery("From Team where createdByUsername =:userName");
		query.setParameter("userName", currentUser.getUsername());
		List<Team> teamLi = query.list();
		return teamLi;
	}

	@Override
	public Team getDocById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Team> getDocs(Map<String, String> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UUID insertDoc(Team doc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UUID updateDoc(Team doc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UUID deleteDoc(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
