package com.ctrends.taskmanager.dao.userstory;

import java.util.List;

import com.ctrends.taskmanager.dao.ICommonDAO;
import com.ctrends.taskmanager.model.taskmanage.Module;
import com.ctrends.taskmanager.model.taskmanage.PrivGroup;
import com.ctrends.taskmanager.model.taskmanage.Suite;
import com.ctrends.taskmanager.model.userstory.UserStory;

public interface IUserStoryDAO extends ICommonDAO<UserStory> {

	List<Module> getBySuit(String suitCode);

	List<Suite> getAllSuites();

	List<Module> getAllModules();

	List<PrivGroup> getAllPrivGrps();

	List<PrivGroup> getPrivGroup(String suiteCode, String modeCode);

}
