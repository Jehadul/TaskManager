package com.ctrends.taskmanager.service.tman_sprint;

import java.util.List;
import java.util.UUID;

import com.ctrends.taskmanager.model.tman_sprint.SprintManager;
import com.ctrends.taskmanager.model.tman_sprint.SprintManagerDetails;
import com.ctrends.taskmanager.model.tman_sprint.SprintView;
import com.ctrends.taskmanager.service.ICommonService;

public interface ISprintService extends ICommonService<SprintManager> {

	public List<SprintManagerDetails> getByIdSprintCode(String sprintCode);

	List<SprintView> getBySprintId(UUID id);

}
