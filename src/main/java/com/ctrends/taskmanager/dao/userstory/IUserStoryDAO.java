package com.ctrends.taskmanager.dao.userstory;

import java.util.List;
import java.util.Map;

import com.ctrends.taskmanager.dao.ICommonDAO;
import com.ctrends.taskmanager.model.taskmanage.Module;
import com.ctrends.taskmanager.model.taskmanage.PrivGroup;
import com.ctrends.taskmanager.model.taskmanage.Privilege;
import com.ctrends.taskmanager.model.taskmanage.Suite;
import com.ctrends.taskmanager.model.userstory.UserStory;

public interface IUserStoryDAO extends ICommonDAO<UserStory> {

	boolean checkUnique(Map<String, String> requestMap);
}
