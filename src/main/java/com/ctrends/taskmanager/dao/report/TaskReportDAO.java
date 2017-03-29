package com.ctrends.taskmanager.dao.report;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ctrends.taskmanager.dao.user.IUserDAO;
import com.ctrends.taskmanager.model.tman.TaskLog;
import com.ctrends.taskmanager.model.tman.Tasks;
import com.ctrends.taskmanager.model.user.User;
import com.ctrends.taskmanager.service.user.IUserService;

@Repository("taskReportDAO")
public class TaskReportDAO implements ITaskReportDAO{
	
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
		Query query = sessionfactory.getCurrentSession().createQuery("From Tasks where username =:userName");
		query.setParameter("userName", currentUser.getUsername());
		List<Tasks> tasksLogReport = query.list();
		return tasksLogReport;
	}

	@Transactional
	@Override
	public List<Tasks> getDocs(Map<String, String> request) {
		//User currentUser = userDAO.getCurrentUser();
		
	Query query = sessionfactory.getCurrentSession().createQuery("FROM Tasks WHERE companyCode = :companyCode and empCode=:empCode and empName=:empName and username=:username");
		
		query.setParameter("companyCode", request.get("companyCode"));
		//System.out.println("companyCode"+request.get("companyCode")+"ggggggggggggg");
		query.setParameter("empCode", request.get("empCode"));
		query.setParameter("empName", request.get("empName"));
		query.setParameter("username", request.get("username"));
		//query.setParameter("startDate", request.get("startDate"));
		
		List<Tasks> tlist = query.list();
		
		
		if (query.list().size() > 0) {
			return tlist;
		}

		return null;
	}
	


	@Override
	public UUID deleteDoc(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Tasks getDocById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public UUID insertDoc(Tasks doc) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public UUID updateDoc(Tasks doc) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public List<TaskLog> getDocsTwo(Map<String, Object> parameterMap) {
		//User currentUser = userDAO.getCurrentUser();
		
	Query query = sessionfactory.getCurrentSession().createQuery("FROM TaskLog");
		//query.setParameter("companyCode", parameterMap.get("companyCode"));
		//System.out.println("startDate"+parameterMap.get("startDate")+"ggggggggggggg");
		/*query.setParameter("empCode", parameterMap.get("empCode"));
		query.setParameter("empName", parameterMap.get("empName"));
		query.setParameter("username", parameterMap.get("username"));*/
		//query.setParameter("startDate", parameterMap.get("startDate"));
		
		List<TaskLog> tLoglist = query.list();
		
		System.out.println(tLoglist.get(0).getStartDate()+"sdfghjkkkkkkkkkkkkkkkkk");
		
		if (query.list().size() > 0) {
			return tLoglist;
		}

		return null;
	}

	@Override
	public HashMap<String, Object> getTaskReportElement(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}
	

/*	@Transactional
	@Override
	public HashMap<String, Object> getTaskReportElement(Map<String, Object> params) {
		HashMap<String, Object> reportElement = new HashMap<String, Object>();
		Session session = sessionfactory.getCurrentSession();
		
		Criteria taskCriteria = session.createCriteria(Tasks.class);
		List res = taskCriteria.list();
		for(int i=0; i<res.size();i++){
			System.out.println(res.get());
			
		}
		
		return reportElement;
	}*/

//	@Transactional
//	public HashMap<String, Object> getTaskReportElement(Map<String, Object> params) {
//		HashMap<String, Object> reportElement = new HashMap<String, Object>();
//		Session session = sessionfactory.getCurrentSession();
//		
//		Criteria employeeCriteria = session.createCriteria(Tasks.class);
//		Tasks employee = (Tasks)employeeCriteria.add(Restrictions.eq("empCode", params.get("empCode")))
//		                             .uniqueResult();
//		
//		TaskLog taskLog = (TaskLog)employeeCriteria.add(Restrictions.eq("companyCode", params.get("companyCode")))
//                .uniqueResult();
//		
//		Criteria reportSettingcriteria = session.createCriteria(HrReportSettings.class);
//		HrReportSettings reportSetting = (HrReportSettings)reportSettingcriteria.add(Restrictions.eq("companyCode", employee.getCompanyCode()))
//		                             .uniqueResult();
//		reportElement.put("employee", employee);
//		reportElement.put("reportSetting", taskLog);
//		
//		return reportElement;
//	}
}
