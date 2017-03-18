package com.ctrends.taskmanager.service.user;


import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctrends.taskmanager.dao.user.IUserDAO;
import com.ctrends.taskmanager.model.user.User;

@Service("userService")
public class UserService implements IUserService {

	@Autowired
	IUserDAO userDAO; 
	
	
	
	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public User getUserByUserName(String username) {
		return userDAO.getByUserName(username);
	}


	@Override
	public Map<String, String> insert(Map<String, String[]> request) {		
		Map<String, String> params = new HashMap<String, String>();
		UUID id=null;
		
		User currentUser = userDAO.getCurrentUser();
		
		String empCode = request.get("emp_code")[0];
		String companyCode = request.get("company_code")[0];

		
		User user = new User();
		
		user.setEmpCode(request.get("emp_code")[0]);
		user.setEmpName(request.get("emp_name")[0]);
		user.setDesig(request.get("emp_desig")[0]);
		user.setEmail(request.get("emp_email")[0]);
		user.setFirstName(request.get("first_name")[0]);
		user.setMiddleName(request.get("middle_name")[0]);
		user.setLastName(request.get("last_name")[0]);
		user.setUserStatus(request.get("user_status")[0]);
		user.setUsername(request.get("emp_username")[0]);
		user.setRoleCode(request.get("role_code")[0]);
		user.setRoleName(request.get("role_name")[0]);
		
		user.setClientCode(currentUser.getClientCode());
		user.setClientName(currentUser.getClientName());
		user.setCompanyCode(currentUser.getCompanyCode());
		user.setCompanyName(currentUser.getCompanyName());		
		user.setCreatedByCode(currentUser.getEmpCode());
		user.setCreatedByName(currentUser.getEmpName());
		user.setCreatedByUsername(currentUser.getUsername());
		user.setCreatedByEmail(currentUser.getEmail());
		user.setCreatedAt(new Timestamp(System.currentTimeMillis()));

		id = userDAO.insertDoc(user);
		params.put("id", id.toString());
		
		return params;

	}


	@Override
	public Map<String, String> update(Map<String, String[]> request) {
		Map<String, String> params = new HashMap<String, String>();
		UUID id;
		
		User user = userDAO .getDocById(UUID.fromString(request.get("id")[0]));
		
		User currentUser = userDAO.getCurrentUser();
		
	
		user.setId(UUID.fromString(request.get("id")[0]));
		
		user.setEmpCode(request.get("emp_code")[0]);
		user.setEmpName(request.get("emp_name")[0]);
		user.setDesig(request.get("emp_desig")[0]);
		user.setEmail(request.get("emp_email")[0]);
		user.setFirstName(request.get("first_name")[0]);
		user.setMiddleName(request.get("middle_name")[0]);
		user.setLastName(request.get("last_name")[0]);
		user.setUserStatus(request.get("user_status")[0]);
		user.setUsername(request.get("emp_username")[0]);
		user.setRoleCode(request.get("role_code")[0]);
		user.setRoleName(request.get("role_name")[0]);
		user.setClientCode(currentUser.getClientCode());
		user.setClientName(currentUser.getClientName());
		user.setCompanyCode(currentUser.getCompanyCode());
		user.setCompanyName(currentUser.getCompanyName());
		
		user.setUpdatedByCode(currentUser.getCreatedByCode());
		user.setUpdatedByName(currentUser.getCreatedByName());
		user.setUpdatedByCode(currentUser.getEmpCode());
		user.setUpdatedByName(currentUser.getEmpName());
		user.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		
		id = userDAO.updateDoc(user);
		params.put("id", id.toString());
		return params;
	}



	@Override
	public User getById(UUID id) {
		return userDAO.getDocById(id);
	}




	@Override
	public UUID delete(Map<String, String[]> requestMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
    public User getCurrentUser() {
        // TODO Auto-generated method stub
        return userDAO.getCurrentUser();
    }

	@Override
	public List<User> find(Map<String, String> searchingKey) {
		return userDAO.getDocs(searchingKey);
	}
}
