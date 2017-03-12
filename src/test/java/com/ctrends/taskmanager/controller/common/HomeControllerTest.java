package com.ctrends.taskmanager.controller.common;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-database.xml", 
									"/spring-dispatcher-servlet.xml", 
									"/spring-security.xml" })
public class HomeControllerTest {
	
	@Mock
	private MockMvc mockMvc;
	
	@Autowired
	HomeController homeController;
	
	
	
	MockHttpServletRequest request;
	public HomeControllerTest(){
		request = new MockHttpServletRequest();
	}

	@Test
	public void testIndex(){
		ModelAndView mav = homeController.index();
		assertTrue(mav.hasView());
	}

	@Test
	public void testLogin() {
		fail("Not yet implemented");
	}

	@Test
	public void testLogout() {
		fail("Not yet implemented");
	}

	@Test
	public void testAccesssDenied() {
		fail("Not yet implemented");
	}

	@Test
	public void testLoadpref() {
		fail("Not yet implemented");
	}

	@Test
	public void testTcodesearch() {
		fail("Not yet implemented");
	}

}
