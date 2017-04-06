package com.ctrends.taskmanager.controller.tman_sprint;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
import com.ctrends.taskmanager.dao.tman_sprint.ISprintDAO;
import com.ctrends.taskmanager.model.taskmanage.Module;
import com.ctrends.taskmanager.model.taskmanage.PrivGroup;
import com.ctrends.taskmanager.model.taskmanage.Suite;
import com.ctrends.taskmanager.model.tman.Tasks;
import com.ctrends.taskmanager.model.tman_sprint.SprintManager;
import com.ctrends.taskmanager.model.tman_sprint.SprintManagerDetails;
import com.ctrends.taskmanager.service.tman_sprint.ISprintService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
@RequestMapping("/taskman/tman/sprint")
public class SprintController implements ISprintController {

	@Autowired
	ISprintService sprintService;

	@Autowired
	ISprintDAO sprintDao;

	@Override
	public ModelAndView index() {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Override
	public ModelAndView show(@PathVariable(value = "id") UUID id) {
		SprintManager sprint = sprintService.getById(id);
		List<SprintManagerDetails> sprintDetails = sprintService.getByIdSprintCode(sprint.getSprintCode());
		Map<String, Object> map = new HashMap<>();
		System.out.println(sprintDetails.get(0).getSprintStoryName());

		map.put("mode", "doc");
		map.put("sprint", sprint);
		map.put("sprintDetails", sprintDetails);
		GsonBuilder gson = new GsonBuilder();
		Gson g = gson.create();
		// map.put("quesJson", g.toJson(q));
		return new ModelAndView("sprintmanager/show", "map", map);

	}

	@Override
	public WSResponse get(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView create() {

		return null;
	}

	@RequestMapping(value = "/store", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public WSResponse store(HttpServletRequest request) {
		Map<String, String[]> sprint = request.getParameterMap();

		Map<String, String> data = sprintService.insert(sprint);

		return new WSResponse("success", "Saved successfully", UUID.fromString(data.get("id")), null, data.get("mode"),
				data);
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Override
	public ModelAndView edit(@PathVariable(value = "id") UUID id) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<Suite> suiteLi = sprintDao.getAllSuites();

		Map<String, String> suiteCodes = new HashMap<String, String>();
		for (int i = 0; i < suiteLi.size(); i++) {
			suiteCodes.put(suiteLi.get(i).getSuiteCode(), suiteLi.get(i).getSuiteShortName());
		}

		List<Module> moduleLi = sprintDao.getAllModules();

		Map<String, String> moduleCodes = new HashMap<String, String>();
		for (int i = 0; i < moduleLi.size(); i++) {
			moduleCodes.put(moduleLi.get(i).getModCode(), moduleLi.get(i).getModShortName());
		}

		List<PrivGroup> privGrpLi = sprintDao.getAllPrivGrps();

		Map<Integer, String> privGrpCodes = new HashMap<Integer, String>();
		for (int i = 0; i < privGrpLi.size(); i++) {
			privGrpCodes.put(privGrpLi.get(i).getPrivGrpCode(), privGrpLi.get(i).getPrivGrpName());
		}

		SprintManager sprintManager = sprintService.getById(id);

		List<SprintManagerDetails> sprintDetails = sprintService.getByIdSprintCode(sprintManager.getSprintCode());

		map.put("mode", "doc");
		map.put("sprintManager", sprintManager);
		map.put("suiteCodes", suiteCodes);
		map.put("moduleCodes", moduleCodes);
		map.put("privGrpCodes", privGrpCodes);
		map.put("sprintDetails", sprintDetails);

		GsonBuilder gson = new GsonBuilder();
		Gson g = gson.create();

		return new ModelAndView("sprintmanager/edit", "map", map);
	}

	@RequestMapping(value = "/destroy", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public WSResponse destroy(HttpServletRequest request) {
		Map<String, String[]> sprint = request.getParameterMap();
		UUID id = sprintService.delete(sprint);
		return new WSResponse("success", "Sprint deleted successfully", id, null, "doc", null);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Override
	public ModelAndView delete() {

		Map<String, Object> data = new HashMap<String, Object>();
		List<SprintManager> sprintManagerList = sprintService.getAll();
		data.put("sprintManagerList", sprintManagerList);

		return new ModelAndView("sprintmanager/delete", "data", data);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public WSResponse update(HttpServletRequest request) {
		Map<String, String[]> sprintManager = request.getParameterMap();
		Map<String, String> data = sprintService.update(sprintManager);
		System.out.println(request.getParameter("sprint_code"));

		return new WSResponse("success", "Updated Successfully", UUID.fromString(data.get("id")), null,
				data.get("mode"), data);

	}

	@RequestMapping(value = "/create", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public ModelAndView create(HttpServletRequest request) {
		Map<String, Object> data = new HashMap<String, Object>();
		String suiteCode = request.getParameter("suite_code");
		String moduleCode = request.getParameter("module_code");
		String privGroupCode = request.getParameter("priv_grp_code");

		List<Suite> suites = sprintDao.getAllSuites();

		Map<String, String> suiteCodes = new LinkedHashMap<String, String>();

		if (suiteCode == null || suiteCode.isEmpty()) {
			suiteCodes.put("-1", "--SELECT--");
		}

		for (int i = 0; i < suites.size(); i++) {
			suiteCodes.put(suites.get(i).getSuiteCode(), suites.get(i).getSuiteShortName());
		}

		List<Module> modules = sprintDao.getBySuit(suiteCode);

		Map<String, String> moduleCodes = new LinkedHashMap<String, String>();

		if (moduleCode == null || moduleCode.isEmpty()) {
			moduleCodes.put("-1", "--SELECT--");
		}

		for (int i = 0; i < modules.size(); i++) {
			moduleCodes.put(modules.get(i).getModCode(), modules.get(i).getModShortName());
		}

		List<PrivGroup> privGrpLi = sprintDao.getPrivGroup(suiteCode, moduleCode);

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

		return new ModelAndView("sprintmanager/create", "data", data);
	}

	@RequestMapping(value = "/sprintlist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Override
	public ModelAndView sprintList() {
		Map<String, Object> data = new HashMap<String, Object>();
		List<SprintManager> sprintlist = sprintService.getAll();

		GsonBuilder gson = new GsonBuilder();
		Gson g = gson.create();

		data.put("sprintlist", sprintlist);

		return new ModelAndView("sprintmanager/sprintlist", "data", data);
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

	@ResponseBody
	@Override
	public ModelAndView showChart(@PathVariable(value = "id") UUID id) {
		Map<String, Object> sprintViewDetails = sprintService.getBySprintId(id);
		GsonBuilder gson = new GsonBuilder();
		Gson g = gson.create();
		System.out.println(g.toJson(sprintViewDetails));
		return new ModelAndView("sprintmanager/burndownchart", "map", g.toJson(sprintViewDetails));
	}
	//old burndown chart
	@RequestMapping(value = "/spentchart/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView showSpentChart(@PathVariable(value = "id") UUID id) {
		Map<String, Object> map = sprintService.getSprintSpentChartData(id);
		List<Tasks> taskslist = (List<Tasks>)map.get("task");
		List<String> sp = (List<String>)map.get("spenttime");
		List<Object> chart = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		for(int i=0; i<taskslist.size(); i++){
			List<Object> querychart = new ArrayList<>();
			querychart.add(taskslist.get(i).getTaskTitle());
			querychart.add(convertTimetoHours(sp.get(i)));
			querychart.add(String.valueOf(convertTimetoHours(sp.get(i))));
			chart.add(i, querychart);
		}
		GsonBuilder gson = new GsonBuilder();
		Gson g = gson.create();
		map.put("chart", chart);
		System.out.println(g.toJson(map));
		return new ModelAndView("sprintmanager/spentchart", "map", g.toJson(map));
	}
	public double convertTimetoHours(String time){
		long hh =(Integer.parseInt(time.split(":")[0])>0)? (Long.parseLong(time.split(":")[0]))*3600000:0;
		long mm =(Integer.parseInt(time.split(":")[1])>0)? (Long.parseLong(time.split(":")[1]))*60000:0;
		long ss =(Integer.parseInt(time.split(":")[2])>0)? (Long.parseLong(time.split(":")[2]))*1000:0;
		
		DecimalFormat df = new DecimalFormat("##.##");
		double hours = ((hh+mm+ss)>0)?(hh+mm+ss)/3600000.0:0;		
		return Double.parseDouble(df.format(hours));
		
	}
	@RequestMapping(value = "/burndownchart/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ModelAndView showSpentChartData(@PathVariable(value = "id") UUID id) {
		Map<String, Object> map = sprintService.getDocByBurnDownChartData(id);
		GsonBuilder gson = new GsonBuilder();
		Gson g = gson.create();
		System.out.println(g.toJson(map));
		return new ModelAndView("sprintmanager/burndownchart", "map", g.toJson(map));
	}

	

}