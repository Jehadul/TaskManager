package com.ctrends.taskmanager.dao.tman_sprint;

import java.util.List;
import java.util.Map;

import com.ctrends.taskmanager.dao.ICommonDAO;
import com.ctrends.taskmanager.model.taskmanage.Module;
import com.ctrends.taskmanager.model.taskmanage.PrivGroup;
import com.ctrends.taskmanager.model.taskmanage.Suite;
import com.ctrends.taskmanager.model.tman_sprint.SprintManager;

public interface ISprintDAO extends ICommonDAO<SprintManager> {
	List<Suite> getAllSuites();
	List<PrivGroup> getAllPrivGrps();
	List<Module> getAllModules();
	List<Module> getBySuit(String suitCode);
	public List<PrivGroup> getPrivGroup(String suiteCode, String modeCode);
	boolean checkUnique(Map<String, Object> param);
}
