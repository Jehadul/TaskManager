package com.ctrends.taskmanager.service.team;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctrends.taskmanager.dao.team.ITeamDAO;
import com.ctrends.taskmanager.dao.userstory.IUserStoryDAO;
import com.ctrends.taskmanager.model.team.Team;
import com.ctrends.taskmanager.model.userstory.UserStory;
import com.ctrends.taskmanager.service.user.IUserService;

@Service("teamService")
public class TeamService implements ITeamService {
	
	@Autowired
	ITeamDAO teamDAo;
	
	@Autowired
	IUserService userService;

	@Override
	public Map<String, String> insert(Map<String, String[]> requestMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Team> getAll() {
		 List<Team> teamLi=teamDAo.getAllDoc();
			return teamLi;
	}

	@Override
	public Team getById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> update(Map<String, String[]> requestMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UUID delete(Map<String, String[]> requestMap) {
		// TODO Auto-generated method stub
		return null;
	}

}
