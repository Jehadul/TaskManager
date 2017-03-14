package com.ctrends.taskmanager.controller.tman;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;

import com.ctrends.taskmanager.bean.WSResponse;
import com.ctrends.taskmanager.controller.tman.ITasksController;
import com.ctrends.taskmanager.dao.tman.ITasksDao;
import com.ctrends.taskmanager.model.taskmanage.Module;
import com.ctrends.taskmanager.model.taskmanage.PrivGroup;
import com.ctrends.taskmanager.model.taskmanage.Suite;
import com.ctrends.taskmanager.model.tman.Tasks;

import com.ctrends.taskmanager.service.tman.ITasksService;

import com.google.gson.GsonBuilder;

@RestController
@RequestMapping("/taskman/tman/tasks")
public class TasksController implements ITasksController {

	@Autowired
	ITasksDao taskDao;

	@Autowired
	private ITasksService tasksService;

	@RequestMapping(value = "/tasklist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ModelAndView index() {

		Map<String, Object> data = new HashMap<String, Object>();
		List<Tasks> tasklist = tasksService.getAll();

		GsonBuilder gson = new GsonBuilder();
		Gson g = gson.create();

		data.put("tasklist", tasklist);

		return new ModelAndView("taskman/tasklist", "data", data);
	}

	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Override
	public ModelAndView show(@PathVariable(value = "id") UUID id) {
		Tasks tasks = tasksService.getById(id);
		System.out.println("show page");
		Map<String, Object> map = new HashMap<>();

		map.put("mode", "doc");
		map.put("tasks", tasks);
		GsonBuilder gson = new GsonBuilder();
		Gson g = gson.create();
		// map.put("quesJson", g.toJson(q));
		return new ModelAndView("taskman/show", "map", map);

	}

	@Override
	public ModelAndView create() {
		return null;
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

		Tasks tasks = tasksService.getById(id);

		map.put("mode", "doc");
		map.put("tasks", tasks);
		map.put("suiteCodes", suiteCodes);
		map.put("moduleCodes", moduleCodes);
		map.put("privGrpCodes", privGrpCodes);

		GsonBuilder gson = new GsonBuilder();
		Gson g = gson.create();

		return new ModelAndView("taskman/edit", "map", map);

	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ModelAndView delete() {

		Map<String, Object> data = new HashMap<String, Object>();
		List<Tasks> taskli = tasksService.getAll();
		data.put("taskli", taskli);
		/*
		 * GsonBuilder gson = new GsonBuilder(); Gson g = gson.create();
		 */
		return new ModelAndView("taskman/delete", "data", data);
	}

	@Override
	public WSResponse get(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value = "/store", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public WSResponse store(HttpServletRequest request) {
		Map<String, String[]> tasks = request.getParameterMap();

		Map<String, String> data = tasksService.insert(tasks);

		return new WSResponse("success", "Submitted Successfully", UUID.fromString(data.get("id")), null,
				data.get("mode"), data);

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public WSResponse update(HttpServletRequest request) {
		Map<String, String[]> tasks = request.getParameterMap();

		Map<String, String> data = tasksService.update(tasks);

		return new WSResponse("success", "Submitted Successfully", UUID.fromString(data.get("id")), null,
				data.get("mode"), data);

	}

	@RequestMapping(value = "/updateTasklist", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public WSResponse updateTasklist(HttpServletRequest request) {
		Map<String, String[]> tasks = request.getParameterMap();

		Map<String, String> data = tasksService.updateTasklist(tasks);

		return new WSResponse("success", "Submitted Successfully", UUID.fromString(data.get("id")), null,
				data.get("mode"), data);

	}

	@RequestMapping(value = "/destroy", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public WSResponse destroy(HttpServletRequest request) {
		Map<String, String[]> tasks = request.getParameterMap();
		UUID id = tasksService.delete(tasks);
		return new WSResponse("success", "task deleted successfully", id, null, "doc", null);
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public ModelAndView create(HttpServletRequest request) {

		Map<String, Object> data = new HashMap<String, Object>();
		String suiteCode = request.getParameter("suite_code");
		String moduleCode = request.getParameter("module_code");
		String privGroupCode = request.getParameter("priv_grp_code");

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
			privgroups.put("-1", "--SELECT--");
		}

		for (int i = 0; i < privGrpLi.size(); i++) {
			privgroups.put(String.valueOf(privGrpLi.get(i).getPrivGrpCode()), privGrpLi.get(i).getPrivGrpName());
		}

		data.put("suiteCodes", suiteCodes);
		data.put("moduleCodes", moduleCodes);
		data.put("privgroups", privgroups);
		data.put("suiteCode", suiteCode);
		data.put("privGroupCode", privGroupCode);
		data.put("moduleCode", moduleCode);

		return new ModelAndView("taskman/create", "data", data);

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

	@RequestMapping(value = "/editTasklist/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Override
	public ModelAndView editTasklist(@PathVariable(value = "id") UUID id) {
		Map<String, Object> map = new HashMap<>();

		Tasks tasks = tasksService.getById(id);

		map.put("mode", "doc");
		map.put("tasks", tasks);
		GsonBuilder gson = new GsonBuilder();
		Gson g = gson.create();

		return new ModelAndView("taskman/editTasklist", "map", map);

	}

	@RequestMapping(value = "/timeLog/{id}/{strTime}/{title}/{day}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ModelAndView timeLog(@PathVariable(value = "id") UUID id,
			@PathVariable(value = "strTime") String strTime,
			@PathVariable(value = "title") String title,
			@PathVariable(value = "day") String today) {
		Map<String, String> map = new HashMap<>();
		map.put("id", id.toString());
		map.put("startTime", strTime);
		map.put("taskTitle", title);		
		map.put("today", today);
		
		Map<String, String> data = tasksService.insertTaskLog(map);
		return null;
	}
	@RequestMapping(value = "/timeLogUpdate/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ModelAndView timeLogUpdate(@PathVariable(value = "id") UUID id) {
		Map<String, String> map = new HashMap<>();
		map.put("id", id.toString());
		Map<String, String> data = tasksService.updateTimeLog(map);
		return null;
	}

}