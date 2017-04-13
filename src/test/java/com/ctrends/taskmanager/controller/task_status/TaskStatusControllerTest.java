package com.ctrends.taskmanager.controller.task_status;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.web.servlet.ModelAndView;


import java.util.UUID;



import static org.junit.Assert.*;
   
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-database.xml", 
									"/spring-dispatcher-servlet.xml", 
									"/spring-security.xml" })
public class TaskStatusControllerTest {
	
	@Autowired
	TaskStatusController taskStatusController;
	
	MockHttpServletRequest request;

	String sprintCode = "1";
	
	public TaskStatusControllerTest(){
		request = new MockHttpServletRequest();
	}
	
	
	@Test
	public void testCreateTaskStatus_ReturnModelAndView(){
		
		ModelAndView ar = taskStatusController.create(request);
		assertTrue(ar.hasView());
	}

	
	@Test
	public void testLoaddetaskTest_ReturnString() {
		request.setParameter("sprintCode", sprintCode);
		String sprintManagerDetail=taskStatusController.loaddetask(request);
		assertNotNull(sprintManagerDetail);
		
	
	}
	
	@Test 
	public void testTaskStatus_ReturnString(){ 
		UUID id=UUID.fromString("4f222d58-b731-4c45-8848-17c0e0a8b6aa");
		String status= "Done";
		String taskStatusUpdate=taskStatusController.taskStatus(id, status);
		assertNotNull(taskStatusUpdate);
	} 

	
	@Test 
	public void testStoryStatus_ReturnString(){ 
		UUID id=UUID.fromString("116d72b4-e224-401c-9b59-b04cd2e5e9f7");
		String status= "QA";
		String storyStatusUpdate=taskStatusController.storyStatus(id, status);
		assertNotNull(storyStatusUpdate);
	} 
	
	@Test
	public void testSprintTeamView_ReturnModelAndView(){
		request.setParameter("sprint_code", sprintCode);
		ModelAndView sprintTeamView=taskStatusController.sprintTeamView(request);
		assertTrue(sprintTeamView.hasView());
	}
	
}