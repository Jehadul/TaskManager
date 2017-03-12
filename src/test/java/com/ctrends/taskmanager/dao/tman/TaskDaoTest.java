package com.ctrends.taskmanager.dao.tman;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ctrends.taskmanager.dao.tman.ITasksDao;
import static org.mockito.Mockito.when;
import com.ctrends.taskmanager.dao.tman.TasksDao;
import com.ctrends.taskmanager.model.taskmanage.Module;
import com.ctrends.taskmanager.model.taskmanage.PrivGroup;
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
	
	String suiteCode=null;
	String moduleCode=null;
	
	//@Mock
	private UUID id=UUID.fromString("10462413-c4ad-4608-93c7-08476b6d2b92");

	@Mock
	private List<Tasks> mockTtasksList;
	
	
	@Test
	public void testGetAllDoc(){
		
		List<Tasks> tasksLi=taskDao.getAllDoc();
		assertNotNull(tasksLi);
//		//List<Tasks> tasksLi=taskDao.getAllDoc();
//		mockTtasksList =new ArrayList<>();
//		Tasks mockTasks=Mockito.mock(Tasks.class);
//		mockTtasksList.add(mockTasks);
//		when(taskDao.getAllDoc()).thenReturn(mockTtasksList);
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
	

	@Test
	public void testGetByModule() {
		
		List<PrivGroup> privGrpList = taskDao.getPrivGroup(suiteCode, moduleCode);
		assertNotNull(privGrpList);
	}
	
	
	@Test
	public void testGetDocById() {
		Tasks task = taskDao.getDocById(id);
		assertEquals(new Tasks().getClass(), task.getClass());
	}
	
	@Test
	public void testGetDocs(){
		
		Map<String, String> params=new LinkedHashMap<>();
		List<Tasks> tasksLi=taskDao.getDocs(params);
		assertNotNull(tasksLi);
		
	}
	
	@Test
	public void testInsertDoc(){
		Tasks doc=new Tasks();
		UUID inId = taskDao.insertDoc(doc); 
		assertEquals(id.getClass(), inId.getClass());
	}
	
	@Test
	public void testUpdateDoc(){
		Tasks doc=new Tasks();
		UUID inId = taskDao.updateDoc(doc); 
		assertEquals(id.getClass(), inId.getClass());
	}
	
	@Test
	public void testDeleteDoc(){
		UUID inId = taskDao.deleteDoc(id); 
		assertEquals(id.getClass(), inId.getClass());
	}
	
	@Test
	public void testGetAllPrivGrps(){
		List<PrivGroup> privGrpList = taskDao.getAllPrivGrps();
		assertNotNull(privGrpList);
		
	}
}