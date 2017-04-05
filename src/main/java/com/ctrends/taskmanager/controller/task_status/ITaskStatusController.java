package com.ctrends.taskmanager.controller.task_status;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.ctrends.taskmanager.bean.WSResponse;
import com.ctrends.taskmanager.controller.ICommonController;
import com.ctrends.taskmanager.model.task_status.TaskDetails;

public interface ITaskStatusController extends ICommonController<TaskDetails> {
	public String loaddetask(HttpServletRequest request);
	ModelAndView create(HttpServletRequest request);
	WSResponse manageselection(HttpServletRequest request);
	
}
