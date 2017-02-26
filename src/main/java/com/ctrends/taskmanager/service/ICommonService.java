package com.ctrends.taskmanager.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface ICommonService<T> {
	 public Map<String, String> insert(Map<String, String[]> requestMap);   
	 public List<T> getAll();  
	 public T getById(UUID id);  
	 public Map<String, String> update(Map<String,String[]> requestMap);  
	 public UUID delete(Map<String, String[]> requestMap);  
}
