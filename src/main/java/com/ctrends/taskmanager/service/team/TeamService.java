package com.ctrends.taskmanager.service.team;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctrends.taskmanager.dao.team.ITeamDAO;
import com.ctrends.taskmanager.model.team.Team;
import com.ctrends.taskmanager.model.team.TeamMemberDetails;
import com.ctrends.taskmanager.model.tman_sprint.SprintManagerDetails;
import com.ctrends.taskmanager.model.user.User;
import com.ctrends.taskmanager.service.user.IUserService;

@Service("teamService")
public class TeamService implements ITeamService {
	
	@Autowired
	ITeamDAO teamDAO;
	
	@Autowired
	IUserService userService;

	@Override
	public Map<String, String> insert(Map<String, String[]> requestMap) {
		
		Map<String, String> data = new HashMap<String, String>();
		User currentUser = userService.getCurrentUser();
		String strid = null;
		UUID id;

		/*************************
		 * Master data sent from view
		 *******************************/

		Map<String, Object> param = new HashMap<String, Object>();
		System.out.println(requestMap.get("team_code")[0]);
		param.put("teamCode", requestMap.get("team_code")[0]);
		boolean rules = teamDAO.checkUnique(param);

		Team team = new Team();

		team.setTeamCode(requestMap.get("team_code")[0]);
		team.setTeamName(requestMap.get("team_name")[0]);
		team.setTeamSize(Integer.parseInt(requestMap.get("nt_member")[0]));
		team.setDescription(requestMap.get("description")[0]);
		
		
		team.setClientCode(currentUser.getClientCode());
		team.setClientName(currentUser.getClientName());
		team.setCompanyCode(currentUser.getCompanyCode());
		team.setCompanyName(currentUser.getCompanyName());
		team.setCreatedByCode(currentUser.getCreatedByCode());
		team.setCreatedByName(currentUser.getCreatedByName());
		team.setCreatedByCode(currentUser.getEmpCode());
		team.setCreatedByName(currentUser.getEmpName());
		team.setCreatedByUsername(currentUser.getUsername());
		team.setCreatedByEmail(currentUser.getEmail());
		team.setCreatedByCompanyCode(currentUser.getCompanyCode());
		team.setCreatedByCompanyName(currentUser.getCompanyName());
		team.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		
		
		/**********************
		 * Detail item data sent from view
		 *********************************/

		String[] empCode = (String[]) requestMap.get("emp_code[]");

		String[] empName = (String[]) requestMap.get("emp_name[]");
		
		String[] username = (String[]) requestMap.get("emp_username[]");

		System.out.println(empCode + ":::::::::::::::store code::::::::" + empName);

		List<TeamMemberDetails> teamMemberDetailsList = new ArrayList<TeamMemberDetails>();
		for (int i = 0; i < empCode.length; i++) {
			TeamMemberDetails teamMemberDetails= new TeamMemberDetails();

			teamMemberDetails.setTeamCode(requestMap.get("team_code")[0]);
			teamMemberDetails.setTeamName(requestMap.get("team_name")[0]);
			teamMemberDetails.setTeamId(team.getId());
			teamMemberDetails.setTeamSize(Integer.parseInt(requestMap.get("nt_member")[0]));
			teamMemberDetails.setEmpCode(empCode[i]);
			teamMemberDetails.setEmpName(empName[i]);
			teamMemberDetails.setUsername(username[i]);
			teamMemberDetails.setCreatedByCode(currentUser.getCreatedByCode());
			teamMemberDetails.setCreatedByName(currentUser.getCreatedByName());
			teamMemberDetails.setCreatedByUsername(currentUser.getCreatedByUsername());
			teamMemberDetails.setCreatedByCode(currentUser.getEmpCode());
			teamMemberDetails.setCreatedByName(currentUser.getEmpName());
			teamMemberDetails.setCreatedByUsername(currentUser.getUsername());
			teamMemberDetails.setCreatedByEmail(currentUser.getEmail());
			teamMemberDetails.setCreatedByCompanyCode(currentUser.getCompanyCode());
			teamMemberDetails.setCreatedByCompanyName(currentUser.getCompanyName());
			teamMemberDetails.setCreatedAt(new Timestamp(System.currentTimeMillis()));

			teamMemberDetails.setClientName(currentUser.getClientName());
			teamMemberDetails.setCompanyCode(currentUser.getCompanyCode());
			teamMemberDetails.setUpdatedByCode(currentUser.getEmpCode());
			teamMemberDetails.setUpdatedByName(currentUser.getEmpName());
			teamMemberDetails.setUpdatedByUsername(currentUser.getUsername());
			teamMemberDetails.setUpdatedByEmail(currentUser.getEmail());
			teamMemberDetails.setUpdatedByCompanyCode(currentUser.getCompanyCode());
			teamMemberDetails.setUpdatedByCompanyName(currentUser.getCompanyName());
			teamMemberDetailsList.add(i, teamMemberDetails);
		}
		team.setTeamDetails(teamMemberDetailsList);
		System.out.println(rules);
		if (rules) {
			id = teamDAO.insertDoc(team);
			strid = id.toString();
			data.put("id", strid);
		} else {
			data.put("id", null);

		}

		return data;
	}

	@Override
	public List<Team> getAll() {
		 List<Team> teamLi=teamDAO.getAllDoc();
			return teamLi;
	}

	@Override
	public Team getById(UUID id) {
		// TODO Auto-generated method stub
		return teamDAO.getDocById(id);
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

	@Override
	public List<TeamMemberDetails> getTeamMemberDetailsByTeamId(UUID teamId) {
		return teamDAO.getTeamMemberDetailsByTeamId(teamId);
	}
	
	@Override
	public List<TeamMemberDetails> getByTeamCode(String teamCode) {
		// TODO Auto-generated method stub
		return teamDAO.getDocByIdTeamCode(teamCode);
	}
	

}
