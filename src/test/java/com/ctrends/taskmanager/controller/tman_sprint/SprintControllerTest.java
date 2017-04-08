package com.ctrends.taskmanager.controller.tman_sprint;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import javax.swing.text.View;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.ctrends.taskmanager.bean.WSResponse;
import com.ctrends.taskmanager.dao.tman_sprint.ISprintDAO;
import com.ctrends.taskmanager.service.tman_sprint.ISprintService;

import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-database.xml", "/spring-dispatcher-servlet.xml", "/spring-security.xml" })
@WebAppConfiguration
public class SprintControllerTest {


	@Autowired
	ISprintController sprintController;

	@Autowired
	ISprintDAO sprintDao;
	
	@Autowired
	ISprintService sprintService;

	
	@Autowired
    protected WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
	
	
	UUID id = UUID.fromString("3c4617ee-d3c7-4c94-bc84-f2333a6cc057");

	MockHttpServletRequest request;
	

	String[] suiteName = { "Human Resource" };
	String[] moduleName = { "Employee Database" };
	String[] privGrpName = { "Data Entry and Processing" };
	String[] sprintCode = { "TESTCODE" };
	String[] sprintName = { "TestSprintName" };
	String[] sprintGoal = { "TestSprintGoal" };
	String[] sprintNumber = { "1254" };
	String[] sprintStories = { "TestSprintStories" };
	String[] startDate = { "" };
	String[] endDate = { "" };
	String[] sprintDescription = { "TestSprintDescription" };

	public SprintControllerTest() {
		request = new MockHttpServletRequest();
	}

	

	@Test
	public void testEdit_ReturnModelAndView() {
		ModelAndView ar = sprintController.edit(id);
		assertTrue(ar.hasView());
	}

	@Test
	@WithMockUser("CTS0001")
	public void testUpdate_ReturnWsResponse() {
		request.setParameter("id", String.valueOf(id));
		request.setParameter("sprint_code", "xvbhxf");
		request.setParameter("sprint_name", "xvbhxf");
		request.setParameter("team_code", "xvbhxf");
		request.setParameter("team_name", "xvbhxf");
		request.setParameter("sprint_goal", "xvbhxf");
		request.setParameter("sprint_number", String.valueOf(1));
		request.setParameter("sprint_stories", "xvbhxf");
		request.setParameter("sprint_description", "xvbhxf");
		request.setParameter("start_date", startDate);
		request.setParameter("end_date", endDate);
		WSResponse ar = sprintController.update(request);
		assertTrue(ar.getClass() == WSResponse.class);
	}

	@Test
	public void testShow_ReturnModelAndView() {
		ModelAndView ar = sprintController.show(id);
		assertTrue(ar.hasView());
	}

	@Test
	public void testStore_ReturnWsResponse() {
		Map<String, String[]> requestMap = new HashMap<String, String[]>();

		requestMap.put("suite_name", suiteName);
		requestMap.put("module_name", suiteName);
		requestMap.put("priv_grp_name", suiteName);
		requestMap.put("sprint_code", sprintCode);
		requestMap.put("sprint_name", sprintName);
		requestMap.put("sprint_goal", sprintGoal);
		requestMap.put("sprint_stories", sprintStories);
		requestMap.put("sprint_number", sprintNumber);
		requestMap.put("start_date", startDate);
		requestMap.put("end_date", endDate);
		requestMap.put("sprint_description", sprintDescription);

		request.addParameters(requestMap);

		WSResponse ar = sprintController.store(request);
		assertTrue(ar.getClass() == WSResponse.class);
	}

	@Test
	public void testDelete_ReturnsModelAndView() {
		ModelAndView ar = sprintController.delete();
		assertTrue(ar.hasView());
	}

	@Test
	public void testDestroy_ReturnsWSResponse() {
		UUID id = UUID.fromString("5635a524-0e95-4bb7-8967-02fa2ec0f5ab");
		request.setParameter("id", String.valueOf(id));
		request.setParameter("suite_code", "ertert");
		request.setParameter("suite_name", "trtryry");
		request.setParameter("module_code", "ED");
		request.setParameter("module_name", "Employee Database");
		request.setParameter("priv_grp_code", String.valueOf(1));
		request.setParameter("priv_grp_name", "trtryry");
		request.setParameter("sprint_code", "xvbhxf");
		request.setParameter("sprint_name", "xvbhxf");
		request.setParameter("sprint_goal", "xvbhxf");
		request.setParameter("sprint_number", String.valueOf(1));
		request.setParameter("sprint_stories", "xvbhxf");
		request.setParameter("sprint_description", "xvbhxf");
		request.setParameter("start_date", startDate);
		request.setParameter("end_date", endDate);

		WSResponse ar = sprintController.destroy(request);
		assertTrue(ar.getClass() == WSResponse.class);
	}

	@Test
	public void testshowBurnDownChartData_returnModelAndView() throws Exception {
		this.mockMvc.perform(get("/taskman/tman/sprint/burndownchart/" + id))
				.andExpect(status().isOk())
				.andExpect(view().name("sprintmanager/burndownchart"));
	}
	
	@Test
	public void testshowSpentChart_returnModelAndView() throws Exception {
		this.mockMvc.perform(get("/taskman/tman/sprint/spentchart/" + id))
				.andExpect(status().isOk())
				.andExpect(view().name("sprintmanager/spentchart"));
	}
	

}