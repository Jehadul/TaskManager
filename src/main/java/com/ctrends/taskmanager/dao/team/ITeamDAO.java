package com.ctrends.taskmanager.dao.team;

import java.util.Map;

import com.ctrends.taskmanager.dao.ICommonDAO;
import com.ctrends.taskmanager.model.team.Team;

public interface ITeamDAO extends ICommonDAO<Team> {

	boolean checkUnique(Map<String, Object> param);

}
