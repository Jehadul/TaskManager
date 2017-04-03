package com.ctrends.taskmanager.controller.team;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ctrends.taskmanager.bean.WSResponse;
import com.ctrends.taskmanager.model.team.Team;
import com.ctrends.taskmanager.model.team.TeamMemberDetails;
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
		/*List<TeamMemberDetails> teamMemberDetailsList = null;
		for(int i=0; i<teamLi.size(); i++){
			teamMemberDetailsList = teamLi.get(i).getTeamDetails();
			System.out.println(teamMemberDetailsList + "aaaaaaaaaaaaaaa");
		}
		*/
		System.out.println("ggggggggggg" + teamLi.get(0).getId());
		
		GsonBuilder gson = new GsonBuilder();
		System.out.println("ggggggggggg" + teamLi.get(0).getTeamDetails());
		Gson g = gson.create();
		data.put("teamLi", teamLi);
		return new ModelAndView("team/teamlist", "data", data);
	}

	@Override
	public ModelAndView show(UUID id) {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public ModelAndView edit(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WSResponse update(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WSResponse destroy(HttpServletRequest request) {
		// TODO Auto-generated method stub
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
	
	@RequestMapping(value = "/create", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public ModelAndView create(HttpServletRequest request) {

		
		return new ModelAndView("team/create");

	}

}
