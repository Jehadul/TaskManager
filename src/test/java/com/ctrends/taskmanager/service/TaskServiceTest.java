package com.ctrends.taskmanager.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.ctrends.taskmanager.dao.tman.ITasksDao;
import com.ctrends.taskmanager.model.tman.Tasks;
import com.ctrends.taskmanager.service.tman.ITasksService;
import com.ctrends.taskmanager.service.tman.TasksService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-database.xml", 
									"/spring-dispatcher-servlet.xml", 
									"/spring-security.xml" })


public class TaskServiceTest {
	
	@Mock
	private MockMvc mockMvc;
	
	UUID id=UUID.fromString("0a2aace0-0243-47dd-8c3c-bdb5aeaf233f");

	@Autowired
	ITasksDao tasksDao;
	
	
	@Autowired
	private ITasksService tasksService;
	
	
	@Test
	public void testGetAll() {
		List<Tasks> taskLi=tasksService.getAll();
		assertNotNull(taskLi);
	}
	
	
	@Test
	public void testGetById() {
		
		Tasks tasks=tasksService.getById(id);
		assertNotNull(tasks);
	}
	    


}