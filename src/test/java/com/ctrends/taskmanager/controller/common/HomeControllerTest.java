package com.ctrends.taskmanager.controller.common;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.ModelAndView;

import com.ctrends.taskmanager.bean.WSResponse;
import com.google.gson.Gson;

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
	public void testDashboard_ReturnsModelAndView(){
		ModelAndView mav = homeController.dashboard();
		assertTrue(mav.hasView());
	}
	
	@Test
	@WithMockUser("CTS0104")
	public void testNoticeboard_ReturnsModelAndView(){
		ModelAndView mav = homeController.noticeboard();
		assertTrue(mav.hasView());
	}


	@Test
	public void testLogin_ReturnsModelAndView() {
		String a = "adv";
		ModelAndView mav = homeController.login(a, a);
		assertTrue(mav.hasView());
	}

	@Test
	public void testLogout_ReturnsModelAndView() {
		String a = "adv";
		ModelAndView mav = homeController.logout(a);
		assertTrue(mav.hasView());
	}

	@Test
	public void testAccesssDenied_ReturnsModelAndView() {
		ModelAndView mav = homeController.accesssDenied();
		assertTrue(mav.hasView());
	}

	@Test
	public void testLoadpref_ReturnsString() {
		String g = homeController.loadpref(request);
		assertEquals(String.class, g.getClass());
	}

	@Test
	public void testTcodesearch_ReturnsWSResponse() {
		WSResponse ar = homeController.tcodesearch(request);
		assertEquals(WSResponse.class, ar.getClass());
	}

}
