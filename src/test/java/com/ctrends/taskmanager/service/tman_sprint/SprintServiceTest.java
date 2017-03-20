package com.ctrends.taskmanager.service.tman_sprint;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ctrends.taskmanager.model.tman.Tasks;
import com.ctrends.taskmanager.model.tman_sprint.SprintManager;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = { "/spring-database.xml", 
									"/spring-dispatcher-servlet.xml", 
									"/spring-security.xml" })

public class SprintServiceTest {

UUID id=UUID.fromString("86f2b68d-b0d5-45ec-adee-179745bedba1");
    
    MockHttpServletRequest request;
    
    @Autowired
    ISprintService sprintService;
    
    
    String[] suiteName ={"Human Resource"};
    String[] moduleName = {"Employee Database"};
    String[] privGrpName = {"Data Entry and Processing"};
    String[] sprintCode = {"TESTCODE"};
    String[] sprintName = {"TestSprintName"};
    String[] sprintGoal = {"TestSprintGoal"};
    String[] sprintNumber = {"1254"};
    String[] privGrpCode = {"1254"};
    String[] sprintStories = {"TestSprintStories"};
    String[] startDate = {""};
    String[] endDate = {""};
    String[] sprintDescription = {"TestSprintDescription"};
    String [] id1 = {String.valueOf("ef0de4a3-f127-474b-94a6-b12d0dbf5f13")};
    
    public SprintServiceTest() {
        request = new MockHttpServletRequest();
    }
    
    
    @Test
    @WithMockUser("CTS0104")
    public void testInsert_ReturnMap(){
        
        Map<String, String[]> requestMap=new HashMap<String, String[]>();
        
        
        requestMap.put("suite_name", suiteName);
        requestMap.put("module_name", suiteName);
        requestMap.put("priv_grp_name", suiteName);
        requestMap.put("sprint_code", sprintCode);
        requestMap.put("sprint_name", sprintName);
        requestMap.put("sprint_goal", sprintGoal);
        requestMap.put("sprint_stories", sprintStories);
        requestMap.put("sprint_number", sprintNumber);
        requestMap.put("start_date", startDate);
        requestMap.put("end_date", endDate);
        requestMap.put("sprint_description", sprintDescription);
        
        
        Map<String, String> reqMap=sprintService.insert(requestMap);
        Map<String, String> shouldMap=new HashMap<>();
        assertEquals(shouldMap.getClass(), reqMap.getClass());
    }
    
    
    @Test
	@WithMockUser("CTS0104")
	public void testUpdate_ReturnsMap() {
		Map<String, String[]> requestMap=new HashMap<String, String[]>();
		UUID id=UUID.fromString("142b097e-03a6-4d5c-a34f-3b4e32f8eed9");
		String[] idA={String.valueOf(id)};
		    requestMap.put("id", idA);
		    requestMap.put("suite_code", suiteName);
			requestMap.put("suite_name", suiteName);
			requestMap.put("module_code", suiteName);
			requestMap.put("module_name", suiteName);
			requestMap.put("priv_grp_code", privGrpCode);
			requestMap.put("priv_grp_name", suiteName);
			requestMap.put("sprint_code", suiteName);
			requestMap.put("sprint_name", suiteName);
			requestMap.put("sprint_goal", suiteName);
			requestMap.put("sprint_number", sprintNumber);
			requestMap.put("sprint_stories", suiteName);
			requestMap.put("sprint_description", suiteName);
			requestMap.put("start_date", startDate);
			requestMap.put("end_date", endDate);
			requestMap.put("sprint_story_code", suiteName);
			
	        Map<String, String> map= sprintService.update(requestMap);
			Map<String, String> map2=new HashMap<>();
			assertEquals(map2.getClass(), map.getClass());
		

	}

	
	@Test
	public void testGetById_ReturnTasks() {
		
		SprintManager apman=sprintService.getById(id);
		assertNotNull(apman);
	}
	
	@Test
	public void testDelete_ReturnsUUID(){
		
		Map<String, String[]> requestMap=new HashMap<String, String[]>();
		UUID id=UUID.fromString("ef0de4a3-f127-474b-94a6-b12d0dbf5f13");
		String[] idArray={String.valueOf(id)};
		requestMap.put("id", idArray);
		requestMap.put("suite_name", suiteName);
        requestMap.put("module_name", suiteName);
        requestMap.put("priv_grp_name", suiteName);
        requestMap.put("sprint_code", sprintCode);
        requestMap.put("sprint_name", sprintName);
        requestMap.put("sprint_goal", sprintGoal);
        requestMap.put("sprint_stories", sprintStories);
        requestMap.put("sprint_number", sprintNumber);
        requestMap.put("start_date", startDate);
        requestMap.put("end_date", endDate);
        requestMap.put("sprint_description", sprintDescription);
		
		UUID uid= sprintService.delete(requestMap);
		assertEquals(id.getClass(), uid.getClass());
	}
	
}
