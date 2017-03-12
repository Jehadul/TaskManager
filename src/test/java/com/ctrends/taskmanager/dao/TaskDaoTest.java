package com.ctrends.taskmanager.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.UUID;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ctrends.taskmanager.dao.tman.ITasksDao;
import com.ctrends.taskmanager.model.taskmanage.Module;
import com.ctrends.taskmanager.model.taskmanage.Suite;
import com.ctrends.taskmanager.model.tman.Tasks;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-database.xml", 
									"/spring-dispatcher-servlet.xml", 
									"/spring-security.xml" })
public class TaskDaoTest {

	@Autowired
	ITasksDao taskDao;
	
	@Autowired
	private SessionFactory sessionfactory;
	
	public UUID id;
	String suiteCode="FIN4";
	
	
	@Test
	public void testGetAllDoc() {
		
		List<Tasks> tasksLi=taskDao.getAllDoc();
		assertNotNull(tasksLi);
	}
	
	
	@Test
	public void testGetAllSuites() {
		
		List<Suite> suiteLi=taskDao.getAllSuites();
		assertNotNull(suiteLi);
		
	}
	
	
	@Test
	public void testGetAllModules() {
	
		List<Module> moduleLi = taskDao.getAllModules();
		assertNotNull(moduleLi);
	}
	
	
	@Test
	public void testGetBySuit() {
		
		List<Module> modList = taskDao.getBySuit(suiteCode);
		assertNotNull(modList);
	}
}
