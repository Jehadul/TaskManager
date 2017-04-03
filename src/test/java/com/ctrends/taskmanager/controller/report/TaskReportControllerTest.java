package com.ctrends.taskmanager.controller.report;

import static org.junit.Assert.assertTrue;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-database.xml", "/spring-dispatcher-servlet.xml", "/spring-security.xml" })
public class TaskReportControllerTest {

	MockHttpServletRequest request;

	
	
	
	
	@Before
	public void setup() {}
	
	
	
	
	@Test
	public void testTasklogreport__ReturnModelAndView() {
		assertTrue(true);
	}
	
	@Test
	public void testGenerateUserWiseReport__ReturnModelAndView() {
		assertTrue(true);
	}
}
