package com.ctrends.taskmanager.controller.task_status;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.ctrends.taskmanager.bean.WSResponse;
import com.ctrends.taskmanager.controller.ICommonController;
import com.ctrends.taskmanager.model.task_status.TaskDetails;

public interface ITaskStatusController extends ICommonController<TaskDetails> {
	public String loaddetask(HttpServletRequest request);
	ModelAndView create(HttpServletRequest request);
	WSResponse manageselection(HttpServletRequest request);
	String taskStatus(@PathVariable( value="id") UUID id,@PathVariable( value="status") String status);
	
}
