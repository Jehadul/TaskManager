package com.ctrends.taskmanager.dao.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ctrends.taskmanager.model.user.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-database.xml", 
									"/spring-dispatcher-servlet.xml", 
									"/spring-security.xml" })
public class UserDAOTest {
	
	@Autowired
	IUserDAO userDAO;
	
	UUID id=UUID.fromString("3ee927d1-6bb0-44ca-acc1-061f8d84e91b");
	String empCode 	= "CTS0001";
	String empName 	= "Mamunur Rahman";
	String userName = "CTS0104";
	
	MockHttpServletRequest request;
	
	@Autowired
	private SessionFactory sessionfactory;

	@Test
	public void testGetAllDoc() {
		List<User> allUserList=userDAO.getAllDoc();
		assertNotNull(allUserList);
		assertEquals(allUserList.size(), 10);
	}

	@Test
	public void testGetDocById() {
		UUID id=UUID.fromString("3ee927d1-6bb0-44ca-acc1-061f8d84e91b");
		User allUserList= userDAO.getDocById(id);
		assertNotNull(allUserList);
		System.out.println(":::::"+allUserList.getId());
		assertEquals(allUserList.getId().toString(), "3ee927d1-6bb0-44ca-acc1-061f8d84e91b");
		
	}

	@Test
	public void testGetDocs() {
		Map<String, String> data = new HashMap<String, String>();
		data.get(empCode);
		data.get(empName);
		List<User> userList = userDAO.getDocs(data);
		assertNotNull(userList);
	}



/*	@Test
	public void testGetCurrentUser() {
		fail("Not yet implemented");
	}*/

	@Test
	public void testGetByUsername() {
		  User userDetails = userDAO.getByUsername(userName);
		  System.out.println("::"+userDetails.getUsername());
		  System.out.println("::"+userName);
		  assertEquals(userDetails.getUsername(), userName);
	}

	

}
