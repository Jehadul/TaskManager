package com.ctrends.taskmanager.controller.tman_sprint;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ctrends.taskmanager.bean.WSResponse;
import com.ctrends.taskmanager.dao.tman_sprint.ISprintDAO;
import com.ctrends.taskmanager.model.tman_sprint.SprintManager;
import com.ctrends.taskmanager.model.tman_sprint.SprintManagerDetails;
import com.ctrends.taskmanager.service.tman_sprint.ISprintService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
@RequestMapping("/taskman/tman/sprint")
public class SprintController implements ISprintController {

	@Autowired
	ISprintService sprintService;

	@Autowired
	ISprintDAO sprintDao;

	@Override
	public ModelAndView index() {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Override
	public ModelAndView show(@PathVariable(value = "id") UUID id) {
		SprintManager sprint = sprintService.getById(id);
		List<SprintManagerDetails> sprintDetails = sprintService.getByIdSprintCode(sprint.getSprintCode());
		Map<String, Object> map = new HashMap<>();
		System.out.println(sprintDetails.get(0).getSprintStoryName());

		map.put("mode", "doc");
		map.put("sprint", sprint);
		map.put("sprintDetails", sprintDetails);
		GsonBuilder gson = new GsonBuilder();
		Gson g = gson.create();
		// map.put("quesJson", g.toJson(q));
		return new ModelAndView("sprintmanager/show", "map", map);

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

	@RequestMapping(value = "/store", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public WSResponse store(HttpServletRequest request) {
		Map<String, String[]> sprint = request.getParameterMap();

		Map<String, String> data = sprintService.insert(sprint);

		if (data.get("id") == null) {
			return new WSResponse("error", "Sprint Code Must be Unique", null, null, null, null);
		} else {
			UUID id = UUID.fromString(data.get("id"));
			return new WSResponse("success", "Saved Successfully", id, null, data.get("mode"), data);

		}
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Override
	public ModelAndView edit(@PathVariable(value = "id") UUID id) {
		Map<String, Object> map = new HashMap<String, Object>();

		SprintManager sprintManager = sprintService.getById(id);

		List<SprintManagerDetails> sprintDetails = sprintService.getByIdSprintCode(sprintManager.getSprintCode());

		map.put("sprintManager", sprintManager);
		map.put("sprintDetails", sprintDetails);

		GsonBuilder gson = new GsonBuilder();
		Gson g = gson.create();

		return new ModelAndView("sprintmanager/edit", "map", map);
	}

	@RequestMapping(value = "/destroy", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public WSResponse destroy(HttpServletRequest request) {
		Map<String, String[]> sprint = request.getParameterMap();
		UUID id = sprintService.delete(sprint);
		return new WSResponse("success", "Sprint deleted successfully", id, null, "doc", null);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Override
	public ModelAndView delete() {

		Map<String, Object> data = new HashMap<String, Object>();
		List<SprintManager> sprintManagerList = sprintService.getAll();
		data.put("sprintManagerList", sprintManagerList);

		return new ModelAndView("sprintmanager/delete", "data", data);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public WSResponse update(HttpServletRequest request) {
		Map<String, String[]> sprintManager = request.getParameterMap();
		System.out.println(sprintManager.get("id")[0] + "::::::::::::::::::::::::");
		Map<String, String> data = sprintService.update(sprintManager);

		return new WSResponse("success", "Updated Successfully", UUID.fromString(data.get("id")), null,
				data.get("mode"), data);

	}

	@RequestMapping(value = "/create", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public ModelAndView create(HttpServletRequest request) {

		return new ModelAndView("sprintmanager/create");
	}

	@RequestMapping(value = "/sprintlist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Override
	public ModelAndView sprintList() {
		Map<String, Object> data = new HashMap<String, Object>();
		List<SprintManager> sprintlist = sprintService.getAll();

		GsonBuilder gson = new GsonBuilder();
		Gson g = gson.create();

		data.put("sprintlist", sprintlist);

		System.out.println(g.toJson(sprintlist));

		return new ModelAndView("sprintmanager/sprintlist", "data", data);
	}

	@RequestMapping(value = "/searchsprint", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public ModelAndView showSearch(HttpServletRequest request) {
		String sprintCode = request.getParameter("sprint_code"); 
		String actionTypeCode = request.getParameter("action_type_code");
		Map<String, Object> data = new HashMap<String, Object>();
		Map<String, String> sprintCodes = new HashMap<String, String>();
		List<SprintManagerDetails> sprintManagerDetails = sprintService.getAllSprintDetailsDoc();
		
		for(int i =0; i<sprintManagerDetails.size(); i++){
			sprintCodes.put(String.valueOf(sprintManagerDetails.get(i).getSprintCode()), sprintManagerDetails.get(i).getSprintName());
		}
		data.put("sprintCodes", sprintCodes);
		data.put("sprintCode", sprintCode);
		data.put("action_type_code", actionTypeCode);
		return new ModelAndView("sprintmanager/searchsprint","data",data);
	}

	@RequestMapping(value = "/sprintstorysearch", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public String search(HttpServletRequest request) {
		Map<String, String> searchingKey = new HashMap<String, String>();
		System.out.println("Hello");
		// if user input is null than convart it into empty String
		
		if(request.getParameter("sprint_code")==null){
			searchingKey.put("sprintCode", "");
		}else{
			searchingKey.put("sprintCode", request.getParameter("sprint_code"));
		}
		
		if(request.getParameter("story_code")==null){
			searchingKey.put("sprintStoryCode", "");
		}else{
			searchingKey.put("sprintStoryCode", request.getParameter("story_code"));
		}
		
		if(request.getParameter("story_name")==null){
			searchingKey.put("sprintStoryName", "");
		}else{
			searchingKey.put("sprintStoryName", request.getParameter("story_name"));
		}

		System.out.println("story_code::"+request.getParameter("story_code"));
		List<SprintManagerDetails> data = sprintService.find(searchingKey);
		GsonBuilder gBuilder = new GsonBuilder();
		Gson gson = gBuilder.create();
		
		System.out.println(":::"+gson.toJson(data));
		return gson.toJson(data);
	}

	@ResponseBody
	@Override
	public ModelAndView showChart(@PathVariable(value = "id") UUID id) {
		Map<String, Object> sprintViewDetails = sprintService.getBySprintId(id);
		GsonBuilder gson = new GsonBuilder();
		Gson g = gson.create();
		System.out.println(g.toJson(sprintViewDetails));
		return new ModelAndView("sprintmanager/burndownchart", "map", g.toJson(sprintViewDetails));
	}

	// old burndown chart
	@RequestMapping(value = "/spentchart/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView showSpentChart(@PathVariable(value = "id") UUID id) {
		Map<String, Object> map = sprintService.getSprintSpentChartData(id);
		GsonBuilder gson = new GsonBuilder();
		Gson g = gson.create();
		System.out.println(g.toJson(map));
		return new ModelAndView("sprintmanager/spentchart", "map", g.toJson(map));
	}
	
	@RequestMapping(value = "/burndownchart/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ModelAndView showBurnDownChartData(@PathVariable(value = "id") UUID id) {
		Map<String, Object> map = sprintService.getDocByBurnDownChartData(id);
		GsonBuilder gson = new GsonBuilder();
		Gson g = gson.create();
		System.out.println(g.toJson(map));
		return new ModelAndView("sprintmanager/burndownchart", "map", g.toJson(map));
	}
	
}