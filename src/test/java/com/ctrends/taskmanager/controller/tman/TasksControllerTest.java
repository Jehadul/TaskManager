package com.ctrends.taskmanager.controller.tman;

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
import com.ctrends.taskmanager.model.tman.Tasks;

import com.ctrends.taskmanager.service.tman.ITasksService;

import static org.junit.Assert.*;
   
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-database.xml", 
									"/spring-dispatcher-servlet.xml", 
									"/spring-security.xml" })
public class TasksControllerTest {
	
	@Mock
	private MockMvc mockMvc;
	
	@Autowired
	TasksController tasksController;
	
	Tasks mockTasks;

	@Autowired
	ITasksDao taskDao;

	/*@Autowired
	private ITasksService tasksService;*/
	@Mock
	private ITasksService tasksService;

	@Autowired
	ITasksDao tasksDao;
	
	UUID id=UUID.fromString("81d5a03e-62f6-4857-bb97-116c5aa23018");
	
	MockHttpServletRequest request;

	String st="sssssssss";
	
	public TasksControllerTest(){
		request = new MockHttpServletRequest();
	}


	@Test
	public void testIndex_ReturnsModelAndView() throws Exception {
		ModelAndView mav = tasksController.index();
		assertTrue(mav.hasView());
	}

	@Test 
	public void testEdit_ReturnModelAndView(){ 
		ModelAndView ar = tasksController.edit(id);
		assertTrue(ar.hasView());
	}
	
	@Test 
	public void testShow_ReturnModelAndView(){ 
		ModelAndView ar = tasksController.show(id);
		assertTrue(ar.hasView());
	}
	
	@Test 
	@WithMockUser("CTS0104")
	public void testStore_ReturnWsResponse(){ 
		request.addParameter("suite_code", "HRM");
		request.addParameter("suite_name", "Human Resources");
		request.addParameter("module_code", "ED");
		request.addParameter("module_name", "Employee Database");
		request.addParameter("priv_grp_code", String.valueOf(1));
		request.addParameter("priv_grp_name", "Reporting and Analysis");
		request.addParameter("description", "xvbhxf");
		request.addParameter("story_code", "xvbhxf");
		request.addParameter("task_title", "xvbhxf");
		request.addParameter("estimated_time", String.valueOf(1));
		request.addParameter("assignee", "xvbhxf");
		WSResponse ar = tasksController.store(request);
		assertTrue(ar.getClass()==WSResponse.class);
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
		request.setParameter("story_code", "xvbhxf");
		request.setParameter("task_title", "xvbhxf");
		request.setParameter("estimated_time", String.valueOf(1));
		request.setParameter("assignee", "xvbhxf");
		WSResponse ar = tasksController.update(request);
		assertTrue(ar.getClass()==WSResponse.class);
	}
	
/*	@Test 
	public void testUpdateTasklist_ReturnWsResponse(){ 
		request.setParameter("id", String.valueOf(id));
		request.setParameter("task_title", "ertert");
		request.setParameter("estimated_time", "trtryry");
		request.setParameter("spent_time", "ED");
		request.setParameter("remaining_time", "Employee Database");
		request.setParameter("assignee", "wewrwe");
		
		
		WSResponse ar = tasksController.updateTasklist(request);
		assertTrue(ar.getClass()==WSResponse.class);
	}*/
	
	@Test 
	public void testDelete_ReturnModelAndView(){
		ModelAndView ar = tasksController.delete();
		assertTrue(ar.hasView());
	}
	
	@Test 
	@WithMockUser("CTS0104")
	public void testDestroy_ReturnsWSResponse(){
		request.setParameter("id", String.valueOf(id));
		request.setParameter("suite_code", "ertert");
		request.setParameter("suite_name", "trtryry");
		request.setParameter("module_code", "ED");
		request.setParameter("module_name", "Employee Database");
		request.setParameter("priv_grp_code", String.valueOf(1));
		request.setParameter("priv_grp_name", "Reporting and Analysis");
		request.setParameter("description", "xvbhxf");
		request.setParameter("story_code", "xvbhxf");
		request.setParameter("task_title", "xvbhxf");
		request.setParameter("estimated_time", String.valueOf(1));
		request.setParameter("assignee", "xvbhxf");
		WSResponse ar = tasksController.destroy(request); 
		assertTrue(ar.getClass()==WSResponse.class);
	}
	
	
	
	/*@Test
	public void testEditTaskList_ReturnsModelAndView(){
		ModelAndView ar = tasksController.editTasklist(id);
		assertTrue(ar.hasView());
	}*/
	
	@Test
	@WithMockUser("CTS0104")
	public void testTimeLog_ReturnsModelAndView(){
		ModelAndView ar = tasksController.timeLog(id, st, st, st);
		assertTrue(ar.hasView());
	}

	
	
}