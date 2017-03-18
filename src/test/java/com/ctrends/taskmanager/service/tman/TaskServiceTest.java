package com.ctrends.taskmanager.service.tman;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
import org.springframework.security.test.context.support.WithMockUser;
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
	

	


	@Autowired
	TasksController tasksController;
	
	Tasks mockTasks;

	@Mock
	private ITasksDao taskDao;

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
	String[] remainingTime = {"aaaaaaaa"};
	String[] spentTime = {"bbbbbbbb"};
	String[] assignee = {"sdfsdfgdfg"};
	String [] id1 = {String.valueOf("8b1ac3ff-041f-48a9-9a5b-f6472ec50c69")};
	
	@Test
	@WithMockUser("CTS0104")
	public void testInsert_ReturnsMap(){
		
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
		requestMap.put("estimated_time", privGrpCode);
		requestMap.put("assignee", assignee);
		Map<String, String> map=tasksService.insert(requestMap);
		System.out.println("::::::::"+map.get(suiteCode));
		Map<String, String> map2=new HashMap<>();
		assertEquals(map2.getClass(), map.getClass());
	}
	
	@Test
	@WithMockUser("CTS0104")
	public void testInsertTaskLog_ReturnsMap(){
		UUID id=UUID.fromString("8b1ac3ff-041f-48a9-9a5b-f6472ec50c69");
		Date date=new Date();
		Map<String, String> requestMap=new HashMap<String, String>();
		requestMap.put("id", String.valueOf(id));
		requestMap.put("taskTitle", "hgfhg");
		requestMap.put("startTime", "startTime");
		requestMap.put("stopStatus", String.valueOf("false"));
		requestMap.put("today", String.valueOf(date));
		Map<String, String> map= tasksService.insertTaskLog(requestMap);
		Map<String, String> map2=new HashMap<>();
		assertEquals(map2.getClass(), map.getClass());
	}

	
	
	@Test
	public void testGetAll_ReturnsTasksLi() {
		List<Tasks> tasksList = tasksService.getAll();
		/*List<Tasks> mockTtasksList =new ArrayList<Tasks>();
		mockTasks=Mockito.mock(Tasks.class);
		mockTtasksList.add(mockTasks);
		when(tasksService.getAll()).thenReturn(mockTtasksList);*/
		assertEquals(tasksList.getClass(), new ArrayList<>().getClass());
		
	}
	
	@Test
	public void testGetById_ReturnsTasks() {
		UUID id=UUID.fromString("afe67120-346b-488a-8b69-9736511fc884");
		Tasks tasks=tasksService.getById(id);
		assertNotNull(tasks);
	}
	
	@Test
	@WithMockUser("CTS0104")
	public void testUpdate_ReturnsMap(){
		
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
		requestMap.put("estimated_time", privGrpCode);
		requestMap.put("assignee", assignee);
		Map<String, String> map= tasksService.update(requestMap);
		Map<String, String> map2=new HashMap<>();
		assertEquals(map2.getClass(), map.getClass());
	}
	    
/*	@Test
	@WithMockUser("CTS0104")
	public void testUpdateTaskLog_ReturnsMap(){
		Map<String, String> requestMap=new HashMap<String, String>();
		requestMap.put("id", String.valueOf(id));
		requestMap.put("id", String.valueOf(UUID.fromString("8b1ac3ff-041f-48a9-9a5b-f6472ec50c69")));
		requestMap.put("stopTime", String.valueOf("12"));
		requestMap.put("stopStatus", String.valueOf("false"));
		requestMap.put("status", String.valueOf("false"));
		Map<String, String> map= tasksService.updateTimeLog(requestMap);
		Map<String, String> map2=new HashMap<>();
		assertEquals(map2.getClass(), map.getClass());
	}
	*/
	@Test
	public void testDelete_ReturnsMap(){
		UUID id=UUID.fromString("fc6e9d59-830c-4cfb-9d75-c4336e0f73c7");
		Map<String, String[]> requestMap=new HashMap<String, String[]>();
		
		Tasks tasks=new Tasks();
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
		requestMap.put("estimated_time", privGrpCode);
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
		tasks.setEstimatedTime(Double.parseDouble(requestMap.get("estimated_time")[0]));
		tasks.setAsignee(requestMap.get("assignee")[0]);
		
	
		UUID uid= tasksService.delete(requestMap);
		assertEquals(id.getClass(), uid.getClass());
	}
	
	@Test
	public void testFind_ReturnsTaskLi(){
		
		Map<String, String> params=new LinkedHashMap<>();
		List<Tasks> tsk=tasksService.find(params);
		assertNotNull(tsk);
	}
	
	@Test
	@WithMockUser("CTS0104")
	public void testGetAllByCurrentUser_ReturnsTaskLi(){
		List<Tasks> tsk=tasksService.getAllByCurrentUser();
		assertNotNull(tsk);
	}
	
	@Test
	@WithMockUser("CTS0104")
	public void testGetAllByCurrentUserByCurrentName_ReturnsTaskLi(){
		List<Tasks> tsk=tasksService.getCurrentTaskByCurrentUser();
		assertNotNull(tsk);
	}
}