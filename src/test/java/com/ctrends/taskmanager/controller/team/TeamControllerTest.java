package com.ctrends.taskmanager.controller.team;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-database.xml", "/spring-dispatcher-servlet.xml", "/spring-security.xml" })
public class TeamControllerTest {

	@Autowired
	ITeamController teamController;
	
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testCreate_ReturnModelAndView() {
		assertTrue(true);
	}
	
	@Test
	public void testShow_ReturnsModelAndView() {
		UUID id = UUID.fromString("509f3693-178e-4c7a-bdb7-a017d0943920");
		ModelAndView mv = teamController.show(id);
		assertTrue(mv.hasView());
	}

}
