package com.ctrends.taskmanager.dao.user;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;
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
	MockHttpServletRequest request;
	
	@Autowired
	private SessionFactory sessionfactory;

	@Test
	public void testGetAllDoc() {
		List<User> allUserList=userDAO.getAllDoc();
		assertNotNull(allUserList);
	}

	@Test
	public void testGetDocById() {
		UUID id=UUID.fromString("3ee927d1-6bb0-44ca-acc1-061f8d84e91b");
		User allUserList= userDAO.getDocById(id);
		assertNotNull(allUserList);
		
	}

	@Test
	public void testGetDocs() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertDoc() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateDoc() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteDoc() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCurrentUserName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCurrentUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetByUsername() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetByUserName() {
		fail("Not yet implemented");
	}

}
