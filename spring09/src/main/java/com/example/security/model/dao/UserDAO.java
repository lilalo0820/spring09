package com.example.security.model.dao;

import java.util.Map;

public interface UserDAO {
	
	int insert(Map<String,Object> map);
	Map<String,Object> detail(String userid); 
	
}
