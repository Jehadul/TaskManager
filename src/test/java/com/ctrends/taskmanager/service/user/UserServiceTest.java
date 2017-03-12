package com.ctrends.taskmanager.service.user;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ctrends.taskmanager.dao.user.IUserDAO;
import com.ctrends.taskmanager.model.user.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-database.xml", 
									"/spring-dispatcher-servlet.xml", 
									"/spring-security.xml" })
public class UserServiceTest {
	
	@Autowired
	IUserDAO userDAO; 
	
	@Mock
	private MockMvc mockMvc;
	
	@Autowired
	IUserService userService;
	
	String userName = "CTS0104";
	

	MockHttpServletRequest request;
	
	public UserServiceTest() {
		request = new MockHttpServletRequest();
	}
	

	@Test
	public void testGetAll() {
		System.out.println("ok");
	}

	@Test
	public void testGetUserByUserName() {
		  User userDetails = userService.getUserByUserName(userName);
		  System.out.println("::"+userDetails.getUsername());
		  System.out.println("::"+userName);
		  assertEquals(userDetails.getUsername(), userName);
	}

	@Test
	public void testInsert() {
		System.out.println("ok");
	}

	@Test
	public void testUpdate() {
		System.out.println("ok");
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
	public void testDelete() {
		System.out.println("ok");
	}

	@Test
	public void testUpdateTasklist() {
		System.out.println("ok");
	}

}
