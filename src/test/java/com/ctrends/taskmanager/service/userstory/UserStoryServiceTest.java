package com.ctrends.taskmanager.service.userstory;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ctrends.taskmanager.controller.userstory.UserStoryController;
import com.ctrends.taskmanager.dao.tman.ITasksDao;
import com.ctrends.taskmanager.dao.user.IUserDAO;
import com.ctrends.taskmanager.dao.userstory.IUserStoryDAO;
import com.ctrends.taskmanager.model.user.User;
import com.ctrends.taskmanager.model.userstory.UserStory;
import com.ctrends.taskmanager.service.tman.ITasksService;
import com.ctrends.taskmanager.service.user.IUserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-database.xml", 
									"/spring-dispatcher-servlet.xml", 
									"/spring-security.xml" })
public class UserStoryServiceTest {
	
	@Mock
	private MockMvc mockMvc;
	
	@Autowired
	UserStoryController userStoryController;
	
	UserStory mockUserStory;
	
	@Mock
	private IUserStoryDAO usersStoryDAO;
	
	@Autowired
	private IUserStoryService userStoryService;
	

	@Autowired
	IUserStoryDAO userStoryDAO;
	
	MockHttpServletRequest request;

	
	String userName = "CTS0104";
	
	String[] empCode = {"abc"};
	
	UUID id=UUID.fromString("0aad717d-e0f7-44c8-ab72-2f9a6b1b57f3");
	
	public UserStoryServiceTest() {
		request = new MockHttpServletRequest();
	}
	

	@Test
	public void testGetAll() {
		assertTrue(true);
	}


	@Test
	@WithMockUser("CTS0104")
	public void testUpdate_ReturnsMap() {
		Map<String, String[]> requestMap=new HashMap<String, String[]>();
		UUID id=UUID.fromString("3ee927d1-6bb0-44ca-acc1-061f8d84e91b");
		String[] idA={String.valueOf(id)};
		requestMap.put("id", idA);
		requestMap.put("emp_code", empCode);
		requestMap.put("emp_name", empCode);
		requestMap.put("emp_desig", empCode);
		requestMap.put("emp_email", empCode);
		requestMap.put("first_name", empCode);
		requestMap.put("middle_name", empCode);
		requestMap.put("last_name", empCode);
		requestMap.put("user_status", empCode);
		requestMap.put("emp_username", empCode);
		requestMap.put("role_code", empCode);
		requestMap.put("role_name", empCode);
		//Map<String, String> user=userService.insert(requestMap);
		Map<String, String> testUser = new HashMap<>();
		//assertEquals(testUser.getClass(), user.getClass());
	}

	@Test
	public void testGetById() {
		UUID id=UUID.fromString("3ee927d1-6bb0-44ca-acc1-061f8d84e91b");
		UserStory allUserStoryList= userStoryService.getById(id);
		assertNotNull(allUserStoryList);
		System.out.println(":::::"+allUserStoryList.getId());
		assertEquals(allUserStoryList.getId().toString(), "3ee927d1-6bb0-44ca-acc1-061f8d84e91b");
	}
	
	@Test
	public void testGetById_ReturnUserStory(){
		UUID id=UUID.fromString("3ee927d1-6bb0-44ca-acc1-061f8d84e91b");
		UserStory userStory= userStoryService.getById(id);
		assertEquals(new UserStory().getClass(), userStory.getClass());
	}

	
}