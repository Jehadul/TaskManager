package com.ctrends.taskmanager.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;



public interface ICommonController<T> {
	public ModelAndView index();
	public ModelAndView show(UUID id);
	
	public ModelAndView create();
	
	public ModelAndView edit(UUID id);
	
	
	public ModelAndView showSearch(HttpServletRequest request);
	public String search(HttpServletRequest request);

}
