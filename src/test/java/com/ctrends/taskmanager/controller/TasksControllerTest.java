package com.ctrends.taskmanager.controller;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.ModelAndView;

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

	@Autowired
	ITasksDao taskDao;

	@Autowired
	private ITasksService tasksService;

	@Autowired
	ITasksDao tasksDao;
	
	UUID id=UUID.fromString("0a2aace0-0243-47dd-8c3c-bdb5aeaf233f");
	
	MockHttpServletRequest request;
	
	public TasksControllerTest(){
		request = new MockHttpServletRequest();
	}

	@Test
	public void testCreate() throws Exception {
		request.addParameter("id", "farid");
		String ar = tasksController.requestValueCheck(request);
		assertEquals("farid", ar);
	}

	@Test
	public void testIndex_ReturnsModelAndView() throws Exception {
		ModelAndView mav = tasksController.index();
		assertTrue(mav.hasView());
	}

	
	@Test
	public void testGetAll_ReturnAllTasks() {
		List<Tasks> tasksList = tasksService.getAll();
		assertNotNull(tasksList);
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
	
/*	@Test 
	public void testStore(){ 
		request.addParameter("suite_code", "HRM");
		request.addParameter("suite_name", "Human Resources");
		request.addParameter("module_code", "");
		WSResponse ar = tasksController.store(request);
		Map<String, String[]> map=request.getParameterMap(); 
		Map<String, String> data = tasksService.insert(map);
		WSResponse response=new WSResponse("success", "Submitted Successfully", UUID.fromString(data.get("id")), null, data.get("mode"), data);
		assertEquals("success", ar.getMessage());
	}*/
	
	@Test 
	public void testDelete_ReturnModelAndView(){
		ModelAndView ar = tasksController.delete();
		assertTrue(ar.hasView());
	}

	
	
}