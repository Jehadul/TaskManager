package com.ctrends.taskmanager.controller.tman;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

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
import com.ctrends.taskmanager.dao.tman.ITasksDao;
import com.ctrends.taskmanager.model.taskmanage.Module;
import com.ctrends.taskmanager.model.taskmanage.PrivGroup;
import com.ctrends.taskmanager.model.taskmanage.Suite;
import com.ctrends.taskmanager.model.tman.TaskLog;
import com.ctrends.taskmanager.model.tman.Tasks;
import com.ctrends.taskmanager.service.tman.ITasksService;
import com.google.gson.Gson;
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
		TaskLog tasklog = tasksService.getRunningTaskLogByCurrentUser();
		GsonBuilder gson = new GsonBuilder();
		Gson g = gson.create();
		long spentTimes= 0;
		if(tasklog != null && tasklog.getStartTime() !=null){
			spentTimes = System.currentTimeMillis()-tasklog.getStartTime().getTime();
		}
		String spentTime = String.format("%02d:%02d:%02d", 
				TimeUnit.MILLISECONDS.toHours(spentTimes),
				TimeUnit.MILLISECONDS.toMinutes(spentTimes) -  
				TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(spentTimes)), // The change is in this line
				TimeUnit.MILLISECONDS.toSeconds(spentTimes) - 
				TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(spentTimes)));
		data.put("tasklist", tasklist);
		data.put("tasklog", tasklog);
		data.put("spentTime", spentTime);
		// System.out.println(taskloglist.get(0).getTaskId()+":::::::::::::running
		// taskId::::::::::::::");
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

		if(data.get("id") == null){
			return new WSResponse("error", "Task Code Must be Unique",null , null, null, data);
		}
		else{
			UUID id = UUID.fromString(data.get("id"));
			return new WSResponse("success", "Saved Successfully", id, null, data.get("mode"), data);
			
		}

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public WSResponse update(HttpServletRequest request) {
		Map<String, String[]> tasks = request.getParameterMap();

		Map<String, String> data = tasksService.update(tasks);

		return new WSResponse("success", "Updated Successfully", UUID.fromString(data.get("id")), null,
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

	@RequestMapping(value = "/timeLog/{id}/{strTime}/{title}/{day}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ModelAndView timeLog(@PathVariable(value = "id") UUID id, @PathVariable(value = "strTime") String strTime,
			@PathVariable(value = "title") String title, @PathVariable(value = "day") String today) {
		Map<String, String> map = new HashMap<>();
		map.put("id", id.toString());
		map.put("startTime", strTime);
		map.put("taskTitle", title);
		map.put("today", today);

		Map<String, String> data = tasksService.insertTaskLog(map);
		return null;
	}

	@RequestMapping(value = "/timeLogUpdate/{id}/{stopTime}/{day}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ModelAndView timeLogUpdate(@PathVariable(value = "id") UUID id,
			@PathVariable(value = "stopTime") String stopTime,
			@PathVariable(value = "day") String day) {
		Map<String, String> map = new HashMap<>();
		map.put("id", id.toString());
		map.put("stopTime", stopTime);
		map.put("day", day);
		Map<String, String> data = tasksService.updateTimeLog(map);
		return null;
	}

}