package com.ctrends.taskmanager.controller.storyview;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.ctrends.taskmanager.controller.ICommonController;
import com.ctrends.taskmanager.model.tman_sprint.SprintManager;

public interface IStoryViewController extends ICommonController<SprintManager>{

	ModelAndView create(HttpServletRequest request);
	String loadSprintManager(HttpServletRequest request);
	String loadStory(HttpServletRequest request);

	
	

}
