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
	
	UUID id=UUID.fromString("0a2aace0-0243-47dd-8c3c-bdb5aeaf233f");

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
	
	
	@Test
	public void test_InsertReturnsMap(){
		Map<String, String[]> requestMap=new HashMap<String, String[]>();
		//requestMap.put(suiteCode);
		Tasks tasks=new Tasks();
		
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
		
		tasks.setSuiteCode(requestMap.get("suite_code")[0]);
		tasks.setSuiteName(requestMap.get("suite_name")[0]);
		tasks.setModuleCode(requestMap.get("module_code")[0]);
		tasks.setModuleName(requestMap.get("module_name")[0]);
		tasks.setPrivGrpCode(Integer.parseInt(requestMap.get("priv_grp_code")[0]));
		tasks.setPrivGrpName(requestMap.get("priv_grp_name")[0]);
		tasks.setDescription(requestMap.get("description")[0]);
		tasks.setStoryCode(requestMap.get("story_code")[0]);
	    
		tasks.setTaskTitle(requestMap.get("task_title")[0]);
		tasks.setEstimatedTime(requestMap.get("estimated_time")[0]);
		tasks.setAsignee(requestMap.get("assignee")[0]);
		
		Map<String, String> map=tasksService.insert(requestMap);
		System.out.println("::::::::"+map.get(suiteCode));
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
	public void testGetById() {
		
		Tasks tasks=tasksService.getById(id);
		assertNotNull(tasks);
	}
	    


}