package com.ctrends.taskmanager.dao.tman_sprint;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.ctrends.taskmanager.dao.ICommonDAO;
import com.ctrends.taskmanager.model.taskmanage.Module;
import com.ctrends.taskmanager.model.taskmanage.PrivGroup;
import com.ctrends.taskmanager.model.taskmanage.Suite;
import com.ctrends.taskmanager.model.tman.TaskLog;
import com.ctrends.taskmanager.model.tman_sprint.SprintManager;
import com.ctrends.taskmanager.model.tman_sprint.SprintManagerDetails;

public interface ISprintDAO extends ICommonDAO<SprintManager> {
	List<Suite> getAllSuites();
	List<PrivGroup> getAllPrivGrps();
	List<Module> getAllModules();
	List<Module> getBySuit(String suitCode);
	public List<PrivGroup> getPrivGroup(String suiteCode, String modeCode);
	boolean checkUnique(Map<String, Object> param);
	UUID updateDetail(SprintManagerDetails sprintDetail);
	List<SprintManagerDetails> findBySprintCode(String sprintCode);
	public List<SprintManagerDetails> getDocByIdStoryCode(String storyCode);
	public SprintManagerDetails getDocByIdSprintCode(String sprintCode);
	List<SprintManagerDetails> getDocBySprintId(UUID sprintId);
	List<TaskLog> gettasklogLiById(String taskId, Date stopDate);
}
