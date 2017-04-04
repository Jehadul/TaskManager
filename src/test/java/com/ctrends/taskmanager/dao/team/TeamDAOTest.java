package com.ctrends.taskmanager.dao.team;

import static org.junit.Assert.*;

import java.util.List;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ctrends.taskmanager.model.team.Team;
import com.ctrends.taskmanager.model.team.TeamMemberDetails;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = { "/spring-database.xml", 
									"/spring-dispatcher-servlet.xml", 
									"/spring-security.xml" })

public class TeamDAOTest {

	@Autowired
	ITeamDAO teamDAO;
	
	
	
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
		List<TeamMemberDetails> list = teamDAO.getTeamMemberDetailsByTeamId(teamId);
		assertFalse(list.isEmpty());
	}
}
