package com.ctrends.taskmanager.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.ctrends.taskmanager.bean.WSResponse;

public interface ICommonController<T> {
	public ModelAndView index();
	public ModelAndView show(UUID id);
	public WSResponse get(UUID id);
	public ModelAndView create();
	public WSResponse store(HttpServletRequest request) ;
	public ModelAndView edit(UUID id);
	public WSResponse update(HttpServletRequest request);
	public WSResponse destroy(HttpServletRequest request);
	public ModelAndView showSearch(HttpServletRequest request);
	public String search(HttpServletRequest request);

}
