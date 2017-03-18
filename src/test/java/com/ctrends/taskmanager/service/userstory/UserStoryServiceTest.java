package com.ctrends.taskmanager.service.userstory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
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
import com.ctrends.taskmanager.dao.userstory.IUserStoryDAO;
import com.ctrends.taskmanager.model.userstory.UserStory;


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
	String[] privGrpCode={String.valueOf("1")};
	
	
	public UserStoryServiceTest() {
		request = new MockHttpServletRequest();
	}
	
	
	@Test
	@WithMockUser("CTS0104")
	public void testInsert_ReturnsMap(){
		Map<String, String[]> requestMap=new HashMap<String, String[]>();
		requestMap.put("suite_code", empCode);
		requestMap.put("suite_name", empCode);
		requestMap.put("module_code", empCode);
		requestMap.put("module_name", empCode);
		requestMap.put("priv_grp_code", privGrpCode);
		requestMap.put("priv_grp_name", empCode);
		requestMap.put("description", empCode);
		requestMap.put("acceptance_criteria", empCode);
		requestMap.put("business_value", empCode);
		requestMap.put("user_story_code", empCode);
		requestMap.put("user_story_title", empCode);
		requestMap.put("privilege_code", empCode);
		requestMap.put("privilege_name", empCode);
		requestMap.put("size", privGrpCode);
		requestMap.put("priority", empCode);
		requestMap.put("priority_code", privGrpCode);
		requestMap.put("story_order", empCode);
		Map<String, String> user=userStoryService.insert(requestMap);
		Map<String, String> testUser = new HashMap<>();
		assertEquals(testUser.getClass(), user.getClass());
	}
	
	@Test
	public void testGetAll_ReturnsList() {
		List<UserStory> allUserStoryList=userStoryDAO.getAllDoc();
		assertNotNull(allUserStoryList);
	}
	
	@Test
	public void testGetById() {
		UUID id=UUID.fromString("285d4d33-8de2-4768-8fac-3e4bb4147d75");
		UserStory allUserStoryList= userStoryService.getById(id);
		assertNotNull(allUserStoryList);
		System.out.println(":::::"+allUserStoryList.getId());
		assertEquals(allUserStoryList.getId().toString(), "b716141d-ca6b-4ca0-9c0f-f841a16e6cd8");
	}

	@Test
	@WithMockUser("CTS0104")
	public void testUpdate_ReturnsMap() {
		Map<String, String[]> requestMap=new HashMap<String, String[]>();
		UUID id=UUID.fromString("285d4d33-8de2-4768-8fac-3e4bb4147d75");
		String[] idA={String.valueOf(id)};
		requestMap.put("id", idA);
		requestMap.put("suite_code", empCode);
		requestMap.put("suite_name", empCode);
		requestMap.put("module_code", empCode);
		requestMap.put("module_name", empCode);
		requestMap.put("priv_grp_code", privGrpCode);
		requestMap.put("priv_grp_name", empCode);
		requestMap.put("description", empCode);
		requestMap.put("acceptance_criteria", empCode);
		requestMap.put("business_value", empCode);
		requestMap.put("user_story_code", empCode);
		requestMap.put("user_story_title", empCode);
		requestMap.put("privilege_code", empCode);
		requestMap.put("privilege_name", empCode);
		requestMap.put("size", privGrpCode);
		requestMap.put("priority", empCode);
		requestMap.put("priority_code", privGrpCode);
		requestMap.put("story_order", empCode);
		//Map<String, String> user=userService.insert(requestMap);
		Map<String, String> testUser = new HashMap<>();
		//assertEquals(testUser.getClass(), user.getClass());
	}
	
	@Test
	public void testDelete_ReturnsUUID(){
		Map<String, String[]> requestMap=new HashMap<String, String[]>();
		UUID id=UUID.fromString("09271978-cf81-4f47-9d2f-337543a8f5a9");
		String[] idArray={String.valueOf(id)};
		requestMap.put("id", idArray);
		requestMap.put("suite_code", empCode);
		requestMap.put("suite_name", empCode);
		requestMap.put("module_code", empCode);
		requestMap.put("module_name", empCode);
		requestMap.put("priv_grp_code", privGrpCode);
		requestMap.put("priv_grp_name", empCode);
		requestMap.put("description", empCode);
		requestMap.put("acceptance_criteria", empCode);
		requestMap.put("business_value", empCode);
		requestMap.put("user_story_code", empCode);
		requestMap.put("user_story_title", empCode);
		requestMap.put("privilege_code", empCode);
		requestMap.put("privilege_name", empCode);
		requestMap.put("size", privGrpCode);
		requestMap.put("priority", empCode);
		requestMap.put("story_order", empCode);
		UUID uid= userStoryService.delete(requestMap);
		assertEquals(id.getClass(), uid.getClass());
	}

	
	
	@Test
	public void testGetById_ReturnUserStory(){
		UUID id=UUID.fromString("285d4d33-8de2-4768-8fac-3e4bb4147d75");
		UserStory userStory= userStoryService.getById(id);
		assertEquals(new UserStory().getClass(), userStory.getClass());
	}
	
	

	
}