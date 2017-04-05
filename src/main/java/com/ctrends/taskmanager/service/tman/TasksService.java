package com.ctrends.taskmanager.service.tman;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ctrends.taskmanager.dao.tman.ITasksDao;
import com.ctrends.taskmanager.model.tman.TaskLog;
import com.ctrends.taskmanager.model.tman.Tasks;
import com.ctrends.taskmanager.model.user.User;
import com.ctrends.taskmanager.service.user.IUserService;

@Repository("tasksService")
public class TasksService implements ITasksService {

	@Autowired
	ITasksDao tasksDao;

	@Autowired
	IUserService userService;

	@Override
	public Map<String, String> insert(Map<String, String[]> requestMap) {

		UUID id = null;

		Map<String, String> data = new HashMap<String, String>();

		data.put("taskCode", requestMap.get("task_code")[0]);
		boolean code = tasksDao.checkUnique(data);

		Tasks tasks = new Tasks();
		User currentUser = userService.getCurrentUser();

		tasks.setSuiteCode(requestMap.get("suite_code")[0]);
		tasks.setSuiteName(requestMap.get("suite_name")[0]);
		tasks.setModuleCode(requestMap.get("module_code")[0]);
		tasks.setModuleName(requestMap.get("module_name")[0]);
		tasks.setPrivGrpCode(Integer.parseInt(requestMap.get("priv_grp_code")[0]));
		tasks.setPrivGrpName(requestMap.get("priv_grp_name")[0]);
		tasks.setPrivilegeCode(requestMap.get("privilege_code")[0]);
		tasks.setPrivilegeName(requestMap.get("privilege_name")[0]);
		tasks.setDescription(requestMap.get("description")[0]);
		tasks.setStoryCode(requestMap.get("story_code")[0]);
		tasks.setStoryTitle(requestMap.get("story_title")[0]);
		tasks.setEmpCode(requestMap.get("emp_code")[0]);
		tasks.setEmpName(requestMap.get("emp_name")[0]);
		tasks.setUsername(requestMap.get("username")[0]);

		tasks.setTaskCode(requestMap.get("task_code")[0]);
		tasks.setTaskTitle(requestMap.get("task_title")[0]);
		tasks.setEstimatedTime(Double.parseDouble(requestMap.get("estimated_time")[0]));
		tasks.setRemainingTime(Double.parseDouble(requestMap.get("estimated_time")[0]));

		tasks.setClientCode(currentUser.getClientCode());
		tasks.setClientName(currentUser.getClientName());
		tasks.setCompanyCode(currentUser.getCompanyCode());
		tasks.setCompanyName(currentUser.getCompanyName());
		tasks.setCreatedByCode(currentUser.getCreatedByCode());
		tasks.setCreatedByName(currentUser.getCreatedByName());
		tasks.setCreatedByCode(currentUser.getEmpCode());
		tasks.setCreatedByName(currentUser.getEmpName());
		tasks.setCreatedByUsername(currentUser.getUsername());
		tasks.setCreatedByEmail(currentUser.getEmail());
		tasks.setCreatedByCompanyCode(currentUser.getCompanyCode());
		tasks.setCreatedByCompanyName(currentUser.getCompanyName());
		tasks.setCreatedAt(new Timestamp(System.currentTimeMillis()));

		if (code) {
			id = tasksDao.insertDoc(tasks);
			data.put("id", id.toString());
		} else {
			data.put("id", null);
		}
		return data;
	}

	/*
	 * SELECT EXTRACT(EPOCH FROM (stop_time-start_time)) FROM task_logs
	 */
	@Override
	public Map<String, String> insertTaskLog(Map<String, String> requestMap) {
		Map<String, String> data = new HashMap<String, String>();
		TaskLog taskLog = new TaskLog();
		User currentUser = userService.getCurrentUser();
		taskLog.setTaskId(requestMap.get("id"));
		taskLog.setTaskTitle(requestMap.get("taskTitle"));

		System.out.println(requestMap.get("startTime") + "::::::::::::::::p:::::::::::::::::");
		SimpleDateFormat dsf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date s;
		try {
			s = dsf.parse(requestMap.get("startTime"));
			Calendar calendar = Calendar.getInstance();

			calendar.setTime(s);
			Timestamp hh = new Timestamp(calendar.getTime().getTime());
			taskLog.setStartTime(hh);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		taskLog.setStartStopStatus(false);

		String dat = requestMap.get("today");

		java.util.Date dd;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			dd = sdf.parse(dat);
			java.sql.Date timeLogSqlDate = new java.sql.Date(dd.getTime());
			taskLog.setStartDate(timeLogSqlDate);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		taskLog.setClientCode(currentUser.getClientCode());
		taskLog.setClientName(currentUser.getClientName());
		taskLog.setCompanyCode(currentUser.getCompanyCode());
		taskLog.setCompanyName(currentUser.getCompanyName());
		taskLog.setCreatedByCode(currentUser.getCreatedByCode());
		taskLog.setCreatedByName(currentUser.getCreatedByName());
		taskLog.setCreatedByCode(currentUser.getEmpCode());
		taskLog.setCreatedByName(currentUser.getEmpName());
		taskLog.setCreatedByUsername(currentUser.getUsername());
		taskLog.setCreatedByEmail(currentUser.getEmail());
		taskLog.setCreatedByCompanyCode(currentUser.getCompanyCode());
		taskLog.setCreatedByCompanyName(currentUser.getCompanyName());
		taskLog.setCreatedAt(new Timestamp(System.currentTimeMillis()));

		UUID id = tasksDao.insertTaskLogDoc(taskLog);
		data.put("id", id.toString());
		return null;
	}

	@Override
	public List<Tasks> getAll() {
		List<Tasks> taskLi = tasksDao.getAllDoc();
		return taskLi;
	}

	@Override
	public Tasks getById(UUID id) {
		return tasksDao.getDocById(id);
	}

	@Override
	public Map<String, String> update(Map<String, String[]> requestMap) {
		Map<String, String> data = new HashMap<String, String>();
		User currentUser = userService.getCurrentUser();
		// System.out.println(":::::"+requestMap.get("id")[0]);
		Tasks tasks = tasksDao.getDocById(UUID.fromString(requestMap.get("id")[0]));

		tasks.setSuiteCode(requestMap.get("suite_code")[0]);
		tasks.setSuiteName(requestMap.get("suite_name")[0]);
		tasks.setModuleCode(requestMap.get("module_code")[0]);
		tasks.setModuleName(requestMap.get("module_name")[0]);
		tasks.setPrivGrpCode(Integer.parseInt(requestMap.get("priv_grp_code")[0]));
		tasks.setPrivGrpName(requestMap.get("priv_grp_name")[0]);
		tasks.setPrivilegeCode(requestMap.get("privilege_code")[0]);
		tasks.setPrivilegeName(requestMap.get("privilege_name")[0]);
		tasks.setDescription(requestMap.get("description")[0]);
		tasks.setStoryCode(requestMap.get("story_code")[0]);
		tasks.setStoryTitle(requestMap.get("story_title")[0]);
		tasks.setEmpCode(requestMap.get("emp_code")[0]);
		tasks.setEmpName(requestMap.get("emp_name")[0]);
		tasks.setUsername(requestMap.get("username")[0]);

		tasks.setTaskCode(requestMap.get("task_code")[0]);
		tasks.setTaskTitle(requestMap.get("task_title")[0]);
		tasks.setEstimatedTime(Double.parseDouble(requestMap.get("estimated_time")[0]));
		tasks.setRemainingTime(Double.parseDouble(requestMap.get("estimated_time")[0]));

		tasks.setClientCode(currentUser.getClientCode());
		tasks.setClientName(currentUser.getClientName());
		tasks.setCompanyCode(currentUser.getCompanyCode());
		tasks.setCompanyName(currentUser.getCompanyName());
		tasks.setCreatedByCode(currentUser.getCreatedByCode());
		tasks.setCreatedByName(currentUser.getCreatedByName());
		tasks.setCreatedByCode(currentUser.getEmpCode());
		tasks.setCreatedByName(currentUser.getEmpName());
		tasks.setCreatedByUsername(currentUser.getUsername());
		tasks.setCreatedByEmail(currentUser.getEmail());
		tasks.setCreatedByCompanyCode(currentUser.getCompanyCode());
		tasks.setCreatedByCompanyName(currentUser.getCompanyName());
		tasks.setCreatedAt(new Timestamp(System.currentTimeMillis()));

		UUID id = tasksDao.updateDoc(tasks);
		data.put("id", id.toString());
		return data;
	}

	@Override
	public Map<String, String> updateTimeLog(Map<String, String> requestMap) {
		Map<String, String> data = new HashMap<String, String>();
		TaskLog taskLog = tasksDao.getDocByIdTimeLog(requestMap.get("id"));
		Tasks tasks = tasksDao.getDocById(UUID.fromString(requestMap.get("id")));

		SimpleDateFormat dsf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date s;
		try {
			s = dsf.parse(requestMap.get("stopTime"));
			Calendar calendar = Calendar.getInstance();

			calendar.setTime(s);
			Timestamp hh = new Timestamp(calendar.getTime().getTime());
			taskLog.setStopTime(hh);
			taskLog.setStartStopStatus(true);

			String dat = requestMap.get("day");

			java.util.Date dd;
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				dd = sdf.parse(dat);
				java.sql.Date timeLogSqlDate = new java.sql.Date(dd.getTime());
				taskLog.setStopDate(timeLogSqlDate);
			} catch (ParseException e) {

				e.printStackTrace();
			}

			
			/*long spentTotalTime = tasks.getSpentTime() + (hh.getTime() - taskLog.getStartTime().getTime());
			tasks.setSpentTime(spentTotalTime);

			long remaingSqlTimeHours = Long.parseLong(String.valueOf(tasks.getEstimatedTime()).split("\\.")[0]);
			long remaingsqlTimeMin = Long.parseLong(String.valueOf(tasks.getEstimatedTime()).split("\\.")[1]);

			long estimateSqlTime = (remaingSqlTimeHours * 60 * 60 * 1000) + (remaingsqlTimeMin * 60*1000);
			long remaingTotalTime = estimateSqlTime - spentTotalTime;*/
			
			long spentTotalTime = tasks.getSpentTime() + (hh.getTime() - taskLog.getStartTime().getTime());
            tasks.setSpentTime(spentTotalTime);
			
			tasks.setRemainingTime(Double.parseDouble(requestMap.get("remaininghours")));
			taskLog.setRemainingTime(Double.parseDouble(requestMap.get("remaininghours")));
			
			tasksDao.updateTaskLogDoc(taskLog);
			tasksDao.updateSpantTimeDoc(tasks);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public UUID delete(Map<String, String[]> requestMap) {
		UUID id = tasksDao.deleteDoc(UUID.fromString(requestMap.get("id")[0]));
		return id;
	}

	@Override
	public List<Tasks> find(Map<String, String> params) {
		List<Tasks> searchResult = tasksDao.getDocs(params);
		// System.out.println("............."+searchResult+"zihad");
		return searchResult;
	}

	@Override
	public List<Tasks> getAllByCurrentUser() {
		return tasksDao.getDocsByCurrentUser();
	}

	@Override
	public List<Tasks> getCurrentTaskByCurrentUser() {
		return tasksDao.getCurrentTaskByCurrentUser();
	}

	@Override
	public TaskLog getRunningTaskLogByCurrentUser() {
		return tasksDao.getRunningTaskByCurrentUser1();
	}

}