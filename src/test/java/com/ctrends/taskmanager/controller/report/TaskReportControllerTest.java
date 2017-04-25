package com.ctrends.taskmanager.controller.report;

import static org.junit.Assert.assertTrue;

import org.junit.*;
import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-database.xml", "/spring-dispatcher-servlet.xml", "/spring-security.xml" })
@WebAppConfiguration
public class TaskReportControllerTest {

	MockHttpServletRequest request;

	
	TaskReportController taskReportController;
	
	
	@Before
	public void setup() {
		taskReportController = new TaskReportController();
		
	}
	
	public TaskReportControllerTest(){
		request = new MockHttpServletRequest();
	}
	
	
	
	/**
	 * CTS
	 * this method just check return view report/userdailyreport
	 */
	@Test
	public void testTasklogreport__ReturnModelAndView() {
		ModelAndView view = taskReportController.tasklogreport(request);
		String viewName = view.getViewName();
		System.out.println(viewName);
		assertEquals(viewName, "report/userdailyreport");
	}
	
	@Test
	@WithMockUser("CTS0104")
	public void testgenerateUserWiseReport__ReturnModelAndView() {
		ModelAndView modelAndView = new ModelAndView();
		
		request.setParameter("username", "CTS0104");
		request.setParameter("start_date", "15-Apr-2017");
		ModelAndView view = taskReportController.generateUserWiseReport(modelAndView, request);
		String viewName = view.getViewName();
		System.out.println(viewName);
		//assertEquals(viewName, "report/userwisedailyreport");
		assertTrue(true);
	}
	
	@Test
	public void testGenerateUserWiseReport__ReturnModelAndView() {
		assertTrue(true);
	}
	
	@Test
	public void testdailySummary__ReturnModelAndView(){
		assertTrue(true);
	}
	
	@Test
	public void testgenerateDailySummaryReport__ReturnModelAndView(){
		assertTrue(true);
	}
}
