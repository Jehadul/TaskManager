package com.ctrends.taskmanager.controller.team;

import static org.junit.Assert.*;

import java.util.List;
import java.util.UUID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ModelAndView;

import com.ctrends.taskmanager.bean.WSResponse;
import com.ctrends.taskmanager.dao.team.ITeamDAO;
import com.ctrends.taskmanager.model.team.TeamDetails;
import com.ctrends.taskmanager.service.tman.ITasksService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-database.xml", "/spring-dispatcher-servlet.xml", "/spring-security.xml" })
public class TeamControllerTest {

	private MockMvc mockMvc;
	
//	@InjectMocks
//	TeamController teamController;
	
	@Autowired
	TeamController teamController;
	
	@Autowired
	ITeamDAO teamDAO;
	
	@Mock
	private ITasksService taskService;
	
	MockHttpServletRequest request;

	String st = "sssssssss";
	String[] stA={st, st, st};
	
	List<TeamDetails> teamMemberDetails;

	public TeamControllerTest() {
		request = new MockHttpServletRequest();
	}
	
	
	@Before
	public void setUp() throws Exception {
		
		// Process mock annotations
		MockitoAnnotations.initMocks(this);

		// Setup Spring test in standalone mode
		this.mockMvc = MockMvcBuilders.standaloneSetup(teamController).build();
	}
	

	@Test
	public void testCreate_ReturnModelAndView() {
		ModelAndView mav = teamController.create(request);
		assertTrue(mav.hasView());
	}
	
	@Test
	public void testShow_ReturnsModelAndView() {
		UUID id = UUID.fromString("2d7e2500-0473-49e0-9deb-fc66e02f2fdd");
		ModelAndView mv = teamController.show(id);
		assertTrue(mv.hasView());
	}
	
	@Test
	@WithMockUser("CTS0104")
	public void testStore_ReturnWsResponse() {
		TeamDetails teamMembers =new TeamDetails();
		request.addParameter("team_code", st);
		request.addParameter("team_name", st);
		request.addParameter("nt_member", String.valueOf(1));
		request.addParameter("description", st);
		request.addParameter("emp_code[]", stA);
		request.addParameter("emp_name[]", stA);
		request.addParameter("emp_username[]", stA);
		
		WSResponse ar = teamController.store(request);
		assertTrue(ar.getClass() == WSResponse.class);
	}
	
	@Test
	@WithMockUser("CTS0104")
	public void testIndex_ReturnModelAndView() {
		ModelAndView mav = teamController.index();
		assertTrue(mav.hasView());
	}
	
	@Test
	public void testShowSearch_ReturnsModelAndView() {
		ModelAndView mav = teamController.showSearch(request);
		assertTrue(mav.hasView());
	}

	@Test
	public void testSearch_ReturnsModelAndView() {
		String mav = teamController.search(request);
		assertTrue(st.getClass() == mav.getClass());
	}
	
	@Test 
	public void testEdit_ReturnModelAndView(){
		UUID id=UUID.fromString("b2ac5e7c-41c7-4793-8bd0-a377b0a54297");
		ModelAndView mv=teamController.edit(id);
		assertTrue(mv.hasView());
	}
	
	@Test
	public void testDelete_ReturnWSResponse(){
		
		String[] teamId = {"b2ac5e7c-41c7-4793-8bd0-a377b0a54297"};
		request.addParameter("teamId", teamId);
		
		WSResponse mv=teamController.destroy(request);
		assertTrue(mv.getClass() == WSResponse.class);
	}
	
	@Test
	@WithMockUser("CTS0104")
	public void testUpdate_ReturnWSResponse(){
		
		String [] teamId={"1d0bb166-4722-4e64-9aa0-0649e58f6a64"};
		String [] teamCode={"123"};
		String [] teamName={"1234"};
		String [] description={"123456"};
		String [] empCode={"123456"};
		String [] empName={"123456"};
		String [] username={"123456"};
	
		request.setParameter("id", teamId);
		request.setParameter("team_code", teamCode);
		request.setParameter("team_name", teamName);
		request.setParameter("nt_member", String.valueOf(1));
		request.setParameter("description", description);
		request.setParameter("emp_code[]", empCode);
		request.setParameter("emp_name[]", empName);
		request.setParameter("emp_username[]", username);
		
		WSResponse wr=teamController.update(request);
		assertTrue(wr.getClass()==WSResponse.class);
		
	}

}
