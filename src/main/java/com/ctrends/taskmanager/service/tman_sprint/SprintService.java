package com.ctrends.taskmanager.service.tman_sprint;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctrends.taskmanager.bean.Utility;
import com.ctrends.taskmanager.dao.tman.ITasksDao;
import com.ctrends.taskmanager.dao.tman_sprint.ISprintDAO;
import com.ctrends.taskmanager.model.tman.TaskLog;
import com.ctrends.taskmanager.model.tman.Tasks;
import com.ctrends.taskmanager.model.tman_sprint.BurndownChart;
import com.ctrends.taskmanager.model.tman_sprint.SprintManager;
import com.ctrends.taskmanager.model.tman_sprint.SprintManagerDetails;
import com.ctrends.taskmanager.model.tman_sprint.SprintView;
import com.ctrends.taskmanager.model.user.User;
import com.ctrends.taskmanager.service.user.IUserService;

@Service("sprintService")
public class SprintService implements ISprintService {

	@Autowired
	ISprintDAO sprintDao;

	@Autowired
	ITasksDao tasksDao;

	@Autowired
	IUserService userService;

	@Override
	public Map<String, String> insert(Map<String, String[]> requestMap) {

		Map<String, String> data = new HashMap<String, String>();
		User currentUser = userService.getCurrentUser();
		String strid = null;
		UUID id;

		/*************************
		 * Master data sent from view
		 *******************************/

		Map<String, Object> param = new HashMap<String, Object>();

		param.put("sprintCode", requestMap.get("sprint_code")[0]);
		boolean rules = sprintDao.checkUnique(param);

		SprintManager sprint = new SprintManager();

		sprint.setSprintCode(requestMap.get("sprint_code")[0]);
		sprint.setSprintName(requestMap.get("sprint_name")[0]);
		sprint.setTeamCode(requestMap.get("team_code")[0]);
		sprint.setTeamName(requestMap.get("team_name")[0]);
		sprint.setSprintGoal(requestMap.get("sprint_goal")[0]);
		sprint.setSprintNumber(Double.parseDouble(requestMap.get("sprint_number")[0]));
		sprint.setClientCode(currentUser.getClientCode());
		sprint.setClientName(currentUser.getClientName());
		sprint.setCompanyCode(currentUser.getCompanyCode());
		sprint.setCompanyName(currentUser.getCompanyName());
		sprint.setCreatedByCode(currentUser.getCreatedByCode());
		sprint.setCreatedByName(currentUser.getCreatedByName());
		sprint.setCreatedByCode(currentUser.getEmpCode());
		sprint.setCreatedByName(currentUser.getEmpName());
		sprint.setCreatedByUsername(currentUser.getUsername());
		sprint.setCreatedByEmail(currentUser.getEmail());
		sprint.setCreatedByCompanyCode(currentUser.getCompanyCode());
		sprint.setCreatedByCompanyName(currentUser.getCompanyName());
		sprint.setCreatedAt(new Timestamp(System.currentTimeMillis()));

		// burndown chart start

		List<BurndownChart> burndownChartList = new ArrayList<BurndownChart>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date startDateUtilq = Utility.stringToDate(requestMap.get("start_date")[0]);
		java.util.Date endDateUtilz = Utility.stringToDate(requestMap.get("end_date")[0]);
		String s = sdf.format(startDateUtilq);
		String e = sdf.format(endDateUtilz);
		LocalDate start = LocalDate.parse(s);
		LocalDate end = LocalDate.parse(e);

		int c = 0;
		while (start.isBefore(end) || start.equals(end)) {
			BurndownChart burndownChart = new BurndownChart();
			burndownChart.setSprintCode(requestMap.get("sprint_code")[0]);
			burndownChart.setSprintName(requestMap.get("sprint_name")[0]);
			burndownChart.setWorkingDate(Date.valueOf(start));

			burndownChartList.add(c, burndownChart);
			System.out.println(start + ":::::::::::::::::;");
			start = start.plusDays(1);
			c++;

		}
		sprint.setCharts(burndownChartList);

		if (requestMap.get("start_date")[0].equals("")) {
			sprint.setStartDate(new Date(System.currentTimeMillis()));
		} else {
			String startDate = requestMap.get("start_date")[0];
			java.util.Date startDateUtil = Utility.stringToDate(startDate);
			java.sql.Date startDateSql = (Date) Utility.fromUtiltoSql(startDateUtil);
			sprint.setStartDate(startDateSql);
		}

		if (requestMap.get("end_date")[0].equals("")) {
			sprint.setEndDate(new Date(System.currentTimeMillis()));
		} else {
			String endDate = requestMap.get("end_date")[0];
			java.util.Date endDateUtil = Utility.stringToDate(endDate);
			java.sql.Date endDateSql = (Date) Utility.fromUtiltoSql(endDateUtil);
			sprint.setEndDate(endDateSql);
		}
		sprint.setSprintDescription(requestMap.get("sprint_description")[0]);

		/**********************
		 * Detail item data sent from view
		 *********************************/

		String[] storyCode = (String[]) requestMap.get("story_code[]");

		String[] storyName = (String[]) requestMap.get("story_name[]");

		String[] suiteCode = (String[]) requestMap.get("suite_code[]");

		String[] suiteName = (String[]) requestMap.get("suite_name[]");

		String[] moduleName = (String[]) requestMap.get("module_name[]");

		String[] moduleCode = (String[]) requestMap.get("module_code[]");

		String[] privGrpName = (String[]) requestMap.get("priv_grp_name[]");

		String[] privGrpCode = (String[]) requestMap.get("priv_grp_code[]");

		String[] privilegeName = (String[]) requestMap.get("privilege_name[]");

		String[] privilegeCode = (String[]) requestMap.get("privilege_code[]");

		List<SprintManagerDetails> storyDetailsList = new ArrayList<SprintManagerDetails>();
		for (int i = 0; i < storyCode.length; i++) {
			SprintManagerDetails stroyDetails = new SprintManagerDetails();

			stroyDetails.setSprintCode(requestMap.get("sprint_code")[0]);
			stroyDetails.setSprintStoryCode(storyCode[i]);
			stroyDetails.setSprintStoryName(storyName[i]);
			stroyDetails.setSuiteCode(suiteCode[i]);
			stroyDetails.setSuiteName(suiteName[i]);
			stroyDetails.setModuleCode(moduleCode[i]);
			stroyDetails.setModuleName(moduleName[i]);
			stroyDetails.setPrivGrpCode(Integer.parseInt(privGrpCode[i]));
			stroyDetails.setPrivGrpName(privGrpName[i]);
			stroyDetails.setPrivilegeCode(privilegeCode[i]);
			stroyDetails.setPrivilegeName(privilegeName[i]);
			stroyDetails.setCreatedByCode(currentUser.getCreatedByCode());
			stroyDetails.setCreatedByName(currentUser.getCreatedByName());
			stroyDetails.setCreatedByUsername(currentUser.getCreatedByUsername());
			stroyDetails.setCreatedByCode(currentUser.getEmpCode());
			stroyDetails.setCreatedByName(currentUser.getEmpName());
			stroyDetails.setCreatedByUsername(currentUser.getUsername());
			stroyDetails.setCreatedByEmail(currentUser.getEmail());
			stroyDetails.setCreatedByCompanyCode(currentUser.getCompanyCode());
			stroyDetails.setCreatedByCompanyName(currentUser.getCompanyName());
			stroyDetails.setCreatedAt(new Timestamp(System.currentTimeMillis()));

			stroyDetails.setClientName(currentUser.getClientName());
			stroyDetails.setCompanyCode(currentUser.getCompanyCode());
			stroyDetails.setUpdatedByCode(currentUser.getEmpCode());
			stroyDetails.setUpdatedByName(currentUser.getEmpName());
			stroyDetails.setUpdatedByUsername(currentUser.getUsername());
			stroyDetails.setUpdatedByEmail(currentUser.getEmail());
			stroyDetails.setUpdatedByCompanyCode(currentUser.getCompanyCode());
			stroyDetails.setUpdatedByCompanyName(currentUser.getCompanyName());
			storyDetailsList.add(i, stroyDetails);
		}
		sprint.setSteps(storyDetailsList);
		if (rules) {
			id = sprintDao.insertDoc(sprint);
			strid = id.toString();
			data.put("id", strid);
		} else {
			data.put("id", null);

		}

		return data;

	}

	@Override
	public List<SprintManager> getAll() {
		List<SprintManager> splist = sprintDao.getAllDoc();
		return splist;
	}

	@Override
	public SprintManager getById(UUID id) {
		return sprintDao.getDocById(id);
	}

	@Override
	public List<SprintManagerDetails> getByIdSprintCode(String sprintCode) {
		return sprintDao.getDocByIdStoryCode(sprintCode);
	}

	@Override
	public Map<String, String> update(Map<String, String[]> requestMap) {
		System.out.println(requestMap.get("id" + ":::::::::::::::service:::::::::::::::::::::"));

		Map<String, String> data = new HashMap<String, String>();
		User currentUser = userService.getCurrentUser();
		String strid = null;
		UUID id;

		/*************************
		 * Master data sent from view
		 *******************************/

		Map<String, Object> param = new HashMap<String, Object>();

		param.put("sprintCode", requestMap.get("sprint_code")[0]);

		// boolean rules = sprintDao.checkUnique(param);
		SprintManager sprint = sprintDao.getDocById(UUID.fromString(requestMap.get("id")[0]));
		sprint.setSprintCode(requestMap.get("sprint_code")[0]);
		sprint.setSprintName(requestMap.get("sprint_name")[0]);
		sprint.setTeamCode(requestMap.get("team_code")[0]);
		sprint.setTeamName(requestMap.get("team_name")[0]);
		sprint.setSprintGoal(requestMap.get("sprint_goal")[0]);
		sprint.setSprintNumber(Double.parseDouble(requestMap.get("sprint_number")[0]));

		sprint.setClientCode(currentUser.getClientCode());
		sprint.setClientName(currentUser.getClientName());
		sprint.setCompanyCode(currentUser.getCompanyCode());
		sprint.setCompanyName(currentUser.getCompanyName());
		sprint.setCreatedByCode(currentUser.getCreatedByCode());
		sprint.setCreatedByName(currentUser.getCreatedByName());
		sprint.setCreatedByCode(currentUser.getEmpCode());
		sprint.setCreatedByName(currentUser.getEmpName());
		sprint.setCreatedByUsername(currentUser.getUsername());
		sprint.setCreatedByEmail(currentUser.getEmail());
		sprint.setCreatedByCompanyCode(currentUser.getCompanyCode());
		sprint.setCreatedByCompanyName(currentUser.getCompanyName());
		sprint.setCreatedAt(new Timestamp(System.currentTimeMillis()));

		if (requestMap.get("start_date")[0].equals("")) {
			sprint.setStartDate(new Date(System.currentTimeMillis()));
		} else {
			String startDate = requestMap.get("start_date")[0];
			java.util.Date startDateUtil = Utility.stringToDate(startDate);
			java.sql.Date startDateSql = (Date) Utility.fromUtiltoSql(startDateUtil);
			sprint.setStartDate(startDateSql);
		}

		if (requestMap.get("end_date")[0].equals("")) {
			sprint.setEndDate(new Date(System.currentTimeMillis()));
		} else {
			String endDate = requestMap.get("end_date")[0];
			java.util.Date endDateUtil = Utility.stringToDate(endDate);
			java.sql.Date endDateSql = (Date) Utility.fromUtiltoSql(endDateUtil);
			sprint.setEndDate(endDateSql);
		}
		sprint.setSprintDescription(requestMap.get("sprint_description")[0]);

		/**********************
		 * Detail item data sent from view
		 *********************************/

		String[] storyCode = (String[]) requestMap.get("story_code[]");

		String[] storyName = (String[]) requestMap.get("story_name[]");

		String[] suiteCode = (String[]) requestMap.get("suite_code[]");

		String[] suiteName = (String[]) requestMap.get("suite_name[]");

		String[] moduleName = (String[]) requestMap.get("module_name[]");

		String[] moduleCode = (String[]) requestMap.get("module_code[]");

		String[] privGrpName = (String[]) requestMap.get("priv_grp_name[]");

		String[] privGrpCode = (String[]) requestMap.get("priv_grp_code[]");

		String[] privilegeName = (String[]) requestMap.get("privilege_name[]");

		String[] privilegeCode = (String[]) requestMap.get("privilege_code[]");

		List<SprintManagerDetails> storyDetailsList = new ArrayList<SprintManagerDetails>();

		for (int i = 0; i < storyCode.length; i++) {
			try {
				SprintManagerDetails stroyDetails = new SprintManagerDetails();
				stroyDetails.setSprintCode(requestMap.get("sprint_code")[0]);
				stroyDetails.setSprintId(UUID.fromString(requestMap.get("id")[0]));
				stroyDetails.setSprintStoryCode(storyCode[i]);
				stroyDetails.setSprintStoryName(storyName[i]);
				stroyDetails.setSuiteCode(suiteCode[i]);
				stroyDetails.setSuiteName(suiteName[i]);
				stroyDetails.setModuleCode(moduleCode[i]);
				stroyDetails.setModuleName(moduleName[i]);
				stroyDetails.setPrivGrpCode(Integer.parseInt(privGrpCode[i]));
				stroyDetails.setPrivGrpName(privGrpName[i]);
				stroyDetails.setPrivilegeCode(privilegeCode[i]);
				stroyDetails.setPrivilegeName(privilegeName[i]);
				stroyDetails.setCreatedByCode(currentUser.getCreatedByCode());
				stroyDetails.setCreatedByName(currentUser.getCreatedByName());
				stroyDetails.setCreatedByUsername(currentUser.getCreatedByUsername());
				stroyDetails.setCreatedByCode(currentUser.getEmpCode());
				stroyDetails.setCreatedByName(currentUser.getEmpName());
				stroyDetails.setCreatedByUsername(currentUser.getUsername());
				stroyDetails.setCreatedByEmail(currentUser.getEmail());
				stroyDetails.setCreatedByCompanyCode(currentUser.getCompanyCode());
				stroyDetails.setCreatedByCompanyName(currentUser.getCompanyName());
				stroyDetails.setCreatedAt(new Timestamp(System.currentTimeMillis()));

				stroyDetails.setClientName(currentUser.getClientName());
				stroyDetails.setCompanyCode(currentUser.getCompanyCode());
				stroyDetails.setUpdatedByCode(currentUser.getEmpCode());
				stroyDetails.setUpdatedByName(currentUser.getEmpName());
				stroyDetails.setUpdatedByUsername(currentUser.getUsername());
				stroyDetails.setUpdatedByEmail(currentUser.getEmail());
				stroyDetails.setUpdatedByCompanyCode(currentUser.getCompanyCode());
				stroyDetails.setUpdatedByCompanyName(currentUser.getCompanyName());
				storyDetailsList.add(i, stroyDetails);
			} catch (Exception e) {
				e.getMessage();

			}
			sprint.setSteps(storyDetailsList);
			if (true) {
				id = sprintDao.updateDoc(sprint);
				strid = id.toString();
				data.put("id", strid);
			} else {
				data.put("id", null);

			}
		}

		return data;

	}

	@Override
	public UUID delete(Map<String, String[]> requestMap) {
		UUID id = sprintDao.deleteDoc(UUID.fromString(requestMap.get("id")[0]));
		return id;
	}

	@Override
	public Map<String, Object> getBySprintId(UUID id) {
		List<SprintView> sprintViews = new ArrayList<SprintView>();
		Map<String, Object> data = new HashMap<String, Object>();
		SprintView sprintView = new SprintView();
		SprintManager sprint = sprintDao.getDocById(id);
		List<String> taskId = new ArrayList<>();
		List<String> dateLi = new ArrayList<String>();
		List<Double> doubleLi = new ArrayList<Double>();
		List<SprintManagerDetails> sprintManagerDetails = sprintDao.getDocBySprintId(id);
		for (int i = 0; i < sprintManagerDetails.size(); i++) {
			List<Tasks> tasks = tasksDao.getTaskByStoryCode(sprintManagerDetails.get(i).getSprintStoryCode());
			for (int j = 0; j < tasks.size(); j++) {
				taskId.add(tasks.get(j).getId().toString());
				sprintView.setEstimatedTime(sprintView.getEstimatedTime() + tasks.get(j).getEstimatedTime());
			}
		}
		sprintView.setSprintCode(sprint.getSprintCode());
		sprintView.setSprintName(sprint.getSprintName());
		sprintView.setStartDate(sprint.getStartDate());
		sprintView.setEndDate(sprint.getEndDate());

		String s = sprint.getStartDate().toString();
		String e = sprint.getEndDate().toString();
		LocalDate start = LocalDate.parse(s);
		LocalDate end = LocalDate.parse(e);
		long l = 0;

		DecimalFormat df = new DecimalFormat("#.00");
		SimpleDateFormat sdf = new SimpleDateFormat("M-dd-yyyy");
		while (start.isBefore(end) || start.equals(end)) {
			for (int i = 0; i < taskId.size(); i++) {
				List<TaskLog> taskLogLi = sprintDao.gettasklogLiById(taskId.get(i), Date.valueOf(start));
				for (int j = 0; j < taskLogLi.size(); j++) {
					l += taskLogLi.get(j).getStopTime().getTime() - taskLogLi.get(j).getStartTime().getTime();
				}
			}
			dateLi.add(sdf.format(Date.valueOf(start)));
			double d = sprintView.getEstimatedTime() - ((double) l / (1000 * 60 * 60));
			doubleLi.add(Double.parseDouble(df.format(d)));
			System.out.println(df.format(d));

			start = start.plusDays(1);

		}

		sprintViews.add(sprintView);
		data.put("sprintViews", sprintViews);
		data.put("dateLi", dateLi);
		data.put("doubleLi", doubleLi);
		return data;
	}

	@Override
	public Map<String, Object> getSprintSpentChartData(UUID id) {

		Map<String, Object> map = sprintDao.getSpentChartDoc(id);

		return map;

	}

	@Override
	public Map<String, Object> getDocByBurnDownChartData(UUID id) {
		Map<String, Object> map = sprintDao.getDocByBurnDownChart(id);
		return map;

	}

	@Override
	public List<SprintManager> getAllSprint() {
		List<SprintManager> splist = sprintDao.getAllSprint();
		return splist;
	}
	
	@Override
	public List<SprintManagerDetails> getAllSprintDetailsDoc() {
		List<SprintManagerDetails> splist = sprintDao.getAllSprintDetailsDoc();
		return splist;
	}
	
	
	@Override
	public List<SprintManagerDetails> find(Map<String, String> searchingKey) {
		List<SprintManagerDetails> splist = sprintDao.find(searchingKey);
		return splist;
	}


}
