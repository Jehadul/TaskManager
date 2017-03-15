package com.ctrends.taskmanager.service.tman;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ctrends.taskmanager.dao.tman.ITasksDao;
import com.ctrends.taskmanager.model.taskmanage.Module;
import com.ctrends.taskmanager.model.taskmanage.Suite;
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
		Map<String, String> data = new HashMap<String, String>();

		Tasks tasks = new Tasks();
		User currentUser = userService.getCurrentUser();
		tasks.setSuiteCode(requestMap.get("suite_code")[0]);
		tasks.setSuiteName(requestMap.get("suite_name")[0]);
		tasks.setModuleCode(requestMap.get("module_code")[0]);
		tasks.setModuleName(requestMap.get("module_name")[0]);
		tasks.setPrivGrpCode(Integer.parseInt(requestMap.get("priv_grp_code")[0]));
		tasks.setPrivGrpName(requestMap.get("priv_grp_name")[0]);
		tasks.setDescription(requestMap.get("description")[0]);
		tasks.setStoryCode(requestMap.get("story_code")[0]);

		tasks.setTaskTitle(requestMap.get("task_title")[0]);
		tasks.setEstimatedTime(Double.parseDouble(requestMap.get("estimated_time")[0]));
		tasks.setAsignee(requestMap.get("assignee")[0]);

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

		UUID id = tasksDao.insertDoc(tasks);
		data.put("id", id.toString());
		return data;
	}

	@Override
	public Map<String, String> insertTaskLog(Map<String, String> requestMap) {
		Map<String, String> data = new HashMap<String, String>();
		TaskLog taskLog = new TaskLog();
		User currentUser = userService.getCurrentUser();
		taskLog.setTaskId(UUID.fromString(requestMap.get("id")));
		taskLog.setTaskTitle(requestMap.get("taskTitle"));
		taskLog.setStartTime(requestMap.get("startTime"));
		taskLog.setStopStatus("false");

		String dat = requestMap.get("today");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date dd;
		try {
			dd = sdf.parse(dat);
			java.sql.Date timeLogSqlDate = new java.sql.Date(dd.getTime());
			taskLog.setDate(timeLogSqlDate);
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
		return data;
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
		tasks.setDescription(requestMap.get("description")[0]);
		tasks.setStoryCode(requestMap.get("story_code")[0]);

		tasks.setTaskTitle(requestMap.get("task_title")[0]);
		tasks.setEstimatedTime(Double.parseDouble(requestMap.get("estimated_time")[0]));
		tasks.setAsignee(requestMap.get("assignee")[0]);

		tasks.setClientCode(currentUser.getClientCode());
		tasks.setClientName(currentUser.getClientName());
		tasks.setCompanyCode(currentUser.getCompanyCode());
		tasks.setCompanyName(currentUser.getCompanyName());
		tasks.setUpdatedByCode(currentUser.getEmpCode());
		tasks.setUpdatedByName(currentUser.getEmpName());
		tasks.setUpdatedByUsername(currentUser.getUsername());
		tasks.setUpdatedByEmail(currentUser.getEmail());
		tasks.setUpdatedByCompanyCode(currentUser.getCompanyCode());
		tasks.setUpdatedByCompanyName(currentUser.getCompanyName());
		tasks.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

		tasks.setUpdatedByCode(currentUser.getUpdatedByCode());
		tasks.setUpdatedByName(currentUser.getUpdatedByName());
		tasks.setUpdatedByCompanyCode(currentUser.getCompanyCode());
		tasks.setUpdatedByCompanyName(currentUser.getCompanyName());
		tasks.setUpdatedByEmail(currentUser.getEmail());
		tasks.setUpdatedByUsername(currentUser.getUsername());

		tasks.setClientCode(currentUser.getClientCode());
		tasks.setClientName(currentUser.getClientName());
		tasks.setCompanyCode(currentUser.getCompanyCode());
		tasks.setCompanyName(currentUser.getCompanyName());
		tasks.setUpdatedByCode(currentUser.getEmpCode());
		tasks.setUpdatedByName(currentUser.getEmpName());
		tasks.setUpdatedByUsername(currentUser.getUsername());
		tasks.setUpdatedByEmail(currentUser.getEmail());
		tasks.setUpdatedByCompanyCode(currentUser.getCompanyCode());
		tasks.setUpdatedByCompanyName(currentUser.getCompanyName());
		tasks.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

		tasks.setUpdatedByCode(currentUser.getUpdatedByCode());
		tasks.setUpdatedByName(currentUser.getUpdatedByName());
		tasks.setUpdatedByCompanyCode(currentUser.getCompanyCode());
		tasks.setUpdatedByCompanyName(currentUser.getCompanyName());
		tasks.setUpdatedByEmail(currentUser.getEmail());
		tasks.setUpdatedByUsername(currentUser.getUsername());

		UUID id = tasksDao.updateDoc(tasks);
		data.put("id", id.toString());
		return data;
	}

	@Override
	public Map<String, String> updateTimeLog(Map<String, String> requestMap) {
		Map<String, String> data = new HashMap<String, String>();
		TaskLog taskLog = tasksDao.getDocByIdTimeLog(UUID.fromString(requestMap.get("id")));
		Tasks tasks = tasksDao.getDocById(UUID.fromString(requestMap.get("id")));
		taskLog.setStopTime(requestMap.get("stopTime"));
		taskLog.setStopStatus("true");

		// update tasklist table.............
		try {
			String time = taskLog.getStartTime();
			String time2 = requestMap.get("stopTime");
			DateFormat sdf = new SimpleDateFormat("hh:mm:ss aa");
			Date d1 = sdf.parse(time);
			Date d2 = sdf.parse(time2);

			if (d2.after(d1)) {
				long diff = d2.getTime() - d1.getTime();
				long diffMinutes = diff / (60 * 1000) % 60;
				long diffHours = diff / (60 * 60 * 1000) % 24;
				double sepentTime = Double.parseDouble(diffHours + "." + diffMinutes) + tasks.getSpentTime();
				tasks.setSpentTime(sepentTime);
				tasks.setRemainingTime(tasks.getEstimatedTime() - sepentTime);
				UUID idTask = tasksDao.updateSpantTimeDoc(tasks);
				if (idTask != null) {
					UUID id = tasksDao.updateTaskLogDoc(taskLog);
					data.put("id", id.toString());
				}
			}
			if (d2.before(d1)) {
				long diff = d2.getTime() - d1.getTime();
				long diffMinutes = diff / (60 * 1000) % 60;
				long diffHours = diff / (60 * 60 * 1000) % 24;
				double sepentTime = Double.parseDouble(diffHours + "." + diffMinutes) + tasks.getSpentTime();
				tasks.setSpentTime(sepentTime);
				tasks.setRemainingTime(tasks.getEstimatedTime() - sepentTime);
				UUID idTask = tasksDao.updateSpantTimeDoc(tasks);
				if (idTask != null) {
					UUID id = tasksDao.updateTaskLogDoc(taskLog);
					data.put("id", id.toString());
				}
			}

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

}