package com.ctrends.taskmanager.dao.report;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.validation.constraints.AssertTrue;

import org.eclipse.jdt.internal.compiler.ast.AssertStatement;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ctrends.taskmanager.bean.Utility;
import com.ctrends.taskmanager.model.tman.TaskLog;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-database.xml", 
		"/spring-dispatcher-servlet.xml", 
		"/spring-security.xml" })

public class TaskReportDAOTest {

	@Autowired 
	ITaskReportDAO taskreportdao;

	
	@Test
	public void testgetAllDocByToDate_returndata(){
		
		TaskLog taskLog = new TaskLog();
		java.sql.Date reportDate = (Date) Utility.toSqlDate(("04-Apr-2017"));
		taskLog.setStopDate(reportDate);
		
		
		//Map<String, Object> dsum = taskreportdao.getAllDocByToDate(taskLog);
		assertTrue(true);
	}
	
	@Test
	public void testGetTaskLogByTaskIdAndDate_ReturnList(){
		
		String start_date = "04-Apr-2017";
				
		UUID taskId=UUID.fromString("9b5900e8-c0d4-491f-9b5c-e82890ef11d2");
		
		List<TaskLog> list = taskreportdao.getTaskLogByTaskIdAndDate(taskId, start_date);
		
		assertTrue(!list.isEmpty());
		
	}
	
	
	
	
}
