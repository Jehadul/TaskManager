package com.ctrends.taskmanager.dao.tman;

import java.util.List;
import java.util.UUID;

import com.ctrends.taskmanager.dao.ICommonDAO;
import com.ctrends.taskmanager.model.taskmanage.Module;
import com.ctrends.taskmanager.model.taskmanage.PrivGroup;
import com.ctrends.taskmanager.model.taskmanage.Privilege;
import com.ctrends.taskmanager.model.taskmanage.Suite;
import com.ctrends.taskmanager.model.tman.TaskLog;
import com.ctrends.taskmanager.model.tman.Tasks;

public interface ITasksDao extends ICommonDAO<Tasks> {
	List<Suite> getAllSuites();
	List<PrivGroup> getAllPrivGrps();
	List<Module> getAllModules();
	List<Module> getBySuit(String suitCode);
	public List<PrivGroup> getPrivGroup(String suiteCode, String modeCode);
	public UUID insertTaskLogDoc(TaskLog taskLog);
	public TaskLog getDocByIdTimeLog(UUID id);
	
	public UUID updateTaskLogDoc(TaskLog doc);
	List<Tasks> getDocsByCurrentUser();
	List<Tasks> getCurrentTaskByCurrentUser();
	public UUID updateSpantTimeDoc(Tasks doc);
	List<Privilege> getBy(String suitCode, String modCode, int prvGrpCode);
}
