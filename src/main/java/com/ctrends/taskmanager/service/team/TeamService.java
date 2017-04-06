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
import com.ctrends.taskmanager.model.userstory.UserStory;
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
		
		Map<String, String> data = new HashMap<String, String>();
		User currentUser = userService.getCurrentUser();
		String strid = null;
		UUID id;

		/*************************
		 * Master data sent from view
		 *******************************/

		Map<String, Object> param = new HashMap<String, Object>();

		param.put("teamCode", requestMap.get("team_code")[0].toUpperCase());
		
		Team team = teamDAO.getDocById(UUID.fromString(requestMap.get("id")[0]));
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
		
		List<TeamMemberDetails> teamMemberDetailsList = new ArrayList<TeamMemberDetails>();

		TeamMemberDetails teamDetails = null;
		
		for (int i = 0; i < empCode.length; i++) {
			try {
				//teamDetails = teamDAO.getTeamMemberDetailsByTeamId(empCode[i]);
				teamDetails = teamDAO.getTeamMemberDetailsByEmpCodeAndTeamId(empCode[i], team.getId());
				
				if(teamDetails == null){
					teamDetails = new TeamMemberDetails();
				}
				
				teamDetails.setEmpCode(empCode[i]);
				teamDetails.setTeamCode(requestMap.get("team_code")[0]);
				teamDetails.setTeamId(team.getId());
				teamDetails.setEmpCode(empCode[i]);
				teamDetails.setEmpName(empName[i]);
				teamDetails.setUsername(username[i]);
				teamDetails.setCreatedByCode(currentUser.getCreatedByCode());
				teamDetails.setCreatedByName(currentUser.getCreatedByName());
				teamDetails.setCreatedByUsername(currentUser.getCreatedByUsername());
				teamDetails.setCreatedByCode(currentUser.getEmpCode());
				teamDetails.setCreatedByName(currentUser.getEmpName());
				teamDetails.setCreatedByUsername(currentUser.getUsername());
				teamDetails.setCreatedByEmail(currentUser.getEmail());
				teamDetails.setCreatedByCompanyCode(currentUser.getCompanyCode());
				teamDetails.setCreatedByCompanyName(currentUser.getCompanyName());
				teamDetails.setCreatedAt(new Timestamp(System.currentTimeMillis()));				
				teamDetails.setClientName(currentUser.getClientName());
				teamDetails.setCompanyCode(currentUser.getCompanyCode());				
				teamDetails.setUpdatedByCode(currentUser.getEmpCode());
				teamDetails.setUpdatedByName(currentUser.getEmpName());
				teamDetails.setUpdatedByUsername(currentUser.getUsername());
				teamDetails.setUpdatedByEmail(currentUser.getEmail());
				teamDetails.setUpdatedByCompanyCode(currentUser.getCompanyCode());
				teamDetails.setUpdatedByCompanyName(currentUser.getCompanyName());
				
				teamMemberDetailsList.add(i, teamDetails);
			} catch (Exception e) {
				System.err.println("Exception Throw 123456789987654" + e);
			}


		}
		team.setTeamDetails(teamMemberDetailsList);
		id = teamDAO.updateDoc(team);
		
		if(id!=null){
			data.put("id", id.toString());

		}
		
		return data;

	}

	

	@Override
	public UUID delete(Map<String, String[]> requestMap) {
		UUID id = teamDAO.deleteDoc(UUID.fromString(requestMap.get("teamId")[0]));
		return id;
	}

	@Override
	public List<TeamMemberDetails> getTeamMemberDetailsByTeamId(UUID teamId) {
		System.out.println(":::::::::::::---"+teamId.toString());
		return teamDAO.getTeamMemberDetailsByTeamId(teamId);
	}
	
	@Override
	public List<TeamMemberDetails> getByTeamCode(String teamCode) {
		return teamDAO.getDocByIdTeamCode(teamCode);
	}
	
	@Override
	public List<Team> find(Map<String, String> searchingKey) {
		return teamDAO.getDocs(searchingKey);
	}
	

}
