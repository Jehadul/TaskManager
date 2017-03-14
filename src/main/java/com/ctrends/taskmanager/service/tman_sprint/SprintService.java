package com.ctrends.taskmanager.service.tman_sprint;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.stereotype.Service;

import com.ctrends.taskmanager.bean.Utility;
import com.ctrends.taskmanager.dao.tman_sprint.ISprintDAO;
import com.ctrends.taskmanager.model.tman_sprint.SprintManager;


@Service("sprintService")
public class SprintService implements ISprintService {
	
	@Autowired
	ISprintDAO sprintDao;

	@Override
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

	@Override
	public List<SprintManager> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SprintManager getById(UUID id) {
		// TODO Auto-generated method stub
		return sprintDao.getDocById(id);
	}

	@Override
	public Map<String, String> update(Map<String, String[]> requestMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UUID delete(Map<String, String[]> requestMap) {
		// TODO Auto-generated method stub
		return null;
	}

}
