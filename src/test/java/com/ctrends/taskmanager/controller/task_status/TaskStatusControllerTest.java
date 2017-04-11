package com.ctrends.taskmanager.controller.task_status;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.ctrends.taskmanager.bean.WSResponse;
import com.ctrends.taskmanager.controller.tman.TasksController;
import com.ctrends.taskmanager.dao.tman.ITasksDao;
import com.ctrends.taskmanager.dao.userstory.IUserStoryDAO;
import com.ctrends.taskmanager.model.tman.Tasks;
import com.ctrends.taskmanager.model.userstory.UserStory;
import com.ctrends.taskmanager.service.tman.ITasksService;
import com.ctrends.taskmanager.service.userstory.IUserStoryService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import static org.junit.Assert.*;
   
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-database.xml", 
									"/spring-dispatcher-servlet.xml", 
									"/spring-security.xml" })
public class TaskStatusControllerTest {
	
	@Mock
	private MockMvc mockMvc;
	
	@Autowired
	TaskStatusController taskStatusController;
	
	MockHttpServletRequest request;

	String sprintCode = "1";
	
	public TaskStatusControllerTest(){
		request = new MockHttpServletRequest();
	}
	
	
	@Test
	public void testCreateTaskStatus_ReturnsModelAndView(){
		
		ModelAndView ar = taskStatusController.create(request);
		assertTrue(ar.hasView());
	}

	
	
	@Test
	public void loaddetaskTest() {
		request.setParameter("sprintCode", sprintCode);
		String sprintManagerDetail=taskStatusController.loaddetask(request);
		assertNotNull(sprintManagerDetail);
		
	
	}
	
	/*@Test 
	public void taskStatus_ReturnString(){ 
		UUID id=UUID.fromString("116d72b4-e224-401c-9b59-b04cd2e5e9f7");
		String status= "To Do";
		request.setParameter("id", String.valueOf(id));
		request.setParameter("story_status", "To Do");
		
		String taskStatusUpdate=taskStatusController.taskStatus(id, status);
		assertNotNull(taskStatusUpdate);
	} */

	
}