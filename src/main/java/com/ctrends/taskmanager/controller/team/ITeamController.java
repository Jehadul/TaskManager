package com.ctrends.taskmanager.controller.team;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.ctrends.taskmanager.controller.ICommonController;
import com.ctrends.taskmanager.model.team.Team;

public interface ITeamController extends ICommonController<Team> {

	ModelAndView create(HttpServletRequest request);

}
