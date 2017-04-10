package com.ctrends.taskmanager.controller.tman;

import java.util.ArrayList;
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
import com.ctrends.taskmanager.model.tman.TaskLog;
import com.ctrends.taskmanager.model.tman.Tasks;
import com.ctrends.taskmanager.service.tman.ITasksService;
import com.ctrends.taskmanager.service.user.IUserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
@RequestMapping("/taskman/tman/tasks")
public class TasksController implements ITasksController {

	@Autowired
	ITasksDao taskDao;

	@Autowired
	private ITasksService tasksService;
	
	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/tasklist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ModelAndView index() {

		Map<String, Object> data = new HashMap<String, Object>();
		List<Tasks> tasklist = tasksService.getAll();
		List<String> sp = new ArrayList<>();
		List<String> rem = new ArrayList<>();
		TaskLog tasklog = tasksService.getRunningTaskLogByCurrentUser();
		GsonBuilder gson = new GsonBuilder();
		Gson g = gson.create();
		for(int i= 0; i<tasklist.size(); i++){
			long spentSqlTime = tasklist.get(i).getSpentTime();
			double remainingsqlTime = tasklist.get(i).getRemainingTime();
			sp.add(spentTimeCalculation(spentSqlTime));
			rem.add(String.valueOf(remainingsqlTime));		
		}
		
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
		data.put("sp", sp);
		data.put("rem", rem);
		// System.out.println(taskloglist.get(0).getTaskId()+":::::::::::::running
		// taskId::::::::::::::");
		return new ModelAndView("taskman/tasklist", "data", data);
	}
	
	public String spentTimeCalculation(long millisecons){
		return String.format("%02d:%02d:%02d", 
				TimeUnit.MILLISECONDS.toHours(millisecons),
				TimeUnit.MILLISECONDS.toMinutes(millisecons) -  
				TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisecons)), // The change is in this line
				TimeUnit.MILLISECONDS.toSeconds(millisecons) - 
				TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisecons)));
		
		
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
		Map<String, String> taskStatus = new LinkedHashMap<String, String>();
		
		taskStatus.put("1", "To Do");
		taskStatus.put("2", "In Progress");
		taskStatus.put("3", "To Be Review");
		taskStatus.put("4", "Reviewed");
		
		
		Tasks tasks = tasksService.getById(id);
		map.put("taskStatus", taskStatus);
		map.put("mode", "doc");
		map.put("tasks", tasks);

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
		
		Map<String, String> taskStatus = new LinkedHashMap<String, String>();
		
		taskStatus.put("1", "To Do");
		taskStatus.put("2", "In Progress");
		taskStatus.put("3", "To Be Review");
		taskStatus.put("4", "Reviewed");
		data.put("taskStatus", taskStatus);
		return new ModelAndView("taskman/create", "data", data);

	}


	@RequestMapping(value = "/timeLog/{id}/{strTime}/{title}/{day}/{sprintId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ModelAndView timeLog(@PathVariable(value = "id") UUID id, @PathVariable(value = "strTime") String strTime,
			@PathVariable(value = "title") String title, @PathVariable(value = "day") String today,
			@PathVariable(value = "sprintId") String sprintId) {
		Map<String, String> map = new HashMap<>();
		map.put("id", id.toString());
		map.put("startTime", strTime);
		map.put("taskTitle", title);
		map.put("today", today);
		map.put("sprintId", sprintId);
		Map<String, String> data = tasksService.insertTaskLog(map);
		return null;
	}

	@RequestMapping(value = "/timeLogUpdate/{id}/{stopTime}/{day}/{remaininghours}/{sprintId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ModelAndView timeLogUpdate(@PathVariable(value = "id") UUID id,
			@PathVariable(value = "stopTime") String stopTime,
			@PathVariable(value = "day") String day,
			@PathVariable(value = "remaininghours") String remaininghours,
			@PathVariable(value = "sprintId") String sprintId) {
		Map<String, String> map = new HashMap<>();
		map.put("id", id.toString());
		map.put("stopTime", stopTime);
		map.put("day", day);
		map.put("remaininghours", remaininghours);
		map.put("sprintId", sprintId);
		Map<String, String> data = tasksService.updateTimeLog(map);
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
	


}