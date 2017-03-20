package com.ctrends.taskmanager.service.userstory;

import java.util.List;
import java.util.Map;

import com.ctrends.taskmanager.model.user.User;
import com.ctrends.taskmanager.model.userstory.UserStory;
import com.ctrends.taskmanager.service.ICommonService;

public interface IUserStoryService extends ICommonService<UserStory>{
	List<UserStory> find(Map<String, String> searchingKey);
}
