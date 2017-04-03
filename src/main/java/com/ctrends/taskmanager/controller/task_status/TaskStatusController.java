package com.ctrends.taskmanager.controller.task_status;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ctrends.taskmanager.bean.WSResponse;

@RestController
@RequestMapping("/taskman/sprintboard/ui")
public class TaskStatusController implements ITaskStatusController {

	@Override
	public ModelAndView index() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView show(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WSResponse get(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@RequestMapping(value = "/create", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public ModelAndView create() {
		return new ModelAndView("storystatus/sprintBoardUI1");
	}

	@Override
	public WSResponse store(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView edit(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WSResponse update(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WSResponse destroy(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView showSearch(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String search(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
