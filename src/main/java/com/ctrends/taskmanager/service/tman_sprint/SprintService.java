package com.ctrends.taskmanager.service.tman_sprint;


import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctrends.taskmanager.bean.Utility;
import com.ctrends.taskmanager.dao.tman_sprint.ISprintDAO;
import com.ctrends.taskmanager.model.tman_sprint.SprintManager;
import com.ctrends.taskmanager.model.tman_sprint.SprintManagerDetails;
import com.ctrends.taskmanager.model.user.User;
import com.ctrends.taskmanager.service.user.IUserService;


@Service("sprintService")
public class SprintService implements ISprintService {
	
	@Autowired
	ISprintDAO sprintDao;
	
	@Autowired
	IUserService userService;
	
	@Override
	public Map<String, String> insert(Map<String, String[]> requestMap) {
		
		Map<String, String> data = new HashMap<String, String>();
		User currentUser = userService.getCurrentUser();
		String strid = null;
		UUID id;
		
	/*************************Master data sent from view*******************************/
		
		Map<String,Object> param = new HashMap<String,Object>();
		
		param.put("sprintCode", requestMap.get("sprint_code")[0].toUpperCase());
		
		//boolean rules = sprintDao.validate(param);;
		boolean rules = sprintDao.checkUnique(param);
		
		SprintManager sprint = new SprintManager();
		
		sprint.setSuiteName(requestMap.get("suite_name")[0]);	
		sprint.setModuleName(requestMap.get("module_name")[0]);
		sprint.setPrivilegeName(requestMap.get("priv_grp_name")[0]);
		sprint.setSprintCode(requestMap.get("sprint_code")[0]);
		sprint.setSprintName(requestMap.get("sprint_name")[0]);
		sprint.setSprintGoal(requestMap.get("sprint_goal")[0]);
		sprint.setSprintNumber(Double.parseDouble(requestMap.get("sprint_number")[0]));
		//sprint.setSprintStories(requestMap.get("sprint_stories")[0]);
		//sprint.setSprintStoryCode(requestMap.get("sprint_story_code")[0]);
		sprint.setClientCode(currentUser.getClientCode());
		sprint.setClientName(currentUser.getClientName());
		sprint.setCompanyCode(currentUser.getCompanyCode());
		sprint.setCompanyName(currentUser.getCompanyName());
		sprint.setCreatedByCode(currentUser.getCreatedByCode());
		sprint.setCreatedByName(currentUser.getCreatedByName());
		sprint.setCreatedByCode(currentUser.getEmpCode());
		sprint.setCreatedByName(currentUser.getEmpName());
		sprint.setCreatedByUsername(currentUser.getUsername());
		sprint.setCreatedByEmail(currentUser.getEmail());
		sprint.setCreatedByCompanyCode(currentUser.getCompanyCode());
		sprint.setCreatedByCompanyName(currentUser.getCompanyName());
		sprint.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		
		if (requestMap.get("start_date")[0].equals("")) {			
			sprint.setStartDate(new Date(System.currentTimeMillis()));
		}else{			
			String startDate = requestMap.get("start_date")[0];
			java.util.Date startDateUtil = Utility.stringToDate(startDate);
			java.sql.Date startDateSql = (Date) Utility.fromUtiltoSql(startDateUtil);
			sprint.setStartDate(startDateSql);
		}		
		
		if (requestMap.get("end_date")[0].equals("")) {			
			sprint.setEndDate(new Date(System.currentTimeMillis()));
		}else{			
			String endDate = requestMap.get("end_date")[0];
			java.util.Date endDateUtil = Utility.stringToDate(endDate);
			java.sql.Date endDateSql = (Date) Utility.fromUtiltoSql(endDateUtil);
			sprint.setEndDate(endDateSql);
		}
		sprint.setSprintDescription(requestMap.get("sprint_description")[0]);
		
		/**********************Detail item data sent from view*********************************/

		String[] storyCode			= (String[]) requestMap.get("story_code[]"); 
		String[] storyName 			= (String[]) requestMap.get("story_name[]");
		
		List<SprintManagerDetails> storyDetailsList = new ArrayList<SprintManagerDetails>();
		for(int i = 0; i< storyCode.length; i++){
			SprintManagerDetails stroyDetails = new SprintManagerDetails();
			
			stroyDetails.setSprintStoryCode(storyCode[i]);
			stroyDetails.setSprintStoryName(storyName[i]);
			
			stroyDetails.setCreatedByCode(currentUser.getCreatedByCode());
			stroyDetails.setCreatedByName(currentUser.getCreatedByName());
			stroyDetails.setCreatedByUsername(currentUser.getCreatedByUsername());
			stroyDetails.setCreatedByCode(currentUser.getEmpCode());
			stroyDetails.setCreatedByName(currentUser.getEmpName());
			stroyDetails.setCreatedByUsername(currentUser.getUsername());
			stroyDetails.setCreatedByEmail(currentUser.getEmail());
			stroyDetails.setCreatedByCompanyCode(currentUser.getCompanyCode());
			stroyDetails.setCreatedByCompanyName(currentUser.getCompanyName());
			stroyDetails.setCreatedAt(new Timestamp(System.currentTimeMillis())); 
			
			//stroyDetails.setClientCode(currentUser.getClientCode());
			stroyDetails.setClientName(currentUser.getClientName());
			stroyDetails.setCompanyCode(currentUser.getCompanyCode());
			//stroyDetails.setCompanyName(currentUser.getCompanyName());
			stroyDetails.setUpdatedByCode(currentUser.getEmpCode());            
			stroyDetails.setUpdatedByName(currentUser.getEmpName());
			stroyDetails.setUpdatedByUsername(currentUser.getUsername());
			stroyDetails.setUpdatedByEmail(currentUser.getEmail());
			stroyDetails.setUpdatedByCompanyCode(currentUser.getCompanyCode());
			stroyDetails.setUpdatedByCompanyName(currentUser.getCompanyName());
			//stroyDetails.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
			storyDetailsList.add(i,stroyDetails);	
		}
		sprint.setSteps(storyDetailsList);
		if(rules){
			id = sprintDao.insertDoc(sprint);
			strid = id.toString();
			data.put("id", strid);
		}
		else{
			data.put("id", null);
			
		}

		return data;
		
	}

	/*@Override
	public Map<String, String> insert(Map<String, String[]> requestMap) {
		Map<String, String> data = new HashMap<String,String>();
		SprintManager sprint = new SprintManager();
		
		sprint.setSuiteName(requestMap.get("suite_name")[0]);	
		sprint.setModuleName(requestMap.get("module_name")[0]);
		sprint.setPrivilegeName(requestMap.get("priv_grp_name")[0]);
		sprint.setSprintCode(requestMap.get("sprint_code")[0]);
		sprint.setSprintName(requestMap.get("sprint_name")[0]);
		sprint.setSprintGoal(requestMap.get("sprint_goal")[0]);
		sprint.setSprintNumber(Double.parseDouble(requestMap.get("sprint_number")[0]));
		sprint.setSprintStories(requestMap.get("sprint_stories")[0]);
		sprint.setSprintStoryCode(requestMap.get("sprint_story_code")[0]);
		
		
		if (requestMap.get("start_date")[0].equals("")) {			
			sprint.setStartDate(new Date(System.currentTimeMillis()));
		}else{			
			String startDate = requestMap.get("start_date")[0];
			java.util.Date startDateUtil = Utility.stringToDate(startDate);
			java.sql.Date startDateSql = (Date) Utility.fromUtiltoSql(startDateUtil);
			sprint.setStartDate(startDateSql);
		}
		
		
		if (requestMap.get("end_date")[0].equals("")) {			
			sprint.setEndDate(new Date(System.currentTimeMillis()));
		}else{			
			String endDate = requestMap.get("end_date")[0];
			java.util.Date endDateUtil = Utility.stringToDate(endDate);
			java.sql.Date endDateSql = (Date) Utility.fromUtiltoSql(endDateUtil);
			sprint.setEndDate(endDateSql);
		}
		
		sprint.setSprintDescription(requestMap.get("sprint_description")[0]);
		
		UUID id = sprintDao.insertDoc(sprint);
		
		data.put("id", id.toString());
		return data ;
	}
*/
	@Override
	public List<SprintManager> getAll() {
		List<SprintManager> splist=sprintDao.getAllDoc();
		return splist;
	}


	@Override
	public SprintManager getById(UUID id) {
		// TODO Auto-generated method stub
		return sprintDao.getDocById(id);
	}

/*	@Override
	public Map<String, String> update(Map<String, String[]> requestMap) {
		Map<String, String> data = new HashMap<String, String>();
		User currentUser = userService.getCurrentUser();
		//System.out.println(":::::"+requestMap.get("id")[0]);
		SprintManager sprintManager = sprintDao.getDocById(UUID.fromString(requestMap.get("id")[0]));
		
		sprintManager.setSuiteCode(requestMap.get("suite_code")[0]);
		sprintManager.setSuiteName(requestMap.get("suite_name")[0]);
		sprintManager.setModuleCode(requestMap.get("module_code")[0]);
		sprintManager.setModuleName(requestMap.get("module_name")[0]);
		sprintManager.setPrivGrpCode(Integer.parseInt(requestMap.get("priv_grp_code")[0]));
		sprintManager.setPrivGrpName(requestMap.get("priv_grp_name")[0]);

		sprintManager.setSprintCode(requestMap.get("sprint_code")[0]);
		sprintManager.setSprintName(requestMap.get("sprint_name")[0]);
		sprintManager.setSprintGoal(requestMap.get("sprint_goal")[0]);
		sprintManager.setSprintNumber(Double.parseDouble(requestMap.get("sprint_number")[0]));
		sprintManager.setSprintStories(requestMap.get("sprint_stories")[0]);	
		sprintManager.setSprintStoryCode(requestMap.get("sprint_story_code")[0]);
		sprintManager.setSprintDescription(requestMap.get("sprint_description")[0]);
		
		java.sql.Date startDate = (Date) Utility.toSqlDate(requestMap.get("start_date")[0]);
		sprintManager.setStartDate(startDate);
		
		java.sql.Date endDate = (Date) Utility.toSqlDate(requestMap.get("end_date")[0]);
		sprintManager.setEndDate(endDate);
		
		sprintManager.setClientCode(currentUser.getClientCode());
		sprintManager.setClientName(currentUser.getClientName());
		sprintManager.setCompanyCode(currentUser.getCompanyCode());
		sprintManager.setCompanyName(currentUser.getCompanyName());
		sprintManager.setUpdatedByCode(currentUser.getEmpCode());            
		sprintManager.setUpdatedByName(currentUser.getEmpName());
		sprintManager.setUpdatedByUsername(currentUser.getUsername());
		sprintManager.setUpdatedByEmail(currentUser.getEmail());
		sprintManager.setUpdatedByCompanyCode(currentUser.getCompanyCode());
		sprintManager.setUpdatedByCompanyName(currentUser.getCompanyName());
		sprintManager.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		
		UUID id = sprintDao.updateDoc(sprintManager);
		data.put("id", id.toString());
		return data;

	}*/
	
	
	@Override
	public Map<String, String> update(Map<String, String[]> requestMap) {
		
		Map<String, String> data = new HashMap<String, String>();
		User currentUser = userService.getCurrentUser();
		String strid = null;
		
	/*************************Master data sent from view*******************************/
		
		Map<String,Object> param = new HashMap<String,Object>();
		
		param.put("sprintCode", requestMap.get("sprint_code")[0].toUpperCase());
		
		//boolean rules = sprintDao.validate(param);;
		boolean rules = sprintDao.checkUnique(param);
		SprintManager sprint = sprintDao.getDocById(UUID.fromString(requestMap.get("id")[0]));
		sprint.setSuiteCode(requestMap.get("suite_code")[0]);
		sprint.setSuiteName(requestMap.get("suite_name")[0]);
		sprint.setModuleCode(requestMap.get("module_code")[0]);
		sprint.setModuleName(requestMap.get("module_name")[0]);
		sprint.setPrivGrpCode(Integer.parseInt(requestMap.get("priv_grp_code")[0]));
		sprint.setPrivilegeName(requestMap.get("priv_grp_name")[0]);
		sprint.setSprintCode(requestMap.get("sprint_code")[0]);
		sprint.setSprintName(requestMap.get("sprint_name")[0]);
		sprint.setSprintGoal(requestMap.get("sprint_goal")[0]);
		sprint.setSprintNumber(Double.parseDouble(requestMap.get("sprint_number")[0]));
		//sprint.setSprintStories(requestMap.get("sprint_stories")[0]);
		//sprint.setSprintStoryCode(requestMap.get("sprint_story_code")[0]);
		
		if (requestMap.get("start_date")[0].equals("")) {			
			sprint.setStartDate(new Date(System.currentTimeMillis()));
		}else{			
			String startDate = requestMap.get("start_date")[0];
			java.util.Date startDateUtil = Utility.stringToDate(startDate);
			java.sql.Date startDateSql = (Date) Utility.fromUtiltoSql(startDateUtil);
			sprint.setStartDate(startDateSql);
		}		
		
		if (requestMap.get("end_date")[0].equals("")) {			
			sprint.setEndDate(new Date(System.currentTimeMillis()));
		}else{			
			String endDate = requestMap.get("end_date")[0];
			java.util.Date endDateUtil = Utility.stringToDate(endDate);
			java.sql.Date endDateSql = (Date) Utility.fromUtiltoSql(endDateUtil);
			sprint.setEndDate(endDateSql);
		}
		sprint.setSprintDescription(requestMap.get("sprint_description")[0]);
		
		UUID id = sprintDao.updateDoc(sprint);
		
		/**********************Detail item data sent from view*********************************/

		String[] storyCode			= (String[]) requestMap.get("story_code[]"); 
		String[] storyName 			= (String[]) requestMap.get("story_name[]");
		
		List<SprintManagerDetails> storyDetailsList = new ArrayList<SprintManagerDetails>();
		for(int i = 0; i< storyCode.length; i++){
			SprintManagerDetails stroyDetails = new SprintManagerDetails();
			
			stroyDetails.setSprintStoryCode(storyCode[i]);
			stroyDetails.setSprintStoryName(storyName[i]);
			
			stroyDetails.setSprintCode(requestMap.get("sprint_code")[0]);
			stroyDetails.setCreatedByCode(currentUser.getCreatedByCode());
			stroyDetails.setCreatedByName(currentUser.getCreatedByName());
			stroyDetails.setCreatedByUsername(currentUser.getCreatedByUsername());
			stroyDetails.setCreatedByCode(currentUser.getEmpCode());
			stroyDetails.setCreatedByName(currentUser.getEmpName());
			stroyDetails.setCreatedByUsername(currentUser.getUsername());
			stroyDetails.setCreatedByEmail(currentUser.getEmail());
			stroyDetails.setCreatedByCompanyCode(currentUser.getCompanyCode());
			stroyDetails.setCreatedByCompanyName(currentUser.getCompanyName());
			stroyDetails.setCreatedAt(new Timestamp(System.currentTimeMillis())); 
			
			//stroyDetails.setClientCode(currentUser.getClientCode());
			stroyDetails.setClientName(currentUser.getClientName());
			stroyDetails.setCompanyCode(currentUser.getCompanyCode());
			//stroyDetails.setCompanyName(currentUser.getCompanyName());
			stroyDetails.setUpdatedByCode(currentUser.getEmpCode());            
			stroyDetails.setUpdatedByName(currentUser.getEmpName());
			stroyDetails.setUpdatedByUsername(currentUser.getUsername());
			stroyDetails.setUpdatedByEmail(currentUser.getEmail());
			stroyDetails.setUpdatedByCompanyCode(currentUser.getCompanyCode());
			stroyDetails.setUpdatedByCompanyName(currentUser.getCompanyName());
			//stroyDetails.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
			storyDetailsList.add(i,stroyDetails);	
		}
		sprint.setSteps(storyDetailsList);
		
		String [] ids = new String[sprint.getSteps().size()];				/*wf.getSteps() will give a replica of details table*/
		List<SprintManagerDetails> sprintDetailList = sprint.getSteps();
		
		for(int i = 0; i < sprint.getSteps().size(); i++){
			
			SprintManagerDetails detailSprint = sprintDetailList.get(i);
			sprintDao.updateDetail(detailSprint);
			 ids[i]= detailSprint.getId().toString();                    				/*set each steps id into ids[i]*/
		}

		List<SprintManagerDetails> listSprintDetail = sprintDao.findBySprintCode(sprint.getSprintCode());
		
		for(int i = 0 ;i < listSprintDetail.size(); i++){
			String detailId = "";
			boolean key = true;
			for (int j = 0; j < ids.length; j++) {
				
				detailId = listSprintDetail.get(i).getId().toString();
				
				if ( detailId.equals(ids[j])) {
					key = false;
				} 
			}
			
			if(key){
				sprintDao.deleteDoc(UUID.fromString(detailId));
			}
			
		
		}
		data.put("id", id.toString());
		return data;
=======
>>>>>>> 1d5b0fc4db057c2c5d63145f4dc676fbdae7ec13
	}

	@Override
	public UUID delete(Map<String, String[]> requestMap) {
		UUID id = sprintDao.deleteDoc(UUID.fromString(requestMap.get("id")[0]));
		return id;
	}

}
