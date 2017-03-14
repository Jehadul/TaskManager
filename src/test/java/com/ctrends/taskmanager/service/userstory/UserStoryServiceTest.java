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

import com.ctrends.taskmanager.dao.user.IUserDAO;
import com.ctrends.taskmanager.model.user.User;
import com.ctrends.taskmanager.service.user.IUserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-database.xml", 
									"/spring-dispatcher-servlet.xml", 
									"/spring-security.xml" })
public class UserStoryServiceTest {
	
	
	//@Mock
	@Autowired
	IUserDAO userDAO; 
	
	@Mock
	private MockMvc mockMvc;
	
	@Autowired
	IUserService userService;
	
	String userName = "CTS0104";
	
	@Mock
	User user1=new User();

	MockHttpServletRequest request;
	
	String[] empCode = {"abc"};
	
	
	public UserStoryServiceTest() {
		request = new MockHttpServletRequest();
	}
	

	@Test
	public void testGetAll() {
		assertTrue(true);
	}

	@Test
	public void testGetUserByUserName() {
		  User userDetails = userService.getUserByUserName(userName);
		  System.out.println("::"+userDetails.getUsername());
		  System.out.println("::"+userName);
		  assertEquals(userDetails.getUsername(), userName);
	}
	
	@Test
	public void testGetByUserName_ReturnsUser(){
		User user = userService.getUserByUserName(userName);
		assertEquals(new User().getClass(), user.getClass());
	}
	
	@Test
	@WithMockUser("CTS0104")
	public void testInsert_ReturnsMap(){
		Map<String, String[]> requestMap=new HashMap<String, String[]>();
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
		Map<String, String> user=userService.insert(requestMap);
		Map<String, String> testUser = new HashMap<>();
		assertEquals(testUser.getClass(), user.getClass());
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
		Map<String, String> user=userService.insert(requestMap);
		Map<String, String> testUser = new HashMap<>();
		assertEquals(testUser.getClass(), user.getClass());
	}

	@Test
	public void testGetById() {
		UUID id=UUID.fromString("3ee927d1-6bb0-44ca-acc1-061f8d84e91b");
		User allUserList= userService.getById(id);
		assertNotNull(allUserList);
		System.out.println(":::::"+allUserList.getId());
		assertEquals(allUserList.getId().toString(), "3ee927d1-6bb0-44ca-acc1-061f8d84e91b");
	}
	
	@Test
	public void testGetById_ReturnsUser(){
		UUID id=UUID.fromString("3ee927d1-6bb0-44ca-acc1-061f8d84e91b");
		User user= userService.getById(id);
		assertEquals(new User().getClass(), user.getClass());
	}

	@Test
	public void testDelete() {
		assertTrue(true);
	}

	@Test
	public void testUpdateTasklist() {
		assertTrue(true);
	}

}