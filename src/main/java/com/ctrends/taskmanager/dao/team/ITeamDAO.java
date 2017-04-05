package com.ctrends.taskmanager.dao.team;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.ctrends.taskmanager.dao.ICommonDAO;
import com.ctrends.taskmanager.model.team.Team;
import com.ctrends.taskmanager.model.team.TeamMemberDetails;

public interface ITeamDAO extends ICommonDAO<Team> {

	boolean checkUnique(Map<String, Object> param);
	public List<TeamMemberDetails> getTeamMemberDetailsByTeamId(UUID teamId);

	List<TeamMemberDetails> getDocByIdTeamCode(String teamCode);
	TeamMemberDetails getTeamMemberDetailsByTeamId(String empCode);

}
