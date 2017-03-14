package com.ctrends.taskmanager.controller.tman;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.ctrends.taskmanager.controller.ICommonController;
import com.ctrends.taskmanager.model.tman.Tasks;

public interface ITasksController extends ICommonController<Tasks> {

	public ModelAndView create(HttpServletRequest request);
	public ModelAndView editTasklist(UUID id);
	
}
