package com.ctrends.taskmanager.controller.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ctrends.taskmanager.bean.WSResponse;
import com.ctrends.taskmanager.model.user.User;
import com.ctrends.taskmanager.service.user.IUserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
@RequestMapping("/ac/user")
public class UserController implements IUserController {

	
	@Autowired
	private IUserService userService;



	@Override
	public ModelAndView index() {
		// TODO Auto-generated method stub
		return null;
	}



	
	@RequestMapping(value = "/searchuser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView showSearch(@Context HttpServletRequest request) {
		
		
		String actionTypeCode = request.getParameter("action_type_code");
		Map<String, Object> data = new HashMap<String, Object>();
		
		data.put("action_type_code", actionTypeCode);
		return new ModelAndView("user/searchuser", "data", data);
	}

	@RequestMapping(value = "/userSearch", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String search(@Context HttpServletRequest request) {
		System.out.println("::::::user search page::::");
		Map<String, String> searchingKey = new HashMap<String, String>();
		
		// if user input is null than convart it into empty String
		if(request.getParameter("emp_code")==null){
			searchingKey.put("empCode", "");
		}else{
			searchingKey.put("empCode", request.getParameter("emp_code"));
		}
		
		if(request.getParameter("emp_name")==null){
			searchingKey.put("empName", "");
		}else{
			searchingKey.put("empName", request.getParameter("emp_name"));
		}

		List<User> data = userService.find(searchingKey);
		//jeson convert
		GsonBuilder gBuilder = new GsonBuilder();
		Gson gson = gBuilder.create();
		
		return gson.toJson(data);
	}




	@Override
	public ModelAndView show(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public WSResponse get(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public ModelAndView create() {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public WSResponse store(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public ModelAndView edit(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public WSResponse update(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public WSResponse destroy(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
}