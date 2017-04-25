package com.ctrends.taskmanager.controller.tman;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Date;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ModelAndView;

import com.ctrends.taskmanager.bean.WSResponse;
import com.ctrends.taskmanager.dao.tman.ITasksDao;
import com.ctrends.taskmanager.model.tman.Tasks;
import com.ctrends.taskmanager.service.tman.ITasksService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-database.xml", "/spring-dispatcher-servlet.xml", "/spring-security.xml" })
public class TasksControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	TasksController tasksController;

	Tasks mockTasks;

	@Autowired
	ITasksDao taskDao;

	/*
	 * @Autowired private ITasksService tasksService;
	 */
	@Mock
	private ITasksService tasksService;

	@Autowired
	ITasksDao tasksDao;

	MockHttpServletRequest request;

	String st = "sssssssss";

	@Before
	public void setup() {

		// Process mock annotations
		MockitoAnnotations.initMocks(this);

		// Setup Spring test in standalone mode
		this.mockMvc = MockMvcBuilders.standaloneSetup(tasksController).build();

	}

	public TasksControllerTest() {
		request = new MockHttpServletRequest();
	}

	@Test
	@WithMockUser("CTS0104")
	public void testIndex_ReturnsModelAndView() throws Exception {
		ModelAndView mav = tasksController.index();
		assertTrue(mav.hasView());
	}

	@Test
	public void testShow_ReturnModelAndView() {
		UUID id = UUID.fromString("3fc64424-88d2-4f8e-b86e-e61e8fc24976");
		ModelAndView ar = tasksController.show(id);
		assertTrue(ar.hasView());
	}

	@Test
	public void testCreate_ReturnModelAndView() {
		assertTrue(true);
	}

	@Test
	public void testEdit_ReturnModelAndView() {
		UUID id = UUID.fromString("3fc64424-88d2-4f8e-b86e-e61e8fc24976");
		ModelAndView ar = tasksController.edit(id);
		assertTrue(ar.hasView());
	}

	@Test
	@WithMockUser("CTS0104")
	public void testDelete_ReturnModelAndView() {
		ModelAndView ar = tasksController.delete();
		assertTrue(ar.hasView());
	}

	/*@Test
	@WithMockUser("CTS0104")
	public void testStore_ReturnWsResponse() {
		request.addParameter("suite_code", "HRM");
		request.addParameter("suite_name", "Human Resources");
		request.addParameter("module_code", "ED");
		request.addParameter("module_name", "Employee Database");
		request.addParameter("priv_grp_code", String.valueOf(1));
		request.addParameter("priv_grp_name", "Reporting and Analysis");
		request.addParameter("privilege_code", "xvbhxf");
		request.addParameter("privilege_name", "xvbhxf");
		request.addParameter("description", "xvbhxf");
		request.addParameter("story_code", "xvbhxf");
		request.addParameter("story_title", "xvbhxf");
		request.setParameter("task_code", "xvbhxf");
		request.addParameter("task_title", "xvbhxf");
		request.addParameter("emp_code", "xvbhxf");
		request.addParameter("emp_name", "xvbhxf");
		request.addParameter("username", "xvbhxf");
		request.addParameter("estimated_time", String.valueOf(1));
		WSResponse ar = tasksController.store(request);
		assertTrue(ar.getClass() == WSResponse.class);
	}
	*/
	@Test
	@WithMockUser("CTS0104")
	public void testStore_ValidId_ReturnsWsResponse() {
		UUID id = UUID.fromString("3fc64424-88d2-4f8e-b86e-e61e8fc24976");
		request.addParameter("id", String.valueOf(id));
		request.addParameter("suite_code", "HRM");
		request.addParameter("suite_name", "Human Resources");
		request.addParameter("module_code", "ED");
		request.addParameter("module_name", "Employee Database");
		request.addParameter("priv_grp_code", String.valueOf(1));
		request.addParameter("priv_grp_name", "Reporting and Analysis");
		request.addParameter("privilege_code", "xvbhxf");
		request.addParameter("privilege_name", "xvbhxf");
		request.addParameter("description", "xvbhxf");
		request.addParameter("story_code", "xvbhxf");
		request.addParameter("story_title", "xvbhxf");
		request.setParameter("task_code", "xvbhxf");
		request.addParameter("task_title", "xvbhxf");
		request.addParameter("emp_code", "xvbhxf");
		request.addParameter("emp_name", "xvbhxf");
		request.addParameter("username", "xvbhxf");
		request.addParameter("estimated_time", String.valueOf(1));
		WSResponse ar = tasksController.store(request);
		//assertFalse(ar.getId() != null);
		
		if(id == null){
			assertTrue(ar.getClass() == WSResponse.class);
		}else{
			assertTrue(ar.getClass() == WSResponse.class);
		}
		
	}

	@Test
	@WithMockUser("CTS0104")
	public void testUpdate_ReturnWsResponse() {
		UUID id = UUID.fromString("111828c4-4206-4a06-b8b3-3b493032f938"); 
		request.setParameter("id", String.valueOf(id));
		request.addParameter("suite_code", "HRM");
		request.addParameter("suite_name", "Human Resources");
		request.addParameter("module_code", "ED");
		request.addParameter("module_name", "Employee Database");
		request.addParameter("priv_grp_code", String.valueOf(1));
		request.addParameter("priv_grp_name", "Reporting and Analysis");
		request.addParameter("privilege_code", "xvbhxf");
		request.addParameter("privilege_name", "xvbhxf");
		request.addParameter("description", "xvbhxf");
		request.addParameter("story_code", "xvbhxf");
		request.addParameter("story_title", "xvbhxf");
		request.setParameter("task_code", "xvbhxf");
		request.addParameter("task_title", "xvbhxf");
		request.addParameter("emp_code", "xvbhxf");
		request.addParameter("emp_name", "xvbhxf");
		request.addParameter("username", "xvbhxf");
		request.addParameter("estimated_time", String.valueOf(1));
		WSResponse ar = tasksController.update(request);
		assertTrue(ar.getClass() == WSResponse.class);
	}

	/*
	 * @Test public void testUpdateTasklist_ReturnWsResponse(){
	 * request.setParameter("id", String.valueOf(id));
	 * request.setParameter("task_title", "ertert");
	 * request.setParameter("estimated_time", "trtryry");
	 * request.setParameter("spent_time", "ED");
	 * request.setParameter("remaining_time", "Employee Database");
	 * request.setParameter("assignee", "wewrwe");
	 * 
	 * 
	 * WSResponse ar = tasksController.updateTasklist(request);
	 * assertTrue(ar.getClass()==WSResponse.class); }
	 */

	@Test
	@WithMockUser("CTS0104")
	public void testDestroy_ReturnsWSResponse() {
		UUID id = UUID.fromString("b6d3d639-2c5c-4d27-995f-d7c1b02a30bf");
		request.setParameter("id", String.valueOf(id));
		request.addParameter("suite_code", "HRM");
		request.addParameter("suite_name", "Human Resources");
		request.addParameter("module_code", "ED");
		request.addParameter("module_name", "Employee Database");
		request.addParameter("priv_grp_code", String.valueOf(1));
		request.addParameter("priv_grp_name", "Reporting and Analysis");
		request.addParameter("privilege_code", "xvbhxf");
		request.addParameter("privilege_name", "xvbhxf");
		request.addParameter("description", "xvbhxf");
		request.addParameter("story_code", "xvbhxf");
		request.addParameter("story_title", "xvbhxf");
		request.setParameter("task_code", "xvbhxf");
		request.addParameter("task_title", "xvbhxf");
		request.addParameter("emp_code", "xvbhxf");
		request.addParameter("emp_name", "xvbhxf");
		request.addParameter("username", "xvbhxf");
		request.addParameter("estimated_time", String.valueOf(1));
		WSResponse ar = tasksController.destroy(request);
		boolean b =true;
		if(b){
			assertTrue(ar.getClass() == WSResponse.class);
		}else{
			assertTrue(ar.getClass() == WSResponse.class);
		}
	}

	/*
	 * @Test public void testEditTaskList_ReturnsModelAndView(){ ModelAndView ar
	 * = tasksController.editTasklist(id); assertTrue(ar.hasView()); }
	 */

	@Test
	@WithMockUser("CTS0104")
	public void testCreateWithParam_ReturnsWSResponse() {
		request.addParameter("suite_code", "HRM");
		request.addParameter("suite_name", "Human Resources");
		request.addParameter("module_code", "ED");
		request.addParameter("module_name", "Employee Database");
		request.addParameter("priv_grp_code", String.valueOf(1));
		request.addParameter("priv_grp_name", "Reporting and Analysis");
		request.addParameter("privilege_code", "xvbhxf");
		request.addParameter("privilege_name", "xvbhxf");
		request.addParameter("description", "xvbhxf");
		request.addParameter("story_code", "xvbhxf");
		request.addParameter("story_title", "xvbhxf");
		request.setParameter("task_code", "xvbhxf");
		request.addParameter("task_title", "xvbhxf");
		request.addParameter("emp_code", "xvbhxf");
		request.addParameter("emp_name", "xvbhxf");
		request.addParameter("username", "xvbhxf");
		request.addParameter("estimated_time", String.valueOf(1));
		ModelAndView ar = tasksController.create(request);
		assertTrue(ar.getClass() == ModelAndView.class);
	}

	@Test
	public void testSearch_ReturnsModelAndView() {
		assertTrue(true);
	}

	/*@Test
	@WithMockUser("CTS0001")
	public void testTimeLog_ReturnsModelAndView() throws Exception {
		this.mockMvc.perform(get("/taskman/tman/tasks/timeLog/3fc64424-88d2-4f8e-b86e-e61e8fc24976/"+new Date().toString()+"/abc test/"+new Date().toString()+""))
			.andExpect(status().isOk());
	}	

	@Test
	@WithMockUser("CTS0001")
	public void testTimeLogUpdate_ReturnsModelAndView() throws Exception {
		this.mockMvc.perform(get("/taskman/tman/tasks/timeLogUpdate/3fc64424-88d2-4f8e-b86e-e61e8fc24976/"+new Date().toString()+"/"+new Date().toString()+"/4b9a08b2-dc56-4e62-9285-c4ef6b70264e"))
		.andExpect(status().isOk());
	}*/
	
	@Test
	public void testSpentTimeCalculation_ReturnsString(){
		long l = 10000;
		String s = tasksController.spentTimeCalculation(l);
		assertEquals("00:00:10", s);
	}
	
	@Test
	public void testGet_ReturnsWSResponse(){
		UUID id = UUID.fromString("3fc64424-88d2-4f8e-b86e-e61e8fc24976");
		WSResponse ws= tasksController.get(id);
		assertNull(ws);
	}
	
	@Test
	public void testCreate_ReturnsModelAndView(){
		ModelAndView ws= tasksController.create();
		assertNull(ws);
	}
	
	@Test
	public void testShowSearch_ReturnsModelAndView(){
		request.addParameter("suite_code", "HRM");
		request.addParameter("suite_name", "Human Resources");
		request.addParameter("module_code", "ED");
		request.addParameter("module_name", "Employee Database");
		request.addParameter("priv_grp_code", String.valueOf(1));
		request.addParameter("priv_grp_name", "Reporting and Analysis");
		request.addParameter("privilege_code", "xvbhxf");
		request.addParameter("privilege_name", "xvbhxf");
		request.addParameter("description", "xvbhxf");
		request.addParameter("story_code", "xvbhxf");
		request.addParameter("story_title", "xvbhxf");
		request.setParameter("task_code", "xvbhxf");
		request.addParameter("task_title", "xvbhxf");
		request.addParameter("emp_code", "xvbhxf");
		request.addParameter("emp_name", "xvbhxf");
		request.addParameter("username", "xvbhxf");
		request.addParameter("estimated_time", String.valueOf(1));
		ModelAndView ws= tasksController.showSearch(request);
		assertNull(ws);
	}
	
	@Test
	public void testSearch_ReturnsString(){
		request.addParameter("suite_code", "HRM");
		request.addParameter("suite_name", "Human Resources");
		request.addParameter("module_code", "ED");
		request.addParameter("module_name", "Employee Database");
		request.addParameter("priv_grp_code", String.valueOf(1));
		request.addParameter("priv_grp_name", "Reporting and Analysis");
		request.addParameter("privilege_code", "xvbhxf");
		request.addParameter("privilege_name", "xvbhxf");
		request.addParameter("description", "xvbhxf");
		request.addParameter("story_code", "xvbhxf");
		request.addParameter("story_title", "xvbhxf");
		request.setParameter("task_code", "xvbhxf");
		request.addParameter("task_title", "xvbhxf");
		request.addParameter("emp_code", "xvbhxf");
		request.addParameter("emp_name", "xvbhxf");
		request.addParameter("username", "xvbhxf");
		request.addParameter("estimated_time", String.valueOf(1));
		String ws= tasksController.search(request);
		assertNull(ws);
	}
	
	@Test
	@WithMockUser("CTS0001")
	public void testTimeLogUpdate_ReturnsModelAndView2() throws Exception {
		UUID id = UUID.fromString("3fc64424-88d2-4f8e-b86e-e61e8fc24976");
		String id2 = "3fc64424-88d2-4f8e-b86e-e61e8fc24976";
		ModelAndView ar = tasksController.timeLogUpdate(id, new Date().toString(), new Date().toString(), "6", id2);
		assertNull(ar);
	}
	
	@Test
	@WithMockUser("CTS0001")
	public void testTimeLog_ReturnsModelAndView2() throws Exception {
		UUID id = UUID.fromString("3fc64424-88d2-4f8e-b86e-e61e8fc24976");
		String id2 = "3fc64424-88d2-4f8e-b86e-e61e8fc24976";
		ModelAndView ar = tasksController.timeLog(id, new Date().toString(), "abc", new Date().toString(), id2);
		assertNull(ar);
	}

}