package com.ctrends.taskmanager.controller.sprintBoard;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/taskman/sprintboard/ui")
public class SprintBoardController{

	
	@RequestMapping(value = "/create", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView create(HttpServletRequest request) {

		//Map<String, Object> data = new HashMap<String, Object>();
		return new ModelAndView("sprintBoard/sprintBoardUI");

	}

}
