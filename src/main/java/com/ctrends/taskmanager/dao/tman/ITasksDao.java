package com.ctrends.taskmanager.dao.tman;

import java.util.List;
import java.util.UUID;

import com.ctrends.taskmanager.dao.ICommonDao;
import com.ctrends.taskmanager.model.taskmanage.Module;
import com.ctrends.taskmanager.model.taskmanage.PrivGroup;
import com.ctrends.taskmanager.model.taskmanage.Suite;
import com.ctrends.taskmanager.model.tman.TaskLog;
import com.ctrends.taskmanager.model.tman.Tasks;

public interface ITasksDao extends ICommonDao<Tasks> {
	List<Suite> getAllSuites();
	List<PrivGroup> getAllPrivGrps();
	List<Module> getAllModules();
	List<Module> getBySuit(String suitCode);
	public List<PrivGroup> getPrivGroup(String suiteCode, String modeCode);
	public UUID insertTaskLogDoc(TaskLog taskLog);
}
