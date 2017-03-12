package com.ctrends.taskmanager.dao.user;
import java.util.List;
import java.util.Map;

import com.ctrends.taskmanager.dao.ICommonDAO;
import com.ctrends.taskmanager.model.user.User;

public interface IUserDAO extends ICommonDAO<User> {
	public User getByUsername(String username);
	public User getByUserName(String userName);
	public User getCurrentUser();
	public String getCurrentUserName();
}
