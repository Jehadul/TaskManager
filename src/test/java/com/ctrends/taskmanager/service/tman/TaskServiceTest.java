package com.ctrends.taskmanager.service.tman;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.bouncycastle.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ctrends.taskmanager.controller.tman.TasksController;
import com.ctrends.taskmanager.dao.tman.ITasksDao;
import com.ctrends.taskmanager.model.tman.Tasks;
import com.ctrends.taskmanager.service.tman.ITasksService;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = { "/spring-database.xml", 
									"/spring-dispatcher-servlet.xml", 
									"/spring-security.xml" })


public class TaskServiceTest {
	
	@Mock
	private MockMvc mockMvc;
	
	UUID id=UUID.fromString("0aad717d-e0f7-44c8-ab72-2f9a6b1b57f3");

	@Autowired
	TasksController tasksController;
	
	Tasks mockTasks;

	@Mock
	private ITasksDao taskDao;

	/*@Autowired
	private ITasksService tasksService;*/
	//@Mock
	@Autowired
	private ITasksService tasksService;

	@Autowired
	ITasksDao tasksDao;
	
	MockHttpServletRequest request;
	
	public TaskServiceTest() {
		request = new MockHttpServletRequest();
	}
	
	String[] suiteCode = {"HRM"};
	String[] suiteName ={"Human Resource"};
	String[] moduleCode = {"ED"};
	String[] moduleName = {"Employee Database"};
	String[] privGrpCode = {"1"};
	String[] privGrpName = {"Data Entry and Processing"};
	String[] description = {"sdfsdfgdfg"};
	String[] storyCode = {"sdfsdfgdfg"};
	String[] taskTitle = {"sdfsdfgdfg"};
	String[] estimatedTime = {"sdfsdfgdfg"};
	String[] assignee = {"sdfsdfgdfg"};
	String [] id1 = {String.valueOf(id)};
	
	@Test
	public void testInsert_ReturnMap(){
		
		Map<String, String[]> requestMap=new HashMap<String, String[]>();
		requestMap.put("suite_code", suiteCode);
		requestMap.put("suite_name", suiteName);
		requestMap.put("module_code", moduleCode);
		requestMap.put("module_name", moduleName);
		requestMap.put("priv_grp_code", privGrpCode);
		requestMap.put("priv_grp_name", privGrpName);
		requestMap.put("description", description);
		requestMap.put("story_code", storyCode);
		requestMap.put("task_title", taskTitle);
		requestMap.put("estimated_time", estimatedTime);
		requestMap.put("assignee", assignee);
		Map<String, String> map=tasksService.insert(requestMap);
		System.out.println("::::::::"+map.get(suiteCode));
		Map<String, String> map2=new HashMap<>();
		assertEquals(map2.getClass(), map.getClass());
	}

	@Test
	public void testUpdate_ReturnMap(){
		
		Map<String, String[]> requestMap=new HashMap<String, String[]>();
		requestMap.put("id", id1);
		requestMap.put("suite_code", suiteCode);
		requestMap.put("suite_name", suiteName);
		requestMap.put("module_code", moduleCode);
		requestMap.put("module_name", moduleName);
		requestMap.put("priv_grp_code", privGrpCode);
		requestMap.put("priv_grp_name", privGrpName);
		requestMap.put("description", description);
		requestMap.put("story_code", storyCode);
		requestMap.put("task_title", taskTitle);
		requestMap.put("estimated_time", estimatedTime);
		requestMap.put("assignee", assignee);
		Map<String, String> map= tasksService.update(requestMap);
		Map<String, String> map2=new HashMap<>();
		assertEquals(map2.getClass(), map.getClass());
	}
	
	@Test
	public void testGetAll_ReturnAllTasks() {
		//List<Tasks> tasksList = tasksService.getAll();
		List<Tasks> mockTtasksList =new ArrayList<Tasks>();
		mockTasks=Mockito.mock(Tasks.class);
		mockTtasksList.add(mockTasks);
		when(tasksService.getAll()).thenReturn(mockTtasksList);
	}
	
	
	@Test
	public void testTasks_GetById() {
		
		Tasks tasks=tasksService.getById(id);
		assertNotNull(tasks);
	}
	    


}