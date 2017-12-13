package com.ifox.fundsManagerSys.service;

import java.util.List;

import com.ifox.fundsManagerSys.entities.User;

public interface UserService {
	
	User findUser(String job_Number);
	
	List<User> findAll();
	
	void addUser(User user);
	
	void updateUser(User user);
	
	void deleteUser(String job_Number);
}
