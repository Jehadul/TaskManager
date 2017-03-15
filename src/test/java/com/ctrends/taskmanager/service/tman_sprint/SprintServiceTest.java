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
    String[] sprintStories = {"TestSprintStories"};
    String[] startDate = {""};
    String[] endDate = {""};
    String[] sprintDescription = {"TestSprintDescription"};
    
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
	public void testGetById_ReturnTasks() {
		
		SprintManager apman=sprintService.getById(id);
		assertNotNull(apman);
	}
	
}
