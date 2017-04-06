package com.ctrends.taskmanager.dao.tman_sprint;

import java.sql.Date;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ctrends.taskmanager.bean.Utility;
import com.ctrends.taskmanager.dao.user.IUserDAO;
import com.ctrends.taskmanager.model.taskmanage.Module;
import com.ctrends.taskmanager.model.taskmanage.PrivGroup;
import com.ctrends.taskmanager.model.taskmanage.Suite;
import com.ctrends.taskmanager.model.tman.TaskLog;
import com.ctrends.taskmanager.model.tman.Tasks;
import com.ctrends.taskmanager.model.tman_sprint.BurndownChart;
import com.ctrends.taskmanager.model.tman_sprint.SprintManager;
import com.ctrends.taskmanager.model.tman_sprint.SprintManagerDetails;
import com.ctrends.taskmanager.model.user.User;
import com.ctrends.taskmanager.service.user.IUserService;

@Repository("sprintDAO")
public class SprintDAO implements ISprintDAO {

	@Autowired
	private SessionFactory sessionfactory;

	@Autowired
	IUserDAO userDAO;

	@Autowired
	IUserService userService;

	@Transactional
	@Override
	public List<SprintManager> getAllDoc() {
		User currentUser = userService.getCurrentUser();
		Query query = sessionfactory.getCurrentSession()
				.createQuery("From SprintManager where createdByUsername =:userName");
		query.setParameter("userName", currentUser.getUsername());
		List<SprintManager> splist = query.list();
		return splist;
	}

	@Transactional
	@Override
	public SprintManager getDocById(UUID id) {
		Query query = sessionfactory.getCurrentSession().createQuery("From SprintManager WHERE id = :id");
		query.setParameter("id", id);
		List<SprintManager> pt = query.list();
		if (pt.size() > 0) {
			return pt.get(0);
		}
		return null;
	}

	@Transactional
	@Override
	public SprintManagerDetails getDocByIdSprintCode(String sprintStoryCode) {
		Query query = sessionfactory.getCurrentSession()
				.createQuery("From SprintManagerDetails WHERE sprintStoryCode = :sprintStoryCode");
		query.setParameter("sprintStoryCode", sprintStoryCode);
		List<SprintManagerDetails> pt = query.list();
		if (pt.size() > 0) {
			return pt.get(0);
		}
		return null;
	}

	@Transactional
	@Override
	public List<SprintManagerDetails> getDocByIdStoryCode(String sprintCode) {
		Query query = sessionfactory.getCurrentSession()
				.createQuery("From SprintManagerDetails WHERE sprintCode = :sprintCode");
		query.setParameter("sprintCode", sprintCode);
		List<SprintManagerDetails> pt = query.list();

		return pt;
	}

	@Override
	public List<SprintManager> getDocs(Map<String, String> params) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @Transactional
	 * 
	 * @Override public UUID insertDoc(SprintManager doc) { UUID id = (UUID)
	 * sessionfactory.getCurrentSession().save(doc);
	 * sessionfactory.getCurrentSession().flush(); return id; }
	 */
	@Transactional
	@Override
	public UUID insertDoc(SprintManager sprint) {
		UUID id = (UUID) sessionfactory.getCurrentSession().save(sprint);
		sessionfactory.getCurrentSession().flush();

		for (int i = 0; i < sprint.getSteps().size(); i++) {
			SprintManagerDetails sprintDetails = new SprintManagerDetails();
			sprintDetails = (SprintManagerDetails) sprint.getSteps().get(i);
			sprintDetails.setSprintId(id);
			sessionfactory.getCurrentSession().save(sprintDetails);
			sessionfactory.getCurrentSession().flush();
		}
		for (int i = 0; i < sprint.getCharts().size(); i++) {
			BurndownChart burndownChart = new BurndownChart();
			burndownChart = (BurndownChart) sprint.getCharts().get(i);
			burndownChart.setSprintID(id);
			sessionfactory.getCurrentSession().save(burndownChart);
			sessionfactory.getCurrentSession().flush();
		}

		return id;
	}

	@Transactional
	@Override
	public UUID updateDoc(SprintManager doc) {
		SprintManagerDetails sprintDetailsForDelete = new SprintManagerDetails();
		sprintDetailsForDelete.setSprintId(doc.getId());
		sessionfactory.getCurrentSession().delete(sprintDetailsForDelete);

		for (int i = 0; i < doc.getSteps().size(); i++) {
			SprintManagerDetails sprintDetails = new SprintManagerDetails();
			sprintDetails = doc.getSteps().get(i);
			sessionfactory.getCurrentSession().saveOrUpdate(sprintDetails);
			sessionfactory.getCurrentSession().flush();
		}
		sessionfactory.getCurrentSession().saveOrUpdate(doc);
		sessionfactory.getCurrentSession().flush();
		return doc.getId();
	}

	@Transactional
	@Override
	public UUID deleteDoc(UUID id) {
		SprintManager app = (SprintManager) sessionfactory.getCurrentSession().load(SprintManager.class, id);
		sessionfactory.getCurrentSession().delete(app);
		sessionfactory.getCurrentSession().flush();
		return id;
	}

	@Transactional
	@Override
	public List<Suite> getAllSuites() {
		Query query = sessionfactory.getCurrentSession().createQuery("From Suite");
		List<Suite> suites = query.list();
		return suites;
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
	public List<PrivGroup> getPrivGroup(String suiteCode, String modeCode) {
		String hqlQuery = "from PrivGroup where suiteCode =:suiteCode and  modCode =:modCode order by privGrpCode";
		Query query = sessionfactory.getCurrentSession().createQuery(hqlQuery);
		query.setParameter("suiteCode", suiteCode);
		query.setParameter("modCode", modeCode);
		List<PrivGroup> privGroup = query.list();
		return privGroup;
	}

	/*
	 * @Transactional
	 * 
	 * @Override public boolean checkUnique(Map<String, String> param) { User
	 * currentUser = userDAO.getCurrentUser(); String companyCode =
	 * currentUser.getCompanyCode(); Query query =
	 * sessionfactory.getCurrentSession().
	 * createQuery("FROM SprintManager WHERE sprintCode =:sprintCode AND companyCode=:companyCode"
	 * ); query.setParameter("companyCode",companyCode);
	 * query.setParameter("sprintCode", param.get("sprintCode"));
	 * 
	 * 
	 * SprintManager sprint=(SprintManager) query.uniqueResult();
	 * 
	 * 
	 * if (sprint == null) { return true; } else{ return false; } }
	 */
	@Transactional
	@Override
	public boolean checkUnique(Map<String, Object> param) {
		User currentUser = userDAO.getCurrentUser();
		String companyCode = currentUser.getCompanyCode();
		Query query = sessionfactory.getCurrentSession()
				.createQuery("FROM SprintManager WHERE sprintCode =:sprintCode AND companyCode=:companyCode");
		query.setParameter("companyCode", companyCode);
		query.setParameter("sprintCode", param.get("sprintCode"));

		SprintManager sprint = (SprintManager) query.uniqueResult();

		if (sprint == null) {
			return true;
		} else {
			return false;
		}
	}

	@Transactional
	@Override
	public UUID updateDetail(SprintManagerDetails sprintDetail) {
		sessionfactory.getCurrentSession().saveOrUpdate(sprintDetail);
		sessionfactory.getCurrentSession().flush();
		return sprintDetail.getId();
	}

	@Override
	@Transactional
	public List<SprintManagerDetails> findBySprintCode(String sprintCode) {
		Query query = sessionfactory.getCurrentSession()
				.createQuery("from SprintManagerDetails where sprintCode =:sprintCode ");
		query.setParameter("sprintCode", sprintCode);
		return query.list();
	}

	@Override
	@Transactional
	public List<SprintManagerDetails> getDocBySprintId(UUID sprintId) {
		Query query = sessionfactory.getCurrentSession()
				.createQuery("from SprintManagerDetails where sprintId =:sprintId ");
		query.setParameter("sprintId", sprintId);
		List<SprintManagerDetails> sprintDetails = query.list();
		return sprintDetails;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Map<String, Object> getDocByBurnDownChart(UUID id) {
		// System.out.println(":::::::::::dao:::::::::::::::"+id);
		Map<String, Object> map = new HashMap<String, Object>();
		Criteria car = sessionfactory.getCurrentSession().createCriteria(SprintManager.class);
		car.add(Restrictions.eq("id", id));
		List<SprintManager> sprint = car.list();

		List<Date> sprintAllDays = sprintAllDays(sprint.get(0).getStartDate(), sprint.get(0).getEndDate());

		String sqltask = "select id, remainingTime from Tasks  where storyCode = ANY(select userStoryCode from UserStory where userStoryCode=ANY(select sprintStoryCode from SprintManagerDetails where sprintId=ANY(select id from SprintManager where id='"
				+ id + "')))";
		Query crtask = sessionfactory.getCurrentSession().createQuery(sqltask);

		List<Object> burnHours = new ArrayList<>();

		for (int i = 0; i < sprintAllDays.size(); i++) {
			List<Object> dailyburnhours = new ArrayList<>();
			try {
				if (dateCheck(sprintAllDays.get(i))) {
					double remDaily = 0;

					for (Iterator it = (Iterator) crtask.iterate(); ((java.util.Iterator) it).hasNext();) {
						Object[] row = (Object[]) ((java.util.Iterator) it).next();
						String sql = "From TaskLog where id=:id and stopDate=:stopDate ORDER BY stopDate DESC";
						Query cr = sessionfactory.getCurrentSession().createQuery(sql);
						cr.setParameter("id", row[0]);
						cr.setParameter("stopDate", sprintAllDays.get(i));
						List<TaskLog> log = cr.list();
						if (log.size() > 0) {
							remDaily += log.get(0).getRemainingTime();
						} else {
							remDaily += Double.parseDouble(row[1].toString());
						}

					}
					dailyburnhours.add(remDaily);
					burnHours.add(i, dailyburnhours);

				} else {
					/*
					 * dailyburnhours.add(sprintAllDays.get(i).toString());
					 * //dayremaingTime.add(0); System.out.println(i);
					 * burnHours.add(i, dailyburnhours);
					 */
				}
			} catch (ParseException e) {
				e.getMessage();
			}

		}

		map.put("sprint", sprint);
		map.put("allDayremaingTime", burnHours);
		map.put("days", sprintAllDays);
		return map;
	}

	// find between all date to date
	public List<Date> sprintAllDays(Date startDate, Date endDate) {
		List<Date> sqlDate = new ArrayList<Date>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date startDateUtilq = Utility.fromUtiltoSql(startDate);
		java.util.Date endDateUtilz = Utility.fromUtiltoSql(endDate);
		String s = sdf.format(startDateUtilq);
		String e = sdf.format(endDateUtilz);
		LocalDate start = LocalDate.parse(s);
		LocalDate end = LocalDate.parse(e);

		DecimalFormat df = new DecimalFormat("#.00");
		int c = 0;
		while (start.isBefore(end) || start.equals(end)) {

			start = start.plusDays(1);
			sqlDate.add(Date.valueOf(start));
		}
		return sqlDate;

	}

	public boolean dateCheck(Date date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String timeStamp = sdf.format(Calendar.getInstance().getTime());

		Calendar calendar = Calendar.getInstance();
		Calendar calendarestimat = Calendar.getInstance();

		calendar.setTime(sdf.parse(timeStamp));
		calendar.add(Calendar.DATE, 1); // number of days to add

		timeStamp = sdf.format(calendar.getTime()); // dt is now the new date
		String sqlDate = sdf.format(date);
		calendarestimat.setTime(sdf.parse(sqlDate));

		if (calendar.before(calendarestimat)) {
			System.out.println(timeStamp + " == " + sqlDate);
			return false;
		}
		return true;

	}

	@Transactional
	@Override
	public List<TaskLog> gettasklogLiById(String taskId, Date stopDate) {
		Query query = sessionfactory.getCurrentSession()
				.createQuery("from TaskLog where taskId =:taskId and stopDate =:stopDate");
		query.setParameter("taskId", taskId);
		query.setParameter("stopDate", stopDate);
		List<TaskLog> taskLogli = query.list();
		return taskLogli;
	}

	@Transactional
	@Override
	@SuppressWarnings("unchecked")
	public Map<String, Object> getSpentChartDoc(UUID id) {
		Map<String, Object> map = new HashMap<>();
		String sqlSprint = "select sprintGoal,sprintCode,sprintName,startDate,endDate from SprintManager";
		Query querySprint = sessionfactory.getCurrentSession().createQuery(sqlSprint);
		List<SprintManager> listSprint = (List<SprintManager>) querySprint.list();
		map.put("sprint", listSprint);

		String sql = "select cast(sum(stop_time-start_time) as string) from TaskLog where taskId IN (select cast(id as string) from Tasks  where storyCode = ANY(select userStoryCode from UserStory where userStoryCode=ANY(select sprintStoryCode from SprintManagerDetails where sprintId=ANY(select id from SprintManager where id='"
				+ id + "')))) Group By taskId";
		Query query = sessionfactory.getCurrentSession().createQuery(sql);
		List<String> list = (List<String>) query.list();

		String sqlq = "select taskId from TaskLog where taskId IN (select cast(id as string) from Tasks  where storyCode = ANY(select userStoryCode from UserStory where userStoryCode=ANY(select sprintStoryCode from SprintManagerDetails where sprintId=ANY(select id from SprintManager where id='"
				+ id + "'))))";
		Query queryq = sessionfactory.getCurrentSession().createQuery(sqlq);
		List<String> listq = (List<String>) queryq.list();

		UUID[] idd = new UUID[listq.size() + 1];
		for (int i = 0; i < listq.size(); i++) {
			idd[i] = UUID.fromString(listq.get(i));
		}

		List<Tasks> taskslist = sessionfactory.getCurrentSession().createCriteria(Tasks.class)
				.add(Restrictions.in("id", idd)).list();
		map.put("spenttime", list);
		map.put("task", taskslist);

		return map;

	}

	@Transactional
	@Override
	public List<SprintManager> getAllSprint() {

		Query query = sessionfactory.getCurrentSession().createQuery("From SprintManager");

		List<SprintManager> splist = query.list();
		return splist;
	}

}