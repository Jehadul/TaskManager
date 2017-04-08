package com.ctrends.taskmanager.dao.tman_sprint;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ctrends.taskmanager.model.taskmanage.Module;
import com.ctrends.taskmanager.model.taskmanage.PrivGroup;
import com.ctrends.taskmanager.model.taskmanage.Suite;
import com.ctrends.taskmanager.model.tman_sprint.SprintManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-database.xml", 
									"/spring-dispatcher-servlet.xml", 
									"/spring-security.xml" })
public class SprintDAOTest {
	
	@Autowired 
	ISprintDAO sprintDao;
	
	//@Mock
	private UUID id=UUID.fromString("3c4617ee-d3c7-4c94-bc84-f2333a6cc057"); 
		
	String suiteCode=null;
	String moduleCode=null;
		
/*	@Test
	public void testInsertDoc_ReturnUUID(){
		SprintManager doc=new SprintManager();
		UUID inId = sprintDao.insertDoc(doc); 
		assertEquals(id.getClass(), inId.getClass());
	}
	*/
	
	@Test
    public void testInsertDoc_ReturnUUID(){
        SprintManager sprint=new SprintManager();
        sprint.setSprintCode("TESTCODE");
        sprint.setSprintName("TestSprintName");
        sprint.setSprintGoal("TestSprintGoal");
        sprint.setSprintNumber(1850);
        
        
        UUID inId = sprintDao.insertDoc(sprint);
        assertEquals(id.getClass(), inId.getClass());
    }
	
	@Test
	public void testGetAllSuites_ReturnList() {
		
		List<Suite> suiteLi=sprintDao.getAllSuites();
		assertNotNull(suiteLi);
		
	}
	
	@Test
	public void testGetBySuit_ReturnList() {
		
		List<Module> modList = sprintDao.getBySuit(suiteCode);
		assertNotNull(modList);
	}
	
	@Test
	public void testGetByModule_ReturnList() {
		
		List<PrivGroup> privGrpList = sprintDao.getPrivGroup(suiteCode, moduleCode);
		assertNotNull(privGrpList);
	}
	
	@Test
	public void testGetDocById_ReturnSprint() {
		SprintManager spman = sprintDao.getDocById(id);
		assertNotNull(spman);
	}
	
	@Test
	public void testDeleteDoc_ReturnUUID(){
		UUID inId = sprintDao.deleteDoc(id); 
		assertEquals(id.getClass(), inId.getClass());
	}
	
	@Test
	public void testGetDocByBurnDownChart_ReturnMap(){
		Map<String, Object> map = sprintDao.getDocByBurnDownChart(id); 
		assertTrue(!map.isEmpty());
		
	}
	
	@Test
	public void testGetSpentChartDoc_ReturnMap(){
		Map<String, Object> map = sprintDao.getSpentChartDoc(id); 
		assertTrue(!map.isEmpty());
		
	}
	
	

}
