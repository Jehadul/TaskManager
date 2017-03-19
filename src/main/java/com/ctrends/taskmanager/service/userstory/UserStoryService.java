package com.ctrends.taskmanager.service.userstory;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctrends.taskmanager.dao.tman.ITasksDao;
import com.ctrends.taskmanager.dao.userstory.IUserStoryDAO;
import com.ctrends.taskmanager.model.tman.Tasks;
import com.ctrends.taskmanager.model.user.User;
import com.ctrends.taskmanager.model.userstory.UserStory;
import com.ctrends.taskmanager.service.user.IUserService;

@Service("userStoryService")
public class UserStoryService implements IUserStoryService {

	@Autowired
	IUserStoryDAO userStoryDAO;
	
	@Autowired
	IUserService userService;
	
	@Override
	public Map<String, String> insert(Map<String, String[]> requestMap) {
		Map<String, String> data = new HashMap<String,String>();
		
		UserStory userStory=new UserStory();
		User currentUser = userService.getCurrentUser();
		userStory.setSuiteCode(requestMap.get("suite_code")[0]);
		userStory.setSuiteName(requestMap.get("suite_name")[0]);
		userStory.setModuleCode(requestMap.get("module_code")[0]);
		userStory.setModuleName(requestMap.get("module_name")[0]);
		userStory.setPrivGrpCode(Integer.parseInt(requestMap.get("priv_grp_code")[0]));
		userStory.setPrivGrpName(requestMap.get("priv_grp_name")[0]);
		userStory.setPrivilegeCode(requestMap.get("privilege_code")[0]);
		userStory.setPrivilegeName(requestMap.get("privilege_name")[0]);
		userStory.setDescription(requestMap.get("description")[0]);
		userStory.setAcceptanceCriteria(requestMap.get("acceptance_criteria")[0]);
		userStory.setBusinessValue(requestMap.get("business_value")[0]);
		userStory.setUserStoryCode(requestMap.get("user_story_code")[0]);
	    userStory.setUserStoryTitle(requestMap.get("user_story_title")[0]);
	    userStory.setSize(Integer.parseInt(requestMap.get("size")[0]));
	    userStory.setPriorityCode(Integer.parseInt(requestMap.get("priority_code")[0]));
	    userStory.setPriority(requestMap.get("priority")[0]);
	    userStory.setStoryOrder(requestMap.get("story_order")[0]);
		
		userStory.setClientCode(currentUser.getClientCode());
		userStory.setClientName(currentUser.getClientName());
		userStory.setCompanyCode(currentUser.getCompanyCode());
		userStory.setCompanyName(currentUser.getCompanyName());
		userStory.setCreatedByCode(currentUser.getCreatedByCode());
		userStory.setCreatedByName(currentUser.getCreatedByName());
		userStory.setCreatedByCode(currentUser.getEmpCode());
		userStory.setCreatedByName(currentUser.getEmpName());
		userStory.setCreatedByUsername(currentUser.getUsername());
		userStory.setCreatedByEmail(currentUser.getEmail());
		userStory.setCreatedByCompanyCode(currentUser.getCompanyCode());
		userStory.setCreatedByCompanyName(currentUser.getCompanyName());
		userStory.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		
		UUID id = userStoryDAO.insertDoc(userStory);
		data.put("id", id.toString());
		return data ;
	}


	@Override
	public List<UserStory> getAll() {
		 List<UserStory> userStoryLi=userStoryDAO.getAllDoc();
		return userStoryLi;
	}

	@Override
	public UserStory getById(UUID id) {
		return userStoryDAO.getDocById(id);
		
	}

	@Override
	public Map<String, String> update(Map<String, String[]> requestMap) {
		Map<String, String> data = new HashMap<String, String>();
		User currentUser = userService.getCurrentUser();
		
		UserStory userStory = userStoryDAO.getDocById(UUID.fromString(requestMap.get("id")[0]));
		
		userStory.setSuiteCode(requestMap.get("suite_code")[0]);
		userStory.setSuiteName(requestMap.get("suite_name")[0]);
		userStory.setModuleCode(requestMap.get("module_code")[0]);
		userStory.setModuleName(requestMap.get("module_name")[0]);
		userStory.setPrivGrpCode(Integer.parseInt(requestMap.get("priv_grp_code")[0]));
		userStory.setPrivGrpName(requestMap.get("priv_grp_name")[0]);
		userStory.setPrivilegeCode(requestMap.get("privilege_code")[0]);
		userStory.setPrivilegeName(requestMap.get("privilege_name")[0]);
		userStory.setDescription(requestMap.get("description")[0]);
		userStory.setAcceptanceCriteria(requestMap.get("acceptance_criteria")[0]);
		userStory.setBusinessValue(requestMap.get("business_value")[0]);
		userStory.setUserStoryCode(requestMap.get("user_story_code")[0]);
	    userStory.setUserStoryTitle(requestMap.get("user_story_title")[0]);
	    userStory.setSize(Integer.parseInt(requestMap.get("size")[0]));
	    userStory.setPriority(requestMap.get("priority")[0]);
	    userStory.setStoryOrder(requestMap.get("story_order")[0]);
		//userStory.setStoryCode(requestMap.get("story_code")[0]);
	    
		//userStory.setTaskTitle(requestMap.get("task_title")[0]);
		//userStory.setEstimatedTime(Double.parseDouble(requestMap.get("estimated_time")[0]));
		//userStory.setAsignee(requestMap.get("assignee")[0]);	
		
		
		userStory.setClientCode(currentUser.getClientCode());
		userStory.setClientName(currentUser.getClientName());
		userStory.setCompanyCode(currentUser.getCompanyCode());
		userStory.setCompanyName(currentUser.getCompanyName());
		userStory.setUpdatedByCode(currentUser.getEmpCode());            
		userStory.setUpdatedByName(currentUser.getEmpName());
		userStory.setUpdatedByUsername(currentUser.getUsername());
		userStory.setUpdatedByEmail(currentUser.getEmail());
		userStory.setUpdatedByCompanyCode(currentUser.getCompanyCode());
		userStory.setUpdatedByCompanyName(currentUser.getCompanyName());
		userStory.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		
		userStory.setUpdatedByCode(currentUser.getUpdatedByCode());
		userStory.setUpdatedByName(currentUser.getUpdatedByName());
		userStory.setUpdatedByCompanyCode(currentUser.getCompanyCode());
		userStory.setUpdatedByCompanyName(currentUser.getCompanyName());
		userStory.setUpdatedByEmail(currentUser.getEmail());
		userStory.setUpdatedByUsername(currentUser.getUsername());
		
		userStory.setClientCode(currentUser.getClientCode());
		userStory.setClientName(currentUser.getClientName());
		userStory.setCompanyCode(currentUser.getCompanyCode());
		userStory.setCompanyName(currentUser.getCompanyName());
		userStory.setUpdatedByCode(currentUser.getEmpCode());            
		userStory.setUpdatedByName(currentUser.getEmpName());
		userStory.setUpdatedByUsername(currentUser.getUsername());
		userStory.setUpdatedByEmail(currentUser.getEmail());
		userStory.setUpdatedByCompanyCode(currentUser.getCompanyCode());
		userStory.setUpdatedByCompanyName(currentUser.getCompanyName());
		userStory.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		
		userStory.setUpdatedByCode(currentUser.getUpdatedByCode());
		userStory.setUpdatedByName(currentUser.getUpdatedByName());
		userStory.setUpdatedByCompanyCode(currentUser.getCompanyCode());
		userStory.setUpdatedByCompanyName(currentUser.getCompanyName());
		userStory.setUpdatedByEmail(currentUser.getEmail());
		userStory.setUpdatedByUsername(currentUser.getUsername());
		
		UUID id = userStoryDAO.updateDoc(userStory);
		data.put("id", id.toString());
		return data;
	}

	@Override
	public UUID delete(Map<String, String[]> requestMap) {
		UUID id = userStoryDAO.deleteDoc(UUID.fromString(requestMap.get("id")[0]));
		return id;
	}


	@Override
	public List<UserStory> find(Map<String, String> searchingKey) {
		// TODO Auto-generated method stub
		return userStoryDAO.getDocs(searchingKey);
	}

}
