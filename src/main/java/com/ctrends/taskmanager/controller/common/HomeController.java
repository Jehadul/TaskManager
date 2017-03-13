package com.ctrends.taskmanager.controller.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ctrends.taskmanager.bean.WSResponse;
import com.ctrends.taskmanager.model.tman.Tasks;
import com.ctrends.taskmanager.model.user.User;
import com.ctrends.taskmanager.service.tman.ITasksService;
import com.ctrends.taskmanager.service.user.IUserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@CrossOrigin
@RestController
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	public IUserService userService;
	
	@Autowired
	private ITasksService tasksService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView index() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userService.getUserByUserName(username);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("user", user);
		
		return new ModelAndView("common/home/index", "data", data);

	}
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ModelAndView dashboard() {

		return new ModelAndView("common/dashboard");
	}
	@RequestMapping(value = "/noticeboard", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ModelAndView noticeboard() {
		Map<String, Object> data = new HashMap<String, Object>();
		List<Tasks> tasklist=tasksService.getAll();
		data.put("tasklist", tasklist);
		return new ModelAndView("common/noticeboard", "data", data);

	}



	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "/logout", required = false) String logout) {
		ModelAndView model = new ModelAndView();
		model.setViewName("common/login");
		return model;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout() {
		ModelAndView model = new ModelAndView();
		model.addObject("msg", "You've been logged out successfully.");
		model.setViewName("common/login");
		return model;
	}

	// for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();

		model.setViewName("common/403");
		return model;

	}

	@RequestMapping(value = "/loadpref", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String loadpref(HttpServletRequest request) {

		GsonBuilder gson = new GsonBuilder();
		Gson g = gson.create();
		return g.toJson("");
	}

	@RequestMapping(value = "/tcodesearch", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public WSResponse tcodesearch(HttpServletRequest request) {
		
			return new WSResponse("success", "T Code is invalid or unavailable.", null, null, null, null);
		
	}

}
