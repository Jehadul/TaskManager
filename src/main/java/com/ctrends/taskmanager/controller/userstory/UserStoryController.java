package com.ctrends.taskmanager.controller.userstory;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ctrends.taskmanager.bean.WSResponse;
import com.ctrends.taskmanager.dao.tman.ITasksDao;
import com.ctrends.taskmanager.model.taskmanage.Module;
import com.ctrends.taskmanager.model.taskmanage.PrivGroup;
import com.ctrends.taskmanager.model.taskmanage.Privilege;
import com.ctrends.taskmanager.model.taskmanage.Suite;
import com.ctrends.taskmanager.model.user.User;
import com.ctrends.taskmanager.model.userstory.UserStory;
import com.ctrends.taskmanager.service.userstory.IUserStoryService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
@RequestMapping("/taskman/userstory/story")
public class UserStoryController implements IUserStoryController {
	
	@Autowired
	ITasksDao taskDao;
	
	@Autowired
	IUserStoryService userStoryService;

	@Override
	public ModelAndView index() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Override
	public ModelAndView show(@PathVariable(value = "id") UUID id) {
		
		UserStory userStory = userStoryService.getById(id);
		
		Map<String, Object> map = new HashMap<>();

		map.put("mode", "doc");
		map.put("userStory", userStory);
		GsonBuilder gson = new GsonBuilder();
		Gson g = gson.create();
		// map.put("quesJson", g.toJson(q));
		return new ModelAndView("userstory/show", "map", map);
	}

	@Override
	public WSResponse get(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value="/create", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public ModelAndView create(HttpServletRequest request) {
		Map<String, Object> data = new HashMap<String, Object>();
		String suiteCode = request.getParameter("suite_code");
		String moduleCode = request.getParameter("module_code");
		String privGroupCode = request.getParameter("priv_grp_code");
		String privCode = request.getParameter("privilege_code");
		String priority = request.getParameter("priority_code");

		List<Suite> suiteLi = taskDao.getAllSuites();

		Map<String, String> suiteCodes = new LinkedHashMap<String, String>();

		if (suiteCode == null || suiteCode.isEmpty()) {
			suiteCodes.put("-1", "--SELECT--");
		}

		for (int i = 0; i < suiteLi.size(); i++) {
			suiteCodes.put(suiteLi.get(i).getSuiteCode(), suiteLi.get(i).getSuiteShortName());
		}

		List<Module> modules = taskDao.getBySuit(suiteCode);

		Map<String, String> moduleCodes = new LinkedHashMap<String, String>();

		if (moduleCode == null || moduleCode.isEmpty()) {
			moduleCodes.put("-1", "--SELECT--");
		}

		for (int i = 0; i < modules.size(); i++) {
			moduleCodes.put(modules.get(i).getModCode(), modules.get(i).getModShortName());
		}

		List<PrivGroup> privGrpLi = taskDao.getPrivGroup(suiteCode, moduleCode);

		Map<String, String> privgroups = new LinkedHashMap<String, String>(); 

		if (privGroupCode == null || privGroupCode.isEmpty()) {
			privGroupCode=String.valueOf(0);
			privgroups.put("-1", "--SELECT--");
		}

		for (int i = 0; i < privGrpLi.size(); i++) {
			privgroups.put(String.valueOf(privGrpLi.get(i).getPrivGrpCode()), privGrpLi.get(i).getPrivGrpName());
		}
		
		
		
		List<Privilege> privilegeLi = taskDao.getBy(suiteCode, moduleCode, Integer.parseInt(privGroupCode));
		
		Map<String, String> privileges = new LinkedHashMap<String, String>();
		
		if (privCode == null || privCode.isEmpty()) {
			privileges.put("-1", "--SELECT--");
		}
		
		for (int i = 0; i < privilegeLi.size(); i++) {
			privileges.put(privilegeLi.get(i).getPrivCode(), privilegeLi.get(i).getPrivName());
		}
		
		
		Map<String, String> priorities = new LinkedHashMap<String, String>();
		
		if (priority == null || priority.isEmpty()) {
			priorities.put("-1", "--SELECT--");
		}
		priorities.put("1", "High");
		priorities.put("2", "Medium");
		priorities.put("3", "Low");
		
		Map<String, String> storyStatus = new LinkedHashMap<String, String>();
		
		storyStatus.put("1", "To Do");
		storyStatus.put("2", "In Progress");
		storyStatus.put("3", "To Be Reviewed");
		storyStatus.put("4", "QA");
		storyStatus.put("5", "Done");

		data.put("suiteCodes", suiteCodes);
		data.put("moduleCodes", moduleCodes);
		data.put("privgroups", privgroups);
		data.put("privileges", privileges);
		data.put("priorities", priorities);
		data.put("storyStatus", storyStatus);
		data.put("suiteCode", suiteCode);
		data.put("privGroupCode", privGroupCode); 
		data.put("moduleCode", moduleCode);
		data.put("privCode", privCode);
		data.put("priority", priority);
		return new ModelAndView("userstory/create", "data", data);
	}

	@RequestMapping(value = "/store", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public WSResponse store(HttpServletRequest request) {
		Map<String, String[]> userStory = request.getParameterMap();

		Map<String, String> data = userStoryService.insert(userStory);
		
		if(data.get("id") == null){
			return new WSResponse("error", "Story Code Must be Unique",null , null, null, data);
		}
		else{
			UUID id = UUID.fromString(data.get("id"));
			return new WSResponse("success", "Saved successfully", id, null, data.get("mode"), data);
			
		}

		
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Override
	public ModelAndView edit(@PathVariable(value = "id") UUID id) {
		
		Map<String, Object> map = new HashMap<String, Object>();

		List<Suite> suiteLi = taskDao.getAllSuites();

		Map<String, String> suiteCodes = new HashMap<String, String>();
		for (int i = 0; i < suiteLi.size(); i++) {
			suiteCodes.put(suiteLi.get(i).getSuiteCode(), suiteLi.get(i).getSuiteShortName());
		}

		List<Module> moduleLi = taskDao.getAllModules();

		Map<String, String> moduleCodes = new HashMap<String, String>();
		for (int i = 0; i < moduleLi.size(); i++) {
			moduleCodes.put(moduleLi.get(i).getModCode(), moduleLi.get(i).getModShortName());
		}

		List<PrivGroup> privGrpLi = taskDao.getAllPrivGrps();

		Map<Integer, String> privGrpCodes = new HashMap<Integer, String>();
		for (int i = 0; i < privGrpLi.size(); i++) {
			privGrpCodes.put(privGrpLi.get(i).getPrivGrpCode(), privGrpLi.get(i).getPrivGrpName());
		}
		
		Map<String, String> priorities = new LinkedHashMap<String, String>();
		
		priorities.put("1", "High");
		priorities.put("2", "Medium");
		priorities.put("3", "Low");
		
		
		Map<String, String> storyStatus = new LinkedHashMap<String, String>();
		
		storyStatus.put("1", "To Do");
		storyStatus.put("2", "In Progress");
		storyStatus.put("3", "To Be Reviewed");
		storyStatus.put("4", "QA");
		storyStatus.put("5", "Done");

		UserStory userStory = userStoryService.getById(id);

		map.put("mode", "doc");
		map.put("userStory", userStory);
		map.put("suiteCodes", suiteCodes);
		map.put("moduleCodes", moduleCodes);
		map.put("privGrpCodes", privGrpCodes);
		map.put("priorities", priorities);
		
		

		GsonBuilder gson = new GsonBuilder();
		Gson g = gson.create();

		return new ModelAndView("userstory/edit", "map", map);

	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public WSResponse update(HttpServletRequest request) {
		
		Map<String, String[]> userStory = request.getParameterMap();

		Map<String, String> data = userStoryService.update(userStory);

		return new WSResponse("success", "Updated successfully", UUID.fromString(data.get("id")), null,
				data.get("mode"), data);
	}


	@RequestMapping(value = "/destroy", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public WSResponse destroy(HttpServletRequest request) {
		Map<String, String[]> userStory = request.getParameterMap();
		UUID id = userStoryService.delete(userStory);
		return new WSResponse("success", "User Story deleted successfully", id, null, "doc", null);
	}


	@Override
	public ModelAndView create() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@RequestMapping(value = "/storylist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ModelAndView delete() {

		Map<String, Object> data = new HashMap<String, Object>();
		List<UserStory> userStoryLi = userStoryService.getAll();
		data.put("userStoryLi", userStoryLi);
		/*
		 * GsonBuilder gson = new GsonBuilder(); Gson g = gson.create();
		 */
		return new ModelAndView("userstory/storylist", "data", data);
	}
	
	
	
	@RequestMapping(value = "/searchstory", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView showSearch(@Context HttpServletRequest request) {
		
		
		String actionTypeCode = request.getParameter("action_type_code");
		Map<String, Object> data = new HashMap<String, Object>();
		
		System.out.println("actionTypeCode::"+actionTypeCode);
		data.put("action_type_code", actionTypeCode);
		return new ModelAndView("userstory/searchstory", "data", data);
	}
	
	
	@RequestMapping(value = "/storySearch", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String search(@Context HttpServletRequest request) {
		Map<String, String> searchingKey = new HashMap<String, String>();
		System.out.println("Hello");
		// if user input is null than convart it into empty String
		if(request.getParameter("story_code")==null){
			searchingKey.put("userStoryCode", "");
		}else{
			searchingKey.put("userStoryCode", request.getParameter("story_code"));
		}
		
		if(request.getParameter("story_name")==null){
			searchingKey.put("userStoryTitle", "");
		}else{
			searchingKey.put("userStoryTitle", request.getParameter("story_name"));
		}

		System.out.println("story_code::"+request.getParameter("story_code"));
		List<UserStory> data = userStoryService.find(searchingKey);
		//jeson convert
		GsonBuilder gBuilder = new GsonBuilder();
		Gson gson = gBuilder.create();
		
		System.out.println(":::"+gson.toJson(data));
		return gson.toJson(data);
	}


}
