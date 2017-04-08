package com.ctrends.taskmanager.controller.team;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ctrends.taskmanager.bean.WSResponse;
import com.ctrends.taskmanager.model.team.Team;
import com.ctrends.taskmanager.model.team.TeamDetails;
import com.ctrends.taskmanager.model.tman_sprint.SprintManager;
import com.ctrends.taskmanager.model.userstory.UserStory;
import com.ctrends.taskmanager.service.team.ITeamService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
@RequestMapping("/taskman/team")
public class TeamController implements ITeamController {

	@Autowired
	ITeamService teamService;
	
	
	@RequestMapping(value = "/teamlist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Override
	public ModelAndView index() {
		Map<String, Object> data = new HashMap<String, Object>();
		List<Team> teamLi = teamService.getAll();
		List<TeamDetails> teamMemberDetails = null;
		for (int i=0; i<teamLi.size(); i++){
			teamMemberDetails=teamLi.get(i).getTeamDetails();
		}
		GsonBuilder gson = new GsonBuilder();
		Gson g = gson.create();
		data.put("teamLi", teamLi);
		data.put("teamMemberDetails", teamMemberDetails);
		return new ModelAndView("team/teamlist", "data", data);
	}

	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Override
	public ModelAndView show(@PathVariable(value = "id") UUID id) {
		Team team = teamService.getById(id);
		List<TeamDetails> teamMemberDetailsList = teamService.getTeamMemberDetailsByTeamId(id);
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("team", team);
		map.put("teamMemberDetailsList", teamMemberDetailsList);
		return new ModelAndView("team/show", "map", map);
	}

	@Override
	public WSResponse get(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView create() {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value = "/store", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public WSResponse store(HttpServletRequest request) {
		Map<String, String[]> team = request.getParameterMap();

		Map<String, String> data = teamService.insert(team);

		return new WSResponse("success", "Saved successfully", UUID.fromString(data.get("id")), null, data.get("mode"),
				data);
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Override
	public ModelAndView edit(@PathVariable(value = "id") UUID id) {
		

		Map<String, Object> map = new HashMap<String, Object>();
		
		Team team=teamService.getById(id);
		List<TeamDetails> teamMemberDetailsList = teamService.getTeamMemberDetailsByTeamId(id);
		
		
		map.put("mode", "doc");
		map.put("team", team);
		map.put("teamMemberDetailsList", teamMemberDetailsList);
		return new ModelAndView("team/edit", "map", map);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public WSResponse update(HttpServletRequest request) {
		Map<String, String[]> teamManager = request.getParameterMap();
		Map<String, String> data = teamService.update(teamManager);
		
		return new WSResponse("success", "Updated Successfully", UUID.fromString(data.get("id")), null,
				data.get("mode"), data);

	}

	
	@RequestMapping(value = "/delete", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public WSResponse destroy(HttpServletRequest request) {
		Map<String, String[]> teamRequest = request.getParameterMap();
		
		UUID id = teamService.delete(teamRequest);
		
		return new WSResponse("success", "Team deleted successfully", id, null, "doc",null);
	}

	@RequestMapping(value = "/searchteam", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public ModelAndView showSearch(@Context HttpServletRequest request) {
		String actionTypeCode = request.getParameter("action_type_code");
		Map<String, Object> data = new HashMap<String, Object>();
		
		System.out.println("actionTypeCode::"+actionTypeCode);
		data.put("action_type_code", actionTypeCode);
		return new ModelAndView("team/searchteam", "data", data);
	}

	@RequestMapping(value = "/teamsearch", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public String search(@Context HttpServletRequest request) {
		Map<String, String> searchingKey = new HashMap<String, String>();

		if(request.getParameter("team_code")==null){
			searchingKey.put("teamCode", "");
		}else{
			searchingKey.put("teamCode", request.getParameter("team_code"));
		}
		
		if(request.getParameter("team_name")==null){
			searchingKey.put("teamName", "");
		}else{
			searchingKey.put("teamName", request.getParameter("team_name"));
		}
		List<Team> data = teamService.find(searchingKey);
		
		GsonBuilder gBuilder = new GsonBuilder();
		Gson gson = gBuilder.create();
		
		System.out.println(":::"+gson.toJson(data));
		return gson.toJson(data);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public ModelAndView create(HttpServletRequest request) {
		return new ModelAndView("team/create");

	}
	


}
