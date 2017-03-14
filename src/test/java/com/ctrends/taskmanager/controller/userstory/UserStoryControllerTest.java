package com.ctrends.taskmanager.controller.userstory;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.ctrends.taskmanager.bean.WSResponse;
import com.ctrends.taskmanager.controller.tman.TasksController;
import com.ctrends.taskmanager.dao.tman.ITasksDao;
import com.ctrends.taskmanager.dao.userstory.IUserStoryDAO;
import com.ctrends.taskmanager.model.tman.Tasks;
import com.ctrends.taskmanager.model.userstory.UserStory;
import com.ctrends.taskmanager.service.tman.ITasksService;
import com.ctrends.taskmanager.service.userstory.IUserStoryService;

import static org.junit.Assert.*;
   
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-database.xml", 
									"/spring-dispatcher-servlet.xml", 
									"/spring-security.xml" })
public class UserStoryControllerTest {
	
	@Mock
	private MockMvc mockMvc;
	
	@Autowired
	UserStoryController userStoryController;
	
	UserStory mockUserStory;

	@Autowired
	IUserStoryDAO userStoryDAO;

	/*@Autowired
	private ITasksService tasksService;*/
	@Mock
	private IUserStoryService userStoryService;
	
	UUID id=UUID.fromString("1e1b39e2-406b-4338-a360-3c1bae2d3f1e");
	
	MockHttpServletRequest request;

	
	
	public UserStoryControllerTest(){
		request = new MockHttpServletRequest();
	}


	@Test
	public void testCreate_ReturnsModelAndView(){
		ModelAndView ar = userStoryController.create(request);
		assertTrue(ar.hasView());
	}
	
	@Test
	@WithMockUser("CTS0104")
	public void testStore_ReturnsWSResponse(){
		request.setParameter("suite_code", "ertert");
		request.setParameter("suite_name", "trtryry");
		request.setParameter("module_code", "ED");
		request.setParameter("module_name", "Employee Database");
		request.setParameter("priv_grp_code", String.valueOf(1));
		request.setParameter("priv_grp_name", "Reporting and Analysis");
		request.setParameter("description", "xvbhxf");
		request.setParameter("acceptance_criteria", "xvbhxf");
		request.setParameter("business_value", "xvbhxf");
		request.setParameter("user_story_code", "xvbhxf");
		request.setParameter("user_story_title", "xvbhxf");
		request.setParameter("size", String.valueOf(1));
		request.setParameter("priority", "xvbhxf");
		request.setParameter("story_order", "xvbhxf");
		WSResponse ar = userStoryController.store(request);
		assertTrue(ar.getClass()==WSResponse.class);
	}

	@Test 
	public void testEdit_ReturnModelAndView(){ 
		ModelAndView ar = userStoryController.edit(id);
		assertTrue(ar.hasView());
	}
	
	@Test 
	public void testShow_ReturnModelAndView(){ 
		ModelAndView ar = userStoryController.show(id);
		assertTrue(ar.hasView());
	}
	
	
	@Test 
	@WithMockUser("CTS0104")
	public void testUpdate_ReturnWsResponse(){ 
		request.setParameter("id", String.valueOf(id));
		request.setParameter("suite_code", "ertert");
		request.setParameter("suite_name", "trtryry");
		request.setParameter("module_code", "ED");
		request.setParameter("module_name", "Employee Database");
		request.setParameter("priv_grp_code", String.valueOf(1));
		request.setParameter("priv_grp_name", "Reporting and Analysis");
		request.setParameter("description", "xvbhxf");
		request.setParameter("acceptance_criteria", "xvbhxf");
		request.setParameter("business_value", "xvbhxf");
		request.setParameter("user_story_code", "xvbhxf");
		request.setParameter("user_story_title", "xvbhxf");
		request.setParameter("size", String.valueOf(1));
		request.setParameter("priority", "xvbhxf");
		request.setParameter("story_order", "xvbhxf");
		WSResponse ar = userStoryController.update(request);
		assertTrue(ar.getClass()==WSResponse.class);
	}
	
}