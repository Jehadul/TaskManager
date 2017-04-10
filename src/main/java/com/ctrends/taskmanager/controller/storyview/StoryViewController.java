package com.ctrends.taskmanager.controller.storyview;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ctrends.taskmanager.bean.WSResponse;
import com.ctrends.taskmanager.model.tman_sprint.SprintManager;
import com.ctrends.taskmanager.service.tman_sprint.ISprintService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
@RequestMapping("/taskman/sprintboard")
public class StoryViewController implements IStoryViewController {
	
	@Autowired
	ISprintService sprintservice;

	@RequestMapping(value = "/storyview", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public ModelAndView create(HttpServletRequest request){
		
		Map<String, Object> data = new HashMap<String, Object>();
		List<SprintManager> sprintboardlist = sprintservice.getAll();
		Map<String, String> sprintCodes = new HashMap<String, String>();
		
		String sprintCode = request.getParameter("sprint_code");
		
		
		for (int i = 0; i < sprintboardlist.size(); i++) {
			sprintCodes.put(sprintboardlist.get(i).getSprintCode(), sprintboardlist.get(i).getSprintName());
		}
		
		GsonBuilder gson = new GsonBuilder();
		Gson g = gson.create();

		data.put("sprintCodes", sprintCodes);
		data.put("sprintCode", sprintCode);
		
		return new ModelAndView("storyview/storyview", "data", data);
		
	}

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

	@Override
	public ModelAndView create() {
		// TODO Auto-generated method stub
		return null;
	}

}
