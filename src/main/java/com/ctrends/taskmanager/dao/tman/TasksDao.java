package com.ctrends.taskmanager.dao.tman;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ctrends.taskmanager.dao.user.IUserDAO;
import com.ctrends.taskmanager.dao.user.UserDAO;
import com.ctrends.taskmanager.model.taskmanage.Module;
import com.ctrends.taskmanager.model.taskmanage.PrivGroup;
import com.ctrends.taskmanager.model.taskmanage.Privilege;
import com.ctrends.taskmanager.model.taskmanage.Suite;
import com.ctrends.taskmanager.model.tman.TaskLog;
import com.ctrends.taskmanager.model.tman.Tasks;
import com.ctrends.taskmanager.model.user.User;
import com.ctrends.taskmanager.service.user.IUserService;

@Repository("tasksDao")
public class TasksDao implements ITasksDao {

	@Autowired
	private SessionFactory sessionfactory;
	
	@Autowired
	IUserDAO userDAO;

	@Autowired
	IUserService userService;

	@Transactional
	@Override
	public List<Tasks> getAllDoc() {
		User currentUser = userService.getCurrentUser();
		Query query = sessionfactory.getCurrentSession().createQuery("From Tasks where createdByUsername =:userName");
		query.setParameter("userName", currentUser.getUsername());
		List<Tasks> tasksLi = query.list();
		return tasksLi;
	}

	@Transactional
	@Override
	public Tasks getDocById(UUID id) {
		Query query = sessionfactory.getCurrentSession().createQuery("From Tasks WHERE id = :id");
		query.setParameter("id", id);
		Tasks tasks = (Tasks) query.uniqueResult();
		if (tasks == null) {
			throw new UsernameNotFoundException("User with username '" + id + "' does not exist.");
		}
		/* System.out.println(user.getEmpName()); */
		return tasks;
	}

	@Transactional
	@Override
	public List<Tasks> getDocs(Map<String, String> params) {

		Query query = sessionfactory.getCurrentSession()
				.createQuery("from Tasks where taskTitle like :taskTitle and " + "asignee like :asignee");

		query.setParameter("taskTitle", "%" + params.get("taskTitle") + "%");
		query.setParameter("asignee", "%" + params.get("asignee") + "%");

		List<Tasks> tasksList = query.list();

		return tasksList;

	}

	@Transactional
	@Override
	public UUID insertDoc(Tasks doc) {
		UUID id = (UUID) sessionfactory.getCurrentSession().save(doc);
		sessionfactory.getCurrentSession().flush();
		return id;
	}

	@Transactional
	@Override
	public UUID insertTaskLogDoc(TaskLog doc) {
		UUID id = (UUID) sessionfactory.getCurrentSession().save(doc);
		sessionfactory.getCurrentSession().flush();
		return id;
	}

	@Transactional
	@Override
	public UUID updateDoc(Tasks doc) {
		sessionfactory.getCurrentSession().saveOrUpdate(doc);
		sessionfactory.getCurrentSession().flush();
		return doc.getId();
	}

	@Transactional
	@Override
	public UUID deleteDoc(UUID id) {
		Tasks app = (Tasks) sessionfactory.getCurrentSession().load(Tasks.class, id);
		sessionfactory.getCurrentSession().delete(app);
		sessionfactory.getCurrentSession().flush();
		return id;
	}

	@Transactional
	@Override
	public List<Suite> getAllSuites() {
		Query query = sessionfactory.getCurrentSession().createQuery("From Suite");
		List<Suite> suiteLi = query.list();
		return suiteLi;
	}

	@Transactional
	@Override
	public List<Module> getAllModules() {
		Query query = sessionfactory.getCurrentSession().createQuery("From Module");
		List<Module> moduleLi = query.list();
		return moduleLi;
	}

	@Transactional
	@Override
	public List<Module> getBySuit(String suitCode) {
		Query query = sessionfactory.getCurrentSession()
				.createQuery("from Module where suiteCode =:suiteCode order by modSeq");
		query.setParameter("suiteCode", suitCode);
		List<Module> modList = query.list();

		return modList;
	}

	@Transactional
	@Override
	public List<PrivGroup> getAllPrivGrps() {
		Query query = sessionfactory.getCurrentSession().createQuery("From PrivGroup");
		List<PrivGroup> privgrpLi = query.list();
		return privgrpLi;
	}

	@Transactional
	@Override
	public List<PrivGroup> getPrivGroup(String suiteCode, String modeCode) {
		String hqlQuery = "from PrivGroup where suiteCode =:suiteCode and  modCode =:modCode order by privGrpCode";
		Query query = sessionfactory.getCurrentSession().createQuery(hqlQuery);
		query.setParameter("suiteCode", suiteCode);
		query.setParameter("modCode", modeCode);
		List<PrivGroup> privGroup = query.list();
		return privGroup;
	}

	@Transactional
	@Override
	public TaskLog getDocByIdTimeLog(UUID id) {
		Query query = sessionfactory.getCurrentSession()
				.createQuery("From TaskLog WHERE taskId = :id and stopStatus=:status");
		query.setParameter("id", id);
		query.setParameter("status", "false");
		List<TaskLog> taskslogli = query.list();
		// TaskLog tasks = (TaskLog) query.uniqueResult();
		// if (tasks == null) {
		// throw new UsernameNotFoundException("User with username '" + id + "'
		// does not exist.");
		// }
		// /* System.out.println(user.getEmpName());*/
		// return tasks;
		if (taskslogli.size() > 0) {
			return taskslogli.get(0);
		}
		return null;

	}

	@Transactional
	@Override
	public UUID updateTaskLogDoc(TaskLog doc) {
		sessionfactory.getCurrentSession().saveOrUpdate(doc);
		sessionfactory.getCurrentSession().flush();
		return doc.getId();
	}

	@Override
	@Transactional
	public List<Tasks> getDocsByCurrentUser() {
		User currentUser = userService.getCurrentUser();
		Query query = sessionfactory.getCurrentSession().createQuery("From Tasks where createdByUsername =:userName");
		query.setParameter("userName", currentUser.getUsername());
		List<Tasks> tasksLi = query.list();
		return tasksLi;
	}

	@Override
	@Transactional
	public List<Tasks> getCurrentTaskByCurrentUser() {
		User currentUser = userService.getCurrentUser();
		Query query = sessionfactory.getCurrentSession()
				.createQuery("From TaskLog where createdByUsername =:userName and stopStatus =:stopStatus");
		query.setParameter("userName", currentUser.getUsername());
		query.setParameter("stopStatus", "false");
		List<TaskLog> tasksLi = query.list();

		Query query1 = sessionfactory.getCurrentSession().createQuery("From Tasks where id =:id");

		if (query.list().size() > 0) {
			query1.setParameter("id", tasksLi.get(0).getTaskId());
			return query1.list();
		}

		return null;
	}

	@Transactional
	@Override
	public UUID updateSpantTimeDoc(Tasks doc) {
		sessionfactory.getCurrentSession().saveOrUpdate(doc);
		sessionfactory.getCurrentSession().flush();
		return doc.getId();
	}

//	@Transactional
//	@Override
//	public List<Privilege> getBy(String suitCode, String modCode, int prvGrpCode) {
//		String hqlQuery = "from Privilege where suiteCode =:suiteCode and  modCode =:modCode and  privGrpCode =:privGrpCode order by privSeq";
//		Query query = sessionfactory.getCurrentSession().createQuery(hqlQuery);
//		query.setParameter("suiteCode", suitCode);
//		query.setParameter("modCode", modCode);
//		query.setParameter("privGrpCode", prvGrpCode);
//		List<Privilege> privilege = query.list();
//		return privilege;
//	}

	@Override
	@Transactional
	public TaskLog getRunningTaskByCurrentUser1() {
		User currentUser = userService.getCurrentUser();
		Query query = sessionfactory.getCurrentSession()
				.createQuery("From TaskLog where createdByUsername =:userName and stopStatus =:stopStatus");
		query.setParameter("userName", currentUser.getUsername());
		query.setParameter("stopStatus", "false");
		List<TaskLog> tasksLi = query.list();
		if (tasksLi.size() > 0) {
			return tasksLi.get(0);
		}
		return null;
	}

	@Transactional
	@Override
	public boolean checkUnique(Map<String, String> requestMap) {
		User currentUser = userDAO.getCurrentUser();
		String companyCode = currentUser.getCompanyCode();
		Query query = sessionfactory.getCurrentSession().createQuery("FROM Tasks WHERE taskCode =:taskCode AND companyCode=:companyCode");
		query.setParameter("companyCode",companyCode);
		query.setParameter("taskCode", requestMap.get("taskCode"));
		
		
		Tasks tasks=(Tasks) query.uniqueResult();
		

	    if (tasks == null) {
        	return true;
        }
        else{
        	return false;
        }
	}

}
