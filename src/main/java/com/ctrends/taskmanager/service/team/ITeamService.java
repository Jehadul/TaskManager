package com.ctrends.taskmanager.service.team;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.ctrends.taskmanager.model.team.Team;
import com.ctrends.taskmanager.model.team.TeamMemberDetails;
import com.ctrends.taskmanager.service.ICommonService;

public interface ITeamService extends ICommonService<Team> {

	List<TeamMemberDetails> getByTeamCode(String teamCode);
	public List<TeamMemberDetails> getTeamMemberDetailsByTeamId(UUID teamId);
	List<Team> find(Map<String, String> searchingKey);

}
