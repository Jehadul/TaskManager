package com.ctrends.taskmanager.dao.team;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ctrends.taskmanager.model.team.Team;
import com.ctrends.taskmanager.model.team.TeamDetails;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = { "/spring-database.xml", 
									"/spring-dispatcher-servlet.xml", 
									"/spring-security.xml" })

public class TeamDAOTest {

	@Autowired
	ITeamDAO teamDAO;
	
	@Autowired
	private SessionFactory sessionfactory;
	
	String teamCode= "aaa";
	String teamName= "aaa";
	
	@Mock
	private List<Team> mockTeamList;
	
	@Mock
	private List<TeamDetails> teamMemberDetailsList;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	
	@Test
	public void testGetDocById_ReturnTeam() {
		UUID id=UUID.fromString("92a0f9ad-d789-48ce-9030-2c6e3fbb8088");
		Team team=teamDAO.getDocById(id);
		assertNotNull(team);
	}
	
	@Test
	public void testGetTeamMemberDetailsByTeamId_ReturnList(){
		UUID teamId=UUID.fromString("d813830a-d80d-4963-8b14-b86903aceb8c");
		List<TeamDetails> list = teamDAO.getTeamMemberDetailsByTeamId(teamId);
		assertFalse(list.isEmpty());
	}
	
	@Test
	public void testGetDocs_ReturnList(){
		Map<String, String> params = new HashMap<String, String>();
		params.put("teamCode", teamCode);
		params.put("teamName", teamName);
		List<Team> list = teamDAO.getDocs(params);
		assertFalse(list.isEmpty());
	}
	
	@Test
	@WithMockUser("CTS0001")
	public void testGetAllDoc_ReturnList(){
		List<Team> list = teamDAO.getAllDoc();
		assertFalse(list.isEmpty());
	}
	
	@Test
	public void testInsertDoc_ReturnUUID(){
		UUID teamId=UUID.fromString("d813830a-d80d-4963-8b14-b86903aceb8c");
		Team team = new Team();
//		TeamMemberDetails teamMemberDetails = new TeamMemberDetails();
//		teamMemberDetailsList.add(teamMemberDetails);
		teamMemberDetailsList=new ArrayList<TeamDetails>();
		for(int i=0; i<team.getTeamDetails().size(); i++){
			TeamDetails teamMemberDetails = new TeamDetails();
			teamMemberDetails=(TeamDetails) team.getTeamDetails().get(0);
			teamMemberDetails.setMasterId(teamId);
			teamMemberDetailsList.add(teamMemberDetails);
		}
		team.setTeamDetails(teamMemberDetailsList);
		UUID id = teamDAO.insertDoc(team);
		assertEquals(teamId.getClass(), id.getClass());
	}
	
	@Test
	@WithMockUser("CTS0001")
	public void testCheckUnique_ReturnBoolean(){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("teamCode", teamCode);
		params.put("companyCode", teamName);
		boolean tr = teamDAO.checkUnique(params);
		assertFalse(tr);
	}
	
	@Test
	public void testDelete_ReturnUUID(){
		UUID uid=UUID.fromString("fa24e9f7-e6c6-48c8-9594-ea0f4fd6de8d");
		UUID id=teamDAO.deleteDoc(uid);
		assertEquals(id.getClass(), uid.getClass());
	}
	
	@Test
	public void testDeleteDocTeamDetailsById_ReturnUUID(){
		UUID uid=UUID.fromString("9191999b-632e-43c0-a939-50bb7097713d");
		UUID id=teamDAO.deleteDocTeamDetailsById(uid);
		assertEquals(id.getClass(), uid.getClass());
	}
	
	@Test
	public void testGetTeamMemberDetailsByEmpCodeAndTeamId_ReturnList(){
				
		UUID id=UUID.fromString("9d9c2c22-5960-45c6-85a7-708f7e759f46");
		String st="0001";
		TeamDetails teamMemberDetails=teamDAO.getTeamMemberDetailsByEmpCodeAndTeamId(st,id);
		assertNotNull(teamMemberDetails);
	}
	
	@Test
	public void testUpdateDoc_ReturnUUID(){
		
	}
}
