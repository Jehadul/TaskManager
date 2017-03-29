package com.ctrends.taskmanager.controller.tman_sprint;


import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.ctrends.taskmanager.controller.ICommonController;
import com.ctrends.taskmanager.model.tman_sprint.SprintManager;

public interface ISprintController extends ICommonController<SprintManager> {
	public ModelAndView create(HttpServletRequest request);
	
	public ModelAndView sprintList();
	public ModelAndView delete();

	ModelAndView showChart(UUID id);
	

}