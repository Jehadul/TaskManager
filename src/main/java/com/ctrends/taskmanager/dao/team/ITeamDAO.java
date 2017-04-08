package com.ctrends.taskmanager.dao.team;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.ctrends.taskmanager.dao.ICommonDAO;
import com.ctrends.taskmanager.model.team.Team;
import com.ctrends.taskmanager.model.team.TeamDetails;

public interface ITeamDAO extends ICommonDAO<Team> {

	boolean checkUnique(Map<String, Object> param);
	public List<TeamDetails> getTeamMemberDetailsByTeamId(UUID teamId);

	List<TeamDetails> getDocByIdTeamCode(String teamCode);
	TeamDetails getTeamMemberDetailsByTeamId(String empCode);
	UUID deleteDocTeamDetailsById(UUID id);
	TeamDetails getTeamMemberDetailsByEmpCodeAndTeamId(String empCode, UUID teamId);

}
