package com.ctrends.taskmanager.controller.report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ctrends.taskmanager.bean.Utility;
import com.ctrends.taskmanager.model.dailysummary.DailySummary;
import com.ctrends.taskmanager.model.tman.TaskLog;
import com.ctrends.taskmanager.model.tman.TaskReportView;
import com.ctrends.taskmanager.model.tman.Tasks;
import com.ctrends.taskmanager.service.report.ITaskReportService;
import com.ctrends.taskmanager.service.report.TaskReportService;
import com.ctrends.taskmanager.service.user.IUserService;

@Controller
@RequestMapping("/taskman/report")
public class TaskReportController {

	@Autowired
	IUserService userService;

	@Autowired
	ITaskReportService taskReportService;
	

	@RequestMapping(value = "/tasklogreport", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView tasklogreport(HttpServletRequest request) {
		Map<String, Object> data = new HashMap<String, Object>();
		List<Tasks> tasklogList = taskReportService.getAll();

		Map<String, String> companyCodes = new HashMap<String, String>();
		String companyCode = request.getParameter("company_code");

		for (int i = 0; i < tasklogList.size(); i++) {
			companyCodes.put(tasklogList.get(i).getCompanyCode(), tasklogList.get(i).getCompanyName());
		}

		data.put("companyCodes", companyCodes);
		data.put("companyCode", companyCode);
		return new ModelAndView("report/userdailyreport", "data", data);
	}
	/*
	 * @RequestMapping(value = "/generateuserwisereport", method =
	 * RequestMethod.GET) public ModelAndView
	 * generateUserWiseReport(ModelAndView modelAndView, HttpServletRequest
	 * request) {
	 * 
	 * String companyCode = request.getParameter("company_code"); String empCode
	 * = request.getParameter("emp_code"); String empName =
	 * request.getParameter("emp_name"); String username =
	 * request.getParameter("username");
	 * 
	 * java.util.Date startDate =
	 * Utility.stringToDate(request.getParameter("start_date"));
	 * 
	 * System.out.println(companyCode + "companyCode" + empCode + "empCode" +
	 * empName + "empName" + username + "username" + startDate + "startDate");
	 * 
	 * Map<String, Object> parameterDate = new HashMap<String, Object>();
	 * Map<String, Object> parameterMap = new HashMap<String, Object>();
	 * parameterMap.put("companyCode", companyCode); parameterMap.put("empCode",
	 * empCode); parameterMap.put("empName", empName);
	 * parameterMap.put("username", username); parameterDate.put("startDate",
	 * startDate);
	 * 
	 * List<Tasks> tlist = taskReportService.findAllTasks(parameterMap);
	 * List<TaskLog> tLogList = taskReportService.findAllTaskLog(parameterMap);
	 * 
	 * List<TaskLog> newLogList = new ArrayList<>();
	 * 
	 * if (tlist != null) {
	 * 
	 * for (int j = 0; j < tlist.size(); j++) {
	 * 
	 * Tasks tempTask = tlist.get(j);
	 * 
	 * for (int i = 0; i < tLogList.size(); i++) {
	 * 
	 * TaskLog tempLog = tLogList.get(i);
	 * 
	 * if (tempTask.getId().toString().equals(tempLog.getTaskId().toString()) &&
	 * tempLog.getStartDate().equals(startDate)) { newLogList.add(tempLog); }
	 * 
	 * }
	 * 
	 * } }
	 * 
	 * List<String> timeList = new ArrayList<>(); List<String> timeRemain = new
	 * ArrayList<>();
	 * 
	 * if (tlist != null) { for (int i = 0; i < tlist.size(); i++) {
	 * timeList.add(millisToDigitalTimeFormat(tlist.get(i).getSpentTime()));
	 * timeRemain.add(millisToDigitalTimeFormat((long)
	 * tlist.get(i).getRemainingTime())); }
	 * 
	 * } if (newLogList.size() == 0) { tlist = null; timeList = null; timeRemain
	 * = null; }
	 * 
	 * Map<String, Object> data = new HashMap<String, Object>();
	 * data.put("tlist", tlist); data.put("tLogList", newLogList);
	 * data.put("timeList", timeList); data.put("timeRemain", timeRemain);
	 * data.put("date", request.getParameter("start_date")); data.put("empCode",
	 * request.getParameter("emp_code")); data.put("empName",
	 * request.getParameter("emp_name"));
	 * 
	 * return new ModelAndView("report/userwisedailyreport", "data", data);
	 * 
	 * }
	 * 
	 * public String millisToDigitalTimeFormat(long millis) { long second =
	 * (millis / 1000) % 60; long minute = (millis / (1000 * 60)) % 60; long
	 * hour = (millis / (1000 * 60 * 60)) % 24; return
	 * String.format("%02d:%02d:%02d", hour, minute, second); }
	 */

	@RequestMapping(value = "/generateuserwisereport", method = RequestMethod.GET)
	public ModelAndView generateUserWiseReport(ModelAndView modelAndView, HttpServletRequest request) {

		String companyCode = request.getParameter("company_code");
		String empCode = request.getParameter("emp_code");
		String empName = request.getParameter("emp_name");
		String username = request.getParameter("username");
		String startDate = request.getParameter("start_date");

		Map<String, String> parameterMap = new HashMap<String, String>();
		parameterMap.put("companyCode", companyCode);
		parameterMap.put("empCode", empCode);
		parameterMap.put("empName", empName);
		parameterMap.put("username", username);
		parameterMap.put("startDate", startDate);

		List<TaskReportView> taskViewReportList = taskReportService.findUserWiseDailyTasks(parameterMap);

		Map<String, Object> data = new HashMap<String, Object>();

		data.put("date", request.getParameter("start_date"));
		data.put("empCode", request.getParameter("emp_code"));
		data.put("empName", request.getParameter("emp_name"));
		data.put("taskViewReportList", taskViewReportList);

		return new ModelAndView("report/userwisedailyreport", "data", data);
	}
	
	@RequestMapping(value = "/dailySummary", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView dailySummary() {
		// TODO Auto-generated method stub
		return new ModelAndView("report/dailysummaryreport");
	}

	
	@RequestMapping(value = "/generateDailySummaryPdfReport/{startdate}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView generateDailySummaryPdfReport(@PathVariable(value = "startdate") String startdate) {

		Map<String, String> parameterMap = new HashMap<String, String>();
		parameterMap.put("startDate", startdate);
		System.out.println("Controller::::::::::::::::::::::::::::::::" + startdate);
		Map<String, Object> log = taskReportService.getDailySummaryReportElement(parameterMap);
		
		List<DailySummary> dsum = (List<DailySummary>) log.get("dsummery");
		for(DailySummary d:dsum){
			System.out.println(d.getId());
			System.out.println(d.getSpentTimeTemp());
		}

		return new ModelAndView("report/generatedailysummaryreport","log",log);

	}
}