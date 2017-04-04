package com.ctrends.taskmanager.dao.report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ctrends.taskmanager.bean.Utility;
import com.ctrends.taskmanager.dao.user.IUserDAO;
import com.ctrends.taskmanager.model.dailysummary.DailySummary;
import com.ctrends.taskmanager.model.tman.TaskLog;
import com.ctrends.taskmanager.model.tman.TaskReportView;
import com.ctrends.taskmanager.model.tman.Tasks;
import com.ctrends.taskmanager.model.user.User;
import com.ctrends.taskmanager.service.user.IUserService;
import java.util.Iterator;

@Repository("taskReportDAO")
public class TaskReportDAO implements ITaskReportDAO {

	@Autowired
	private SessionFactory sessionfactory;

	@Autowired
	IUserDAO userDAO;

	@Autowired
	IUserService userService;

	@Transactional
	@Override
	public List<Tasks> getAllDoc() {

		Query query = sessionfactory.getCurrentSession().createQuery("From Tasks");

		List<Tasks> tasksLogReport = query.list();
		return tasksLogReport;
	}

	@Transactional
	@Override
	public List<Tasks> getDocs(Map<String, String> request) {

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
/*	
	@Override
	public List<TaskLog> getAllTaskLog(Map<String, Object> parameterMap) {
		// User currentUser = userDAO.getCurrentUser();

		Query query = sessionfactory.getCurrentSession().createQuery("FROM TaskLog");
		// query.setParameter("companyCode", parameterMap.get("companyCode"));
		// System.out.println("startDate"+parameterMap.get("startDate")+"ggggggggggggg");
		
		 * query.setParameter("empCode", parameterMap.get("empCode"));
		 * query.setParameter("empName", parameterMap.get("empName"));
		 * query.setParameter("username", parameterMap.get("username"));
		 
		// query.setParameter("startDate",
		// parameterMap.get("startDate")).uniqueResult();

		List<TaskLog> tLoglist = query.list();

		System.out.println(tLoglist.get(0).getStartDate() + "sdfghjkkkkkkkkkkkkkkkkk");

		if (query.list().size() > 0) {
			return tLoglist;
		}

		return null;
	}
	*/
	
	
	
	@Override
	public HashMap<String, Object> getTaskReportElement(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	@Override
	public List<Tasks> getAllTasks(Map<String, Object> request) {
		// User currentUser = userDAO.getCurrentUser();

		Query query = sessionfactory.getCurrentSession().createQuery(
				"FROM Tasks WHERE companyCode = :companyCode and empCode=:empCode and empName=:empName and username=:username");

		query.setParameter("companyCode", request.get("companyCode"));
		// System.out.println("companyCode"+request.get("companyCode")+"ggggggggggggg");
		query.setParameter("empCode", request.get("empCode"));
		query.setParameter("empName", request.get("empName"));
		query.setParameter("username", request.get("username"));
		// query.setParameter("startDate", request.get("startDate"));

		List<Tasks> tlist = query.list();

		if (query.list().size() > 0) {
			return tlist;
		}
		return null;
	}
	*/
	
	public List<TaskReportView> getUserWiseDailyTasks(Map<String, String> request){
		
		String startDate = request.get("startDate");
		
		
		List<TaskReportView> taskReportViewList = new ArrayList<>();
		TaskReportView taskReportView = null;

		Query query = sessionfactory.getCurrentSession().createQuery(
				"FROM Tasks WHERE companyCode = :companyCode and empCode=:empCode and empName=:empName and username=:username");

		query.setParameter("companyCode", request.get("companyCode"));
		query.setParameter("empCode", request.get("empCode"));
		query.setParameter("empName", request.get("empName"));
		query.setParameter("username", request.get("username"));

		List<Tasks> tlist = query.list();
		
		if(tlist.size()>0){
			List<TaskLog> tempTaskLogList = null;
			Tasks tempTask = null;
			for(int i =0; i<tlist.size(); i++){
				tempTask = tlist.get(i);
				tempTaskLogList = getTaskLogByTaskIdAndDate(tempTask.getId(), startDate);
				if(tempTaskLogList != null && tempTaskLogList.size()>0){
					taskReportView = new TaskReportView();
					taskReportView.setTaskId(tempTask.getId().toString());
					taskReportView.setTaskTitle(tempTask.getTaskTitle());
					taskReportView.setTaskCode(tempTask.getTaskCode());
					taskReportView.setStoryTitle(tempTask.getStoryTitle());
					taskReportView.setTaskLogList(tempTaskLogList);
					
					long spentTimes= 0;
					for(int j=0; j<tempTaskLogList.size(); j++){
						
						if(tempTaskLogList.get(j).getStartTime()!=null && tempTaskLogList.get(j).getStopTime()!=null  ){
							spentTimes += tempTaskLogList.get(j).getStopTime().getTime() - tempTaskLogList.get(j).getStartTime().getTime();
						}
					}
					
					String totalSpentTime = spentTimeCalculation(spentTimes);
					taskReportView.setTotalDaySpentTime(totalSpentTime);
					taskReportViewList.add(taskReportView);
				}
			}
			
		}
		
		
		if(taskReportViewList.size()>0){
			return taskReportViewList;
		}
		
		
		return null;
	}
	
	public List<TaskLog> getTaskLogByTaskIdAndDate(UUID taskId, String start_date){
		
		
		java.util.Date startDate = Utility.stringToDate(start_date);
		
		
		Query query = sessionfactory.getCurrentSession().createQuery(
				"FROM TaskLog WHERE taskId = :taskId and startDate=:startDate");

		query.setParameter("taskId", taskId.toString());
		query.setParameter("startDate", startDate);

		List<TaskLog> tlogList = query.list();
		if(tlogList.size()>0){
			return tlogList;
		}
		return null;
	}
	
	public String spentTimeCalculation(long millisecons){
		return String.format("%02d:%02d:%02d", 
				TimeUnit.MILLISECONDS.toHours(millisecons),
				TimeUnit.MILLISECONDS.toMinutes(millisecons) -  
				TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisecons)), // The change is in this line
				TimeUnit.MILLISECONDS.toSeconds(millisecons) - 
				TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisecons)));
		
		
	}
	
	@Transactional
	public Map<String, Object> getAllDocByToDate(TaskLog tasklog) {
		Map<String, Object> map = new HashMap<>();

		String sql = "select cast(sum(stop_time-start_time) as string) from TaskLog where stopDate=:date GROUP BY taskId";
		Query query = sessionfactory.getCurrentSession().createQuery(sql);
		query.setParameter("date", tasklog.getStopDate());
		List list = query.list();

		String sqlt = "select taskId,createdByName from TaskLog where stopDate=:date GROUP BY taskId,createdByName";
		Query queryt = sessionfactory.getCurrentSession().createQuery(sqlt);
		queryt.setParameter("date", tasklog.getStopDate());
		List<Object>listt = queryt.list();

		UUID[] id = new UUID[listt.size() + 1];
		String[] name= new String [listt.size()+1];
		
		
		int c = 0;
		
		for(Iterator it=(Iterator) queryt.iterate();((java.util.Iterator) it).hasNext();)
		  {
		   Object[] row = (Object[]) ((java.util.Iterator) it).next();
		   System.out.print("Course Name: " + row[0]);
		   System.out.println(" | Number of Students: " + row[1]);
		   id[c]=UUID.fromString(row[0].toString());
		   name[c++]=row[1].toString();
		   
		  }
		
		Criteria cr = sessionfactory.getCurrentSession().createCriteria(Tasks.class);
		cr.add(Restrictions.in("id", id));
		List<Tasks> t = (List<Tasks>) cr.list();
		
		System.out.println(t+"dao exam");	
		
		List<DailySummary> dsum = new ArrayList<>();
		int c1 = 0;
		for (Tasks tt : t) {
			DailySummary dd = new DailySummary();
			dd.setId(tt.getId());
			dd.setTaskCode(tt.getTaskCode());
			dd.setSpentTimeTemp(list.get(c1).toString());
			dd.setSuiteName(tt.getSuiteName());
			dd.setModuleName(tt.getModuleName());
			dd.setPrivGrpName(tt.getPrivGrpName());
			dd.setPrivilegeName(tt.getPrivilegeName());
			dd.setEmpCode(tt.getEmpCode());
			dd.setEmpName(tt.getEmpName());
			dd.setTaskTitle(tt.getTaskTitle());
			dd.setStartDate(tasklog.getStopDate());	
			dd.setUsername(name[c1]);
			dsum.add(c1++, dd);			
		}
		map.put("dsummery", dsum);
		return map;
	}


}