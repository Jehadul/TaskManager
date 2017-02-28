package com.ctrends.taskmanager.controller.tman;



import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ctrends.taskmanager.bean.WSResponse;
import com.ctrends.taskmanager.controller.tman.ITasksController;
import com.ctrends.taskmanager.dao.tman.ITasksDao;
import com.ctrends.taskmanager.model.taskmanage.Module;
import com.ctrends.taskmanager.model.taskmanage.Suite;

@Repository("tasksController")

@RestController
@RequestMapping("/taskman/tman/tasks")
public class TasksController implements ITasksController {
	
	@Autowired
	ITasksDao taskDao;
	

	@Override
	@RequestMapping(value = "/taskli", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView index() {
		System.out.println("Hello Reza");
		// TODO Auto-generated method stub
		return new ModelAndView("taskman/tasklist");
	}

	
	@Override
	public ModelAndView show(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@RequestMapping(value = "/create1", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public ModelAndView create() {
		Map<String, Object> data = new HashMap<String, Object>();
		List<Suite> suiteLi=taskDao.getAllSuites();
		List<Module> moduleLi=taskDao.getAllModules();
		
		Map<String, String> suiteCodes = new HashMap<String, String>();
		for (int i = 0; i < suiteLi.size(); i++) {
			suiteCodes.put(suiteLi.get(i).getSuiteCode(), suiteLi.get(i).getSuiteShortName());
		}
		
		Map<String, String> moduleCodes = new HashMap<String, String>();
		for (int i = 0; i < moduleLi.size(); i++) {
			moduleCodes.put(moduleLi.get(i).getModCode(), moduleLi.get(i).getModShortName());
		}
		
		Map<String, String> productCodes = new HashMap<String, String>();
			productCodes.put("pro1", "Product 1");
			productCodes.put("pro2", "Product 2");
			productCodes.put("pro3", "Product 3");
			productCodes.put("pro4", "Product 4");
		
		data.put("suiteCodes", suiteCodes);
		data.put("moduleCodes", moduleCodes);
		data.put("productCodes", productCodes);
		return new ModelAndView("taskman/create", "data", data);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView editmodules(HttpServletRequest request) throws Exception
    {   
		Map<String,Object> data = new HashMap<String,Object>();
        String suiteCode = request.getParameter("suite_code");
        
        Map<String,Object> map = new LinkedHashMap<String,Object>();
        
 		if (suiteCode == null || suiteCode.isEmpty()) {
			map.put("", "--SELECT--");
		} 

        List<Module> modules = taskDao.getBySuit(suiteCode);

		List<Suite> suiteLi=taskDao.getAllSuites();
		
		Map<String, String> suiteCodes = new HashMap<String, String>();
		for (int i = 0; i < suiteLi.size(); i++) {
			suiteCodes.put(suiteLi.get(i).getSuiteCode(), suiteLi.get(i).getSuiteShortName());
		}
		
		Map<String, String> moduleCodes = new HashMap<String, String>();
		for (int i = 0; i < modules.size(); i++) {
			moduleCodes.put(modules.get(i).getModCode(), modules.get(i).getModShortName());
		}
		
		Map<String, String> productCodes = new HashMap<String, String>();
			productCodes.put("pro1", "Product 1");
			productCodes.put("pro2", "Product 2");
			productCodes.put("pro3", "Product 3");
			productCodes.put("pro4", "Product 4");
		
		data.put("suiteCodes", suiteCodes);
		data.put("moduleCodes", moduleCodes);
		data.put("productCodes", productCodes);
		data.put("suiteLi", map);
        data.put("suiteCode", suiteCode);
        
		return new ModelAndView("taskman/create", "data", data);
    }

	@Override
	public ModelAndView edit(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView showSearch(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String search(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WSResponse get(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WSResponse store(HttpServletRequest request) {
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
