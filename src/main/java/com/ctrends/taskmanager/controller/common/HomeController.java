package com.ctrends.taskmanager.controller.common;

import javax.servlet.http.HttpServletRequest;

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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@CrossOrigin
@RestController
@RequestMapping("/")
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView index() {
		System.out.println("homeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		// TODO:
		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		return new ModelAndView("common/home/index");

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
