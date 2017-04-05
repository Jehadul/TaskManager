package com.ctrends.taskmanager.dao.team;

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
import com.ctrends.taskmanager.model.team.Team;
import com.ctrends.taskmanager.model.team.TeamMemberDetails;
import com.ctrends.taskmanager.model.tman_sprint.BurndownChart;
import com.ctrends.taskmanager.model.tman_sprint.SprintManager;
import com.ctrends.taskmanager.model.tman_sprint.SprintManagerDetails;
import com.ctrends.taskmanager.model.user.User;
import com.ctrends.taskmanager.service.user.IUserService;

@Repository("teamDao")
public class TeamDAO implements ITeamDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	IUserDAO userDAO;

	@Autowired
	IUserService userService;
	
	@Transactional
	@Override
	public List<Team> getAllDoc() {
		User currentUser = userService.getCurrentUser();
		Query query = sessionFactory.getCurrentSession().createQuery("From Team where createdByUsername =:userName");
		query.setParameter("userName", currentUser.getUsername());
		List<Team> teamLi = query.list();
		System.out.println(teamLi.get(0).getId());
		for(int i=0; i<teamLi.size(); i++){
			Query teamMemberDetailsQuery=sessionFactory.getCurrentSession().createQuery("From TeamMemberDetails where teamId =:teamId");
			teamMemberDetailsQuery.setParameter("teamId", teamLi.get(i).getId());
			List<TeamMemberDetails> teamMemberDetails = teamMemberDetailsQuery.list();
			teamLi.get(i).setTeamDetails(teamMemberDetails);
		}
		return teamLi;
	}
	
	@Transactional
	@Override
	public Team getDocById(UUID id) {
		Query teamQuery = sessionFactory.getCurrentSession().createQuery("From Team WHERE id = :id");
		teamQuery.setParameter("id", id);
		
		Team team=(Team)teamQuery.list().get(0);
		
		Query teamMemberDetailsQuery=sessionFactory.getCurrentSession().createQuery("From TeamMemberDetails where teamId =:teamId");
		teamMemberDetailsQuery.setParameter("teamId", team.getId());
		List<TeamMemberDetails> teamMemberDetails = teamMemberDetailsQuery.list();
		team.setTeamDetails(teamMemberDetails);
		return team;
	}

	@Transactional
	@Override
	public List<Team> getDocs(Map<String, String> params) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from Team where teamCode like :teamCode and " + "teamName like :teamName");

		query.setParameter("teamCode", "%" + params.get("teamCode") + "%");
		query.setParameter("teamName", "%" + params.get("teamName") + "%");

		List<Team> teamList = query.list();

		return teamList;
	}

	@Transactional
	@Override
	public UUID insertDoc(Team doc) {
		UUID id = (UUID) sessionFactory.getCurrentSession().save(doc);
		sessionFactory.getCurrentSession().flush();

		for (int i = 0; i < doc.getTeamDetails().size(); i++) {
			TeamMemberDetails teamMemberDetails = new TeamMemberDetails();
			teamMemberDetails = (TeamMemberDetails) doc.getTeamDetails().get(i);
			teamMemberDetails.setTeamId(id);
			sessionFactory.getCurrentSession().save(teamMemberDetails);
			sessionFactory.getCurrentSession().flush();
		}
		return id;
	}

	@Transactional
	@Override
	public UUID updateDoc(Team doc) {
		for (int i = 0; i < doc.getTeamDetails().size(); i++) {
			TeamMemberDetails teamDetails = new TeamMemberDetails();
			teamDetails = doc.getTeamDetails().get(i);
			sessionFactory.getCurrentSession().saveOrUpdate(teamDetails);
			sessionFactory.getCurrentSession().flush();
		}
		sessionFactory.getCurrentSession().saveOrUpdate(doc);
		sessionFactory.getCurrentSession().flush();
		return doc.getId();
	}

	@Transactional
	@Override
	public UUID deleteDoc(UUID id) {
		Team team = (Team) sessionFactory.getCurrentSession().load(Team.class, id);
		sessionFactory.getCurrentSession().delete(team);
		
		sessionFactory.getCurrentSession().flush();
		/*
		String hql = "delete from TeamMemberDetails where teamId= :teamId";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("teamId", id.toString());
        query.executeUpdate();
        
        sessionFactory.getCurrentSession().flush();
		return id;
		
		TeamMemberDetails team=(TeamMemberDetails)sessionFactory.getCurrentSession().load(TeamMemberDetails.class, id);
		sessionFactory.getCurrentSession().delete(team);
		sessionFactory.getCurrentSession().flush();
		*/
		return id;
	}
	
	@Transactional
	@Override
	public boolean checkUnique(Map<String, Object> param) {
		User currentUser = userDAO.getCurrentUser();
		String companyCode = currentUser.getCompanyCode();
		System.out.println(param.get("teamCode") + "team code");
		Query query = sessionFactory.getCurrentSession()
				.createQuery("FROM Team WHERE teamCode =:teamCode AND companyCode=:companyCode");
		query.setParameter("companyCode", companyCode);
		query.setParameter("teamCode", param.get("teamCode"));

		Team team = (Team) query.uniqueResult();
		if (team == null) {
			return true;
		} else {
			return false;
		}
	}
	
	@Transactional
	@Override
	public List<TeamMemberDetails> getDocByIdTeamCode(String teamCode) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("From TeamMemberDetails WHERE teamCode = :teamCode");
		query.setParameter("teamCode", teamCode);
		List<TeamMemberDetails> teamMemberDetailsList = query.list();

		return teamMemberDetailsList;
	}
	
	
	@Transactional
	@Override
	public List<TeamMemberDetails> getTeamMemberDetailsByTeamId(UUID teamId) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("From TeamMemberDetails WHERE teamId = :teamId");
		query.setParameter("teamId", teamId);
		List<TeamMemberDetails> tmDetailsList = query.list();

		return tmDetailsList;
	}
	
	@Transactional
	@Override
	public TeamMemberDetails getTeamMemberDetailsByTeamId(String empCode) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("From TeamMemberDetails WHERE empCode = :empCode");
		query.setParameter("empCode", empCode);
		List<TeamMemberDetails> teamDetails = query.list();
		if (teamDetails.size() > 0) {
			return teamDetails.get(0);
		}
		return null;
	}
}
