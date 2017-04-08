package com.ctrends.taskmanager.service.team;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ctrends.taskmanager.bean.WSResponse;
import com.ctrends.taskmanager.controller.team.TeamController;
import com.ctrends.taskmanager.dao.team.ITeamDAO;
import com.ctrends.taskmanager.model.team.Team;
import com.ctrends.taskmanager.model.team.TeamDetails;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = { "/spring-database.xml", "/spring-dispatcher-servlet.xml", "/spring-security.xml" })
public class TeamServiceTest {

	@Autowired
	ITeamService teamService;
	
	@Autowired
	TeamController teamController; 
	
	@Mock
	ITeamDAO teamDAO;
	
	String[] st ={"abc"};
	String[] stn ={String.valueOf(1)};
	String teamCode= "aaa";

	@Test
	public void testGetById_ReturnsTeam() {
		UUID id=UUID.fromString("92a0f9ad-d789-48ce-9030-2c6e3fbb8088");
		Team team=teamService.getById(id);
		assertNotNull(team);
	}
	
	@Test
	public void testGetTeamMemberDetailsByTeamId_ReturnList(){
		UUID teamId=UUID.fromString("d813830a-d80d-4963-8b14-b86903aceb8c");
		List<TeamDetails> list = teamService.getTeamMemberDetailsByTeamId(teamId);
		assertFalse(list.isEmpty());
	}
	
	@Test
	@WithMockUser("CTS0104")
	public void testInsert_ReturnMap() {
		Map<String, String[]> requestMap=new HashMap<String, String[]>();
		requestMap.put("team_code", st);
		requestMap.put("team_name", st);
		requestMap.put("nt_member", stn);
		requestMap.put("description", st);
		requestMap.put("emp_code[]", st);
		requestMap.put("emp_name[]", st);
		requestMap.put("emp_username[]", st);
		Map<String, String> map2=new HashMap<>();
		Map<String, String> ar = teamService.insert(requestMap);
		assertEquals(map2.getClass(), ar.getClass());
	}
	
	@Test
	@WithMockUser("CTS0104")
	public void testGetAll_ReturnsTeamList() {
		List<Team> team =teamService.getAll();
		assertEquals(new ArrayList<>().getClass(), team.getClass());
	}
	
	@Test
	public void testGetByTeamCode_ReturnsTeamMemberDetailsList() {
		List<TeamDetails> teamMemberDetails =teamService.getByTeamCode(teamCode);
		assertNotNull(teamMemberDetails);
	}
	
	@Test
	@WithMockUser("CTS0104")
	public void testFind_ReturnTeamList() {
		Map<String, String> requestMap=new HashMap<String, String>();
		requestMap.put("team_code", teamCode);
		requestMap.put("team_name", teamCode);
		List<Team>  teamLi = teamService.find(requestMap);
		assertNotNull(teamLi);
	}
	
	@Test
	public void testDelete_ReturnUUID(){
		
		Map<String, String[]> requestMap=new HashMap<String, String[]>();
		UUID id=UUID.fromString("1d0bb166-4722-4e64-9aa0-0649e58f6a64");
		String[] idArray={String.valueOf(id)};
		requestMap.put("teamId", idArray);
		
		UUID uid= teamService.delete(requestMap);
		assertEquals(id.getClass(), uid.getClass());
	}
	
	@Test
	@WithMockUser("CTS0104")
	public void testUpdate_ReturnMap(){
		Map<String, String[]> requestMap=new HashMap<String, String[]>();
		UUID id=UUID.fromString("fa24e9f7-e6c6-48c8-9594-ea0f4fd6de8d");
		String[] idArray={String.valueOf(id)};
		requestMap.put("teamId", idArray);
		
		String [] teamId={"1d0bb166-4722-4e64-9aa0-0649e58f6a64"};
		String [] teamCode={"123"};
		String [] teamName={"1234"};
		String [] description={"123456"};
		String [] empCode={"123456"};
		String [] empName={"123456"};
		String [] username={"123456"};
		String [] ntMember={"123456"};
	
		requestMap.put("id", teamId);
		requestMap.put("team_code", teamCode);
		requestMap.put("team_name", teamName);
		requestMap.put("nt_member", ntMember);
		requestMap.put("description", description);
		requestMap.put("emp_code[]", empCode);
		requestMap.put("emp_name[]", empName);
		requestMap.put("emp_username[]", username);
		
		Map<String, String> map= teamService.update(requestMap);
		Map<String, String> map2=new HashMap<>();
		assertEquals(map2.getClass(), map.getClass());
	}
}
