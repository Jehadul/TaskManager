package com.ctrends.taskmanager.service.user;

import java.util.List;
import java.util.Map;

import com.ctrends.taskmanager.model.user.User;
import com.ctrends.taskmanager.service.ICommonService;

public interface IUserService extends ICommonService<User> {

	User getUserByUserName(String username);
	User getCurrentUser();
	List<User> find(Map<String, String> searchingKey);

}
