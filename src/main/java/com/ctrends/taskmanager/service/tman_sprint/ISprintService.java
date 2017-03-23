package com.ctrends.taskmanager.service.tman_sprint;

import java.util.List;

import com.ctrends.taskmanager.model.tman_sprint.SprintManager;
import com.ctrends.taskmanager.model.tman_sprint.SprintManagerDetails;
import com.ctrends.taskmanager.service.ICommonService;

public interface ISprintService extends ICommonService<SprintManager> {

	public List<SprintManagerDetails> getByIdSprintCode(String sprintCode);

}
