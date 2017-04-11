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
import com.ctrends.taskmanager.model.tman.Tasks;
import com.ctrends.taskmanager.model.tman_sprint.SprintManager;
import com.ctrends.taskmanager.model.tman_sprint.SprintManagerDetails;
import com.ctrends.taskmanager.service.task_status.ITaskStatusService;
import com.ctrends.taskmanager.service.tman.ITasksService;
import com.ctrends.taskmanager.service.tman_sprint.ISprintService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
@RequestMapping("/taskman/sprintboard")
public class StoryViewController implements IStoryViewController {

	
	@Autowired
	ISprintService sprintservice;
	
	@Autowired
	ITasksService tasksService;

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
		data.put("sprintboardlist", sprintboardlist);
		
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
	
	

	@RequestMapping(value="storyview/loadsprintmanager", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE) 
	@Override
	public String loadSprintManager(HttpServletRequest request) {
		
		String sprintCode = request.getParameter("sprint_code");
		
		Map<String, Object> data = new HashMap<String, Object>();
		
		List<SprintManagerDetails> sprintManagerDetails = sprintservice.getByIdSprintCode(sprintCode);
		/*
		Map<String, Object> sprintManagerDetails = taskStatusService.getSprintManagerBySprintCode(sprintCode);
		*/
		
		GsonBuilder gson = new GsonBuilder();
		Gson g = gson.create();
		data.put("sprintManagerDetails", g.toJson(sprintManagerDetails));
		System.out.println(g.toJson(sprintManagerDetails)+"Okkkkkkkkkkkkkkkkkkkkkkkkk");
		return g.toJson(sprintManagerDetails);
	}
	
	@RequestMapping(value="storyview/loadtask", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE) 
	@Override
	public String loadStory(HttpServletRequest request) {
		
		String storyCode = request.getParameter("story_code");
		
		Map<String, Object> data = new HashMap<String, Object>();
		
		List<Tasks> taskList = tasksService.getTaskByStoryCode(storyCode);
		
		GsonBuilder gson = new GsonBuilder();
		Gson g = gson.create();
		data.put("taskList", g.toJson(taskList));
		System.out.println(g.toJson(taskList)+"Okkkkkkkkkkkkkkkkkkkkkkkkk");
		return g.toJson(taskList);
	}

	@RequestMapping(value="storyview/loadsprint", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE) 
	@Override
	public String loadSprint(HttpServletRequest request) {
		
		String sprintCode = request.getParameter("sprint_code");
		
		Map<String, Object> data = new HashMap<String, Object>();
		
		SprintManager sprintManager = sprintservice.getSprintBySprintCode(sprintCode);
		/*
		Map<String, Object> sprintManagerDetails = taskStatusService.getSprintManagerBySprintCode(sprintCode);
		*/
		
		GsonBuilder gson = new GsonBuilder();
		Gson g = gson.create();
		data.put("sprintManagerDetails", g.toJson(sprintManager));
		System.out.println(g.toJson(sprintManager)+"Okkkkkkkkkkkkkkkkkkkkkkkkk");
		return g.toJson(sprintManager);
	}
}
