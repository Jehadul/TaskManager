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
	
	
	/**
	 * 
	 * @last edit by farid
	 * change return beacuase not found company table and company code
	 * this method view task log report daily hours
	 */
	@RequestMapping(value = "/tasklogreport", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView tasklogreport(HttpServletRequest request) {

		return new ModelAndView("report/userdailyreport");
	}
	
	/**
	 * remove compan_code and others
	 */
	@RequestMapping(value = "/generateuserwisereport", method = RequestMethod.GET)
	public ModelAndView generateUserWiseReport(ModelAndView modelAndView, HttpServletRequest request) {
		String username = request.getParameter("username");
		String startDate = request.getParameter("start_date");
		

		Map<String, String> parameterMap = new HashMap<String, String>();
		parameterMap.put("username", username);
		parameterMap.put("startDate", startDate);
		System.out.println(parameterMap.get("username"));
		System.out.println(parameterMap.get("startDate"));
		List<TaskReportView> taskViewReportList = taskReportService.findUserWiseDailyTasks(parameterMap);

		Map<String, Object> data = new HashMap<String, Object>();

		data.put("date", request.getParameter("start_date"));		
		data.put("taskViewReportList", taskViewReportList);

		return new ModelAndView("report/userwisedailyreport", "data", data);
	}

	@RequestMapping(value = "/dailySummary", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView dailySummary() {
		// TODO Auto-generated method stub
		return new ModelAndView("report/dailysummaryreport");
	}

	@RequestMapping(value = "/generateDailySummaryReport/{startdate}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView generateDailySummaryReport(@PathVariable(value = "startdate") String startdate) {

		Map<String, String> parameterMap = new HashMap<String, String>();
		parameterMap.put("startDate", startdate);
		System.out.println("Controller::::::::::::::::::::::::::::::::" + startdate);
		Map<String, Object> log = taskReportService.getDailySummaryReportElement(parameterMap);

		List<DailySummary> dsum = (List<DailySummary>) log.get("dsummery");
		for (DailySummary d : dsum) {
			System.out.println(d.getId());
			System.out.println(d.getSpentTimeTemp());
		}

		return new ModelAndView("report/generatedailysummaryreport", "log", log);


	}
}