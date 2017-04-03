package com.ctrends.taskmanager.service.team;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.ctrends.taskmanager.model.team.Team;

public class TeamService implements ITeamService {

	@Override
	public Map<String, String> insert(Map<String, String[]> requestMap) {
		
		Team team = new Team();
		
		team.setTeamCode(requestMap.get("team_code")[0]);
		team.setTeamName(requestMap.get("team_name")[0]);
		team.setTeamDetails(requestMap.get("description")[0]);
		team.setTeamSize();
		
		return null;
	}

	@Override
	public List<Team> getAll() {
		// TODO Auto-generated method stub
		return null;
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
