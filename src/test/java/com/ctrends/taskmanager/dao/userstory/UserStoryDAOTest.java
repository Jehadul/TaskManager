package com.ctrends.taskmanager.dao.userstory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.LinkedHashMap;
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
import com.ctrends.taskmanager.model.userstory.UserStory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-database.xml", 
									"/spring-dispatcher-servlet.xml", 
									"/spring-security.xml" })
public class UserStoryDAOTest {
	
	@Autowired
	IUserStoryDAO userStoryDAO;
	
	UUID id=UUID.fromString("3ee927d1-6bb0-44ca-acc1-061f8d84e91b");
	
	
	MockHttpServletRequest request;
	
	@Autowired
	private SessionFactory sessionfactory;

	@Test
	public void testGetAllDoc_ReturnList() {
		List<UserStory> allUserStoryList=userStoryDAO.getAllDoc();
		assertNotNull(allUserStoryList);
		//assertEquals(10, allUserList.size());
	}

	@Test
	public void testGetDocById_ReturnUserStory() {
		UUID id=UUID.fromString("55a539d6-29b4-44a2-81ad-180ed313fc63");
		UserStory allUserStoryList= userStoryDAO.getDocById(id);
		assertNotNull(allUserStoryList);
		
		assertEquals("55a539d6-29b4-44a2-81ad-180ed313fc63", allUserStoryList.getId().toString());
		
	}
	
	@Test
	public void testGetDocs_ReturnsList(){
		Map<String, String> params=new LinkedHashMap<>();
		List<UserStory> tasksLi=userStoryDAO.getDocs(params);
		assertNotNull(tasksLi);
	}

	@Test
	public void testInsertDoc_ReturnsUUID(){
		UserStory doc=new UserStory();
		UUID actualId = userStoryDAO.insertDoc(doc); 
		assertEquals(id.getClass(), actualId.getClass());
	}
	
	@Test
	public void testUpdateDoc_ReturnUUID(){
		UserStory doc=new UserStory();
		UUID actualId = userStoryDAO.updateDoc(doc); 
		assertEquals(id.getClass(), actualId.getClass());
	}
	
	
	@Test
	public void testDeleteDoc_ReturnUUID(){
		UUID inId = userStoryDAO.deleteDoc(id); 
		assertEquals(id.getClass(), inId.getClass());
	}
	

}
