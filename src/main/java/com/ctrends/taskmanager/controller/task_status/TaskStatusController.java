package com.ctrends.taskmanager.controller.task_status;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.util.SystemOutLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ctrends.taskmanager.bean.WSResponse;
import com.ctrends.taskmanager.dao.userstory.IUserStoryDAO;
import com.ctrends.taskmanager.model.tman.Tasks;
import com.ctrends.taskmanager.model.tman_sprint.SprintManager;
import com.ctrends.taskmanager.model.tman_sprint.SprintManagerDetails;
import com.ctrends.taskmanager.service.task_status.ITaskStatusService;
import com.ctrends.taskmanager.service.tman_sprint.ISprintService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
@RequestMapping("/taskman/sprintboard/ui")
public class TaskStatusController implements ITaskStatusController {
	
	
	@Autowired
	ITaskStatusService taskStatusService;
	
	@Autowired
	ISprintService sprintService;
	
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
	public ModelAndView create() {
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

	@RequestMapping(value="/loaddedsprintmanagerdetail", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE) 
	@Override
	public String loaddetask(HttpServletRequest request) {
		
		String sprintCode = request.getParameter("sprint_code");
		
		Map<String, Object> data = new HashMap<String, Object>();
		
		Map<String, Object> sprintManagerDetails = taskStatusService.getSprintManagerBySprintCode(sprintCode);
		
		
		GsonBuilder gson = new GsonBuilder();
		Gson g = gson.create();
		data.put("sprintManagerDetails", g.toJson(sprintManagerDetails));
		
		return g.toJson(sprintManagerDetails);
	
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public ModelAndView create(HttpServletRequest request) {
		String sprintCode = request.getParameter("sprint_code");
		
		//String storyTitle = request.getParameter("story_title");
		
		Map<String, Object> data = new HashMap<String, Object>();
		
		List<SprintManager> SprintList = sprintService.getAllSprint();
		
		Map<String, String> sprintCodes = new HashMap<String, String>();
		
		for (int i = 0; i < SprintList.size(); i++) {
			sprintCodes.put(SprintList.get(i).getSprintCode(), SprintList.get(i).getSprintName());
		}
		

		if (sprintCode == null || sprintCode.isEmpty()) {
			sprintCodes.put("-1", "--SELECT--");
		}
		
		/*List<SprintManager> userStory = taskStatusService.getSprintByStoryTitle(storyTytle);*/
		
		data.put("sprintCodes", sprintCodes);
		data.put("sprintCode", sprintCode);
		return new ModelAndView("storystatus/sprintBoardUI", "data", data);
		
	}

}
