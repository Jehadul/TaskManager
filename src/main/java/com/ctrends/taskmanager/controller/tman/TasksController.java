package com.ctrends.taskmanager.controller.tman;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ctrends.taskmanager.bean.WSResponse;

@Repository("tasksController")

@RestController
@RequestMapping("/taskman/tman/tasks")
public class TasksController implements ITasksController {

	@Override
	@RequestMapping(value = "/create", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView index() {
		System.out.println("Hello Reza");
		// TODO Auto-generated method stub
		return new ModelAndView("taskman/tasklist");
	}

	@Override
	public ModelAndView show(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView create() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView edit(UUID id) {
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

	@Override
	public WSResponse get(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WSResponse store(HttpServletRequest request) {
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

}
