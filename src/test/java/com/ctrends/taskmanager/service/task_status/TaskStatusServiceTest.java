package com.ctrends.taskmanager.service.task_status;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-database.xml", 
									"/spring-dispatcher-servlet.xml", 
									"/spring-security.xml" })
public class TaskStatusServiceTest {
	
	@Autowired
	ITaskStatusService taskStatusService;
	
	MockHttpServletRequest request;
	
	String sprintCode = "1";

	public TaskStatusServiceTest() {
		request=new MockHttpServletRequest();
	}
	
	@Test
	public void testUpdateStatus_ReturnUUID() {
		UUID id=UUID.fromString("4f222d58-b731-4c45-8848-17c0e0a8b6aa");
		String taskStatus= "In Progress";
		UUID updateStatus=taskStatusService.updateStatus(id, taskStatus);
		assertEquals(id.getClass(),updateStatus.getClass());
	}
	
	@Test
	public void testUpdateStoryStatus_ReturnUUID(){
		UUID id=UUID.fromString("116d72b4-e224-401c-9b59-b04cd2e5e9f7");
		String storyStatus= "Story";
		UUID updateStoryStatus=taskStatusService.updateStoryStatus(id, storyStatus);
		assertEquals(id.getClass(),updateStoryStatus.getClass());
		
	}
	
	@Test
	public void testGetSprintManagerBySprintCode_ReturnMap(){
		
		Map<String, Object> sprintdetail=taskStatusService.getSprintManagerBySprintCode(sprintCode);
		Map<String, String> map=new HashMap<>();
		assertEquals(map.getClass(), sprintdetail.getClass());
	}
	
}
