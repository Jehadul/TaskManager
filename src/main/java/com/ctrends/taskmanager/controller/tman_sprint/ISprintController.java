package com.ctrends.taskmanager.controller.tman_sprint;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.ctrends.taskmanager.controller.ICommonController;
import com.ctrends.taskmanager.model.taskmanage.Module;
import com.ctrends.taskmanager.model.taskmanage.PrivGroup;
import com.ctrends.taskmanager.model.taskmanage.Suite;
import com.ctrends.taskmanager.model.tman_sprint.SprintManager;

public interface ISprintController extends ICommonController<SprintManager> {
	public ModelAndView create(HttpServletRequest request);
	

}
