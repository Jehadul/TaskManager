package com.ctrends.taskmanager.controller.userstory;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.ctrends.taskmanager.controller.ICommonController;
import com.ctrends.taskmanager.model.userstory.UserStory;

public interface IUserStoryController extends ICommonController<UserStory> {

	ModelAndView create(HttpServletRequest request);

	String storyCodeSeq(HttpServletRequest request);

}
