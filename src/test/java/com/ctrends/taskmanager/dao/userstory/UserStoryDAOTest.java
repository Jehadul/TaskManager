package com.ctrends.taskmanager.dao.userstory;

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
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ctrends.taskmanager.dao.user.IUserDAO;
import com.ctrends.taskmanager.model.tman.Tasks;
import com.ctrends.taskmanager.model.user.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-database.xml", 
									"/spring-dispatcher-servlet.xml", 
									"/spring-security.xml" })
public class UserStoryDAOTest {
	
	@Autowired
	IUserDAO userDAO;
	
	UUID id=UUID.fromString("3ee927d1-6bb0-44ca-acc1-061f8d84e91b");
	String empCode 	= "CTS0001";
	String empName 	= "Mamunur Rahman";
	String userName = "CTS0104";
	String currentUserName = "Mamunur Rahman";
	
	MockHttpServletRequest request;
	
	@Autowired
	private SessionFactory sessionfactory;

	@Test
	public void testGetAllDoc_ReturnList() {
		List<User> allUserList=userDAO.getAllDoc();
		assertNotNull(allUserList);
		//assertEquals(10, allUserList.size());
	}

	@Test
	public void testGetDocById_ReturnUser() {
		UUID id=UUID.fromString("3ee927d1-6bb0-44ca-acc1-061f8d84e91b");
		User allUserList= userDAO.getDocById(id);
		assertNotNull(allUserList);
		System.out.println(":::::"+allUserList.getId());
		assertEquals("3ee927d1-6bb0-44ca-acc1-061f8d84e91b", allUserList.getId().toString());
		
	}

	@Test
	public void testGetDocs_ReturnList() {
		Map<String, String> data = new HashMap<String, String>();
		data.get(empCode);
		data.get(empName);
		List<User> userList = userDAO.getDocs(data);
		assertNotNull(userList);
	}

	@Test
	public void testInsertDoc_ReturnUUID(){
		User doc=new User();
		UUID actualId = userDAO.insertDoc(doc); 
		assertEquals(id.getClass(), actualId.getClass());
	}
	
	@Test
	public void testUpdateDoc_ReturnUUID(){
		User doc=new User();
		UUID actualId = userDAO.updateDoc(doc); 
		assertEquals(id.getClass(), actualId.getClass());
	}
	
	@Test
	@WithMockUser("CTS0104")
	public void testGetCurrentUserName_ReturnString(){
		String currentUser = userDAO.getCurrentUserName();
		assertNotNull(currentUser);
		assertEquals(userName, currentUser);
	}
	
	
	@Test
	@WithMockUser("CTS0104")
	public void testGetCurrentUser_ReturnUser(){
		User user = userDAO.getCurrentUser();
		assertNotNull(user);
		assertEquals("3ee927d1-6bb0-44ca-acc1-061f8d84e91b", user.getId().toString());
		assertEquals(userName, user.getUsername());
	}

/*	@Test
	public void testGetCurrentUser() {
		fail("Not yet implemented");
	}*/

	
	@Test
	public void testGetByUsername_ReturnUser() {
		  User userDetails = userDAO.getByUsername(userName);
		  System.out.println("::"+userDetails.getUsername());
		  System.out.println("::"+userName);
		  assertEquals(userName, userDetails.getUsername());
		  assertEquals(new User().getClass(), userDetails.getClass());
	}

	@Test
	public void testGetByUserName_ReturnUser() {
		  User userDetails = userDAO.getByUsername(userName);
		  assertEquals(userName, userDetails.getUsername());
		  assertEquals(new User().getClass(), userDetails.getClass());
	}
	

}
