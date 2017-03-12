package com.ctrends.taskmanager.service.user;

import com.ctrends.taskmanager.model.user.User;
import com.ctrends.taskmanager.service.ICommonService;

public interface IUserService extends ICommonService<User> {

	User getUserByUserName(String username);

}
