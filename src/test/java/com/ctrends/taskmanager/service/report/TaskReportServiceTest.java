package com.ctrends.taskmanager.service.report;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.validation.constraints.AssertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ctrends.taskmanager.model.tman.TaskLog;
import com.ctrends.taskmanager.model.tman.TaskReportView;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-database.xml", 
		"/spring-dispatcher-servlet.xml", 
		"/spring-security.xml" })

public class TaskReportServiceTest {
	
	@Autowired
	ITaskReportService taskreportservice;
	
	String companyCode ="HRM";
	String empCode ="Human Resource";
	String empName = "ED";
	String username = "Employee Database";
	
	
	@Test
	@WithMockUser("CTS0104")
	public void testfindUserWiseDailyTasks_returndata(){
		
		Map<String, String> parameterMap=new HashMap<String, String>();
		String start_date = "15-Apr-2017";
		parameterMap.put("startdate", start_date);		
		parameterMap.put("username", "CTS0104");
		
		
		List<TaskReportView> tt= taskreportservice.findUserWiseDailyTasks(parameterMap);
		
		//assertTrue(tt.isEmpty());
		assertTrue(tt.size()>0);
		
	}
	
	@Test
	public void testgetDailySummaryReportElement_returndata(){
		Map<String, String> parameterMap=new HashMap<String, String>();
		
		String start_date = "04-Apr-2017";
		parameterMap.put("startdate", String.valueOf(start_date));
		
		Map<String, Object> tt= taskreportservice.getDailySummaryReportElement(parameterMap);
		
		assertTrue(true);
		
	}
	

}
