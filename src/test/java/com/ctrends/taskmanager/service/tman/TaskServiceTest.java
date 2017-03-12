package com.ctrends.taskmanager.service.tman;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
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
	@Mock
	private ITasksService tasksService;

	@Autowired
	ITasksDao tasksDao;
	
	
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