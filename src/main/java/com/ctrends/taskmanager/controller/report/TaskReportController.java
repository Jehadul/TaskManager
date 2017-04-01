package com.ctrends.taskmanager.controller.report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ctrends.taskmanager.bean.Utility;
import com.ctrends.taskmanager.model.tman.TaskLog;
import com.ctrends.taskmanager.model.tman.Tasks;
import com.ctrends.taskmanager.service.report.ITaskReportService;
import com.ctrends.taskmanager.service.user.IUserService;

@Controller
@RequestMapping("/taskman/report")
public class TaskReportController{
	
	@Autowired
	IUserService userService;

	
	@Autowired
	ITaskReportService taskReportService;
	
	@RequestMapping(value = "/tasklogreport", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView tasklogreport(HttpServletRequest request) {
		Map<String, Object> data = new HashMap<String, Object>();
		List<Tasks> tasklogList = taskReportService.getAll();
		
		Map<String, String> companyCodes = new HashMap<String,String>();
		String companyCode = request.getParameter("company_code");
		
		for (int i = 0; i < tasklogList.size(); i++) {
			companyCodes.put(tasklogList.get(i).getCompanyCode(), tasklogList.get(i).getCompanyName());
		}
				
		data.put("companyCodes", companyCodes);
		data.put("companyCode", companyCode);
		return new ModelAndView("report/userdailyreport","data",data);	
	}
	
	
  @RequestMapping(value="/generateuserwisereport", method=RequestMethod.GET)
	public ModelAndView generateUserWiseReport(ModelAndView modelAndView, HttpServletRequest request){
		
		//User currentUser = userService.getCurrentUser();
		String companyCode = request.getParameter("company_code");
		String empCode = request.getParameter("emp_code");
		String empName = request.getParameter("emp_name");
		String username = request.getParameter("username");
		
		
		java.util.Date startDate = Utility.stringToDate(request.getParameter("start_date"));
		//java.sql.Date startDateSql = (Date) Utility.fromUtiltoSql(startDateUtil);
		
		//Date startDate = request.getParameter("start_date");
		System.out.println(companyCode+ "companyCode"+empCode+"empCode"+empName+"empName"+username+"username"+startDate+"startDate");
		
		
/*		if (companyCode == null) {
			companyCode = currentUser.getCompanyCode();
		}
*/
		Map<String,Object> parameterDate = new HashMap<String,Object>();
		Map<String,String> parameterMap = new HashMap<String,String>();
		parameterMap.put("companyCode", companyCode);
		parameterMap.put("empCode", empCode);
		parameterMap.put("empName", empName);
		parameterMap.put("username", username);
		parameterDate.put("startDate", startDate);
		
		List<Tasks> tlist = taskReportService.find(parameterMap);
		List<TaskLog> tLogList = taskReportService.findTwo(parameterDate);
		
		
		List<TaskLog> newLogList = new ArrayList<>();
		
		
		for(int j=0; j<tlist.size(); j++){
			
			Tasks tempTask = tlist.get(j);
			
			for(int i = 0; i<tLogList.size(); i++){
				
				TaskLog tempLog = tLogList.get(i);
				
				if(tempTask.getId().toString().equals(tempLog.getTaskId().toString()) && tempLog.getStartDate().equals(startDate)){
					newLogList.add(tempLog);
				}
				
			}
		
		}
		
		
		List<String> timeList = new ArrayList<>();
		List<String> timeRemain = new ArrayList<>();
		
		for(int i = 0; i<tlist.size(); i++){
			
			long millis = tlist.get(i).getSpentTime();
			
			long millis2 = tlist.get(i).getRemainingTime();
			
			long second = (millis / 1000) % 60;
			long minute = (millis / (1000 * 60)) % 60;
			long hour = (millis / (1000 * 60 * 60)) % 24;
			
			long second2 = (millis2 / 1000) % 60;
			long minute2 = (millis2 / (1000 * 60)) % 60;
			long hour2 = (millis2 / (1000 * 60 * 60)) % 24;
	
			String time = String.format("%02d:%02d:%02d", hour, minute, second);
			String time2 = String.format("%02d:%02d:%02d", hour2, minute2, second2);
			timeList.add(time);
			timeRemain.add(time2);
			
			
		}
		
		
		if(newLogList.size()==0){
			tlist=null;
			timeList=null;
			timeRemain=null;
		}
		
			
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("tlist", tlist);
		data.put("tLogList", newLogList);
		data.put("timeList", timeList);
		data.put("timeRemain", timeRemain);
		data.put("date", request.getParameter("start_date"));
		
		return new ModelAndView("report/userwisedailyreport", "data", data);
		
	}


	/*@RequestMapping(value="/generateuserwisereport", method=RequestMethod.GET)
    public ModelAndView getTaskReportElement(ModelAndView modelAndView, HttpServletRequest request) {
		//String empCode;
		//User currentUser = userService.getCurrentUser();
		String companyCode = request.getParameter("company_code");
		String empCode = request.getParameter("emp_code");
		String empName = request.getParameter("emp_name");
		String username = request.getParameter("username");
				
		Map<String,String> parameterMap = new HashMap<String,String>();
		parameterMap.put("companyCode", companyCode);
		parameterMap.put("empCode", empCode);
		parameterMap.put("empName", empName);
		parameterMap.put("username", username);
        //logger.debug("--------------generate PDF report----------");
 
		Map<String,Object> data = new HashMap<String,Object>();
		//data.put("tlist", tlist);
		data.put("empCode", empCode);
		data.put("companyCode", companyCode);
       /// parameterMap.put("format", "00AA11");	// need to make dynamic later
        
        HashMap<String, Object> element = taskReportService.getTaskReportElement(data); 
    	Tasks task = (Tasks)element.get("task");
    	TaskLog taskLog = (TaskLog)element.get("taskLog");
		
		List<TaskReportView> entityList = new ArrayList<TaskReportView>();
		TaskReportView taskReportView = new TaskReportView();
		
		taskReportView.setEmpCode(task.getEmpCode());
		taskReportView.setEmpName(task.getEmpName());
		taskReportView.setCompanyCode(task.getCompanyCode());
		taskReportView.setUsername(task.getUsername());
		taskReportView.setTaskTitle(task.getTaskTitle());
		taskReportView.setEstimatedTime(task.getEstimatedTime());
		taskReportView.setSpentTime(task.getSpentTime());
		taskReportView.setStartdate(taskLog.getStartDate());
		taskReportView.setTaskId(taskLog.getTaskId());
		
		entityList.add(taskReportView);
		
        JRDataSource jRdataSource = new JRBeanCollectionDataSource(entityList);
        
        parameterMap.put("ireportdatasource", jRdataSource);
        //pdfReport bean has ben declared in the jasper-views.xml file
		return new ModelAndView("report/userwisedailyreport", "data", data);
		
 
    }
*/

}
