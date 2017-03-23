package com.ctrends.taskmanager.controller.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.ctrends.taskmanager.model.tman.TaskLog;
import com.ctrends.taskmanager.model.tman.Tasks;
import com.ctrends.taskmanager.model.user.User;
import com.ctrends.taskmanager.service.tman.ITasksService;
import com.ctrends.taskmanager.service.user.IUserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@CrossOrigin
@RestController
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	public IUserService userService;
	
	@Autowired
	private ITasksService tasksService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView index() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userService.getUserByUserName(username);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("user", user);
		
		return new ModelAndView("common/home/index", "data", data);

	}
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ModelAndView dashboard() {

		return new ModelAndView("common/dashboard");
	}
	@RequestMapping(value = "/noticeboard", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ModelAndView noticeboard() {
		Map<String, Object> data = new HashMap<String, Object>();
		List<Tasks> tasklist=tasksService.getAllByCurrentUser();
		List<Tasks> currentTasklist=tasksService.getCurrentTaskByCurrentUser();
		TaskLog tasklog = tasksService.getRunningTaskLogByCurrentUser();
		List<String> sp = new ArrayList<>();
		List<String> rem = new ArrayList<>();
		for(int i= 0; i<tasklist.size(); i++){
			long spentSqlTime = tasklist.get(i).getSpentTime();
			long remainingsqlTime = tasklist.get(i).getRemainingTime();
			sp.add(spentTimeCalculation(spentSqlTime));
			rem.add(spentTimeCalculation(remainingsqlTime));		
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
		data.put("currentTasklist", currentTasklist);
		data.put("tasklog", tasklog);
		data.put("spentTime", spentTime);
		data.put("running_taskId", (currentTasklist!=null && currentTasklist.size()>0)?currentTasklist.get(0).getId().toString():"");
		data.put("running_status", (currentTasklist!=null && currentTasklist.size()>0)?"true":"false");
		data.put("sp", sp);
		data.put("rem", rem);
		try {
			data.put("currentSpentTime", (currentTasklist.size()>0)? spentTimeCalculation(currentTasklist.get(0).getSpentTime()):"00:00:00" );
			data.put("currentRemainingTime", (currentTasklist.size()>0)? spentTimeCalculation(currentTasklist.get(0).getRemainingTime()) : "00:00:00");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return new ModelAndView("common/noticeboard", "data", data);

	}
	public String spentTimeCalculation(long millisecons){
		return String.format("%02d:%02d:%02d", 
				TimeUnit.MILLISECONDS.toHours(millisecons),
				TimeUnit.MILLISECONDS.toMinutes(millisecons) -  
				TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisecons)), // The change is in this line
				TimeUnit.MILLISECONDS.toSeconds(millisecons) - 
				TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisecons)));
		
		
	}

	@RequestMapping(value = "/reloadNoticeBoard", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public WSResponse reloadNoticeBoard() {
		Map<String, Object> data = new HashMap<String, Object>();
		List<Tasks> tasklist=tasksService.getAllByCurrentUser();
		List<Tasks> currentTasklist=tasksService.getCurrentTaskByCurrentUser();
		//data.put("tasklist", tasklist);
		data.put("currentTasklist", currentTasklist);
		GsonBuilder gson = new GsonBuilder();
		Gson g = gson.create();
		return new WSResponse("success", "", null, null, null, (currentTasklist.size()>0)?currentTasklist.get(0):new Tasks());

	}


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout) {
		ModelAndView model = new ModelAndView();	
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}
		if (logout != null) {  
			System.out.println("log out.....");
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("common/login");
		
		
		return model;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(@RequestParam(value = "/logout", required = false) String logout) {
		
		System.out.println("log out..2...");
		ModelAndView model = new ModelAndView();
			if (logout != null) {  
				System.out.println("log out.....");
				model.addObject("msg", "You've been logged out successfully.");
			}		
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
