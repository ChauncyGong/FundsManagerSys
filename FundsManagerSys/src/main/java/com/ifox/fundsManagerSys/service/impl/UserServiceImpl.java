package com.ifox.fundsManagerSys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifox.fundsManagerSys.dao.UserDao;
import com.ifox.fundsManagerSys.entities.User;
import com.ifox.fundsManagerSys.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	public User findUser(String job_Number){
		return userDao.findUser(job_Number);
	}
	
	public List<User> findAll(){
		return userDao.findAll(User.class);
	}

	@Transactional
	public void addUser(User user) {
		userDao.save(user);
	}

	@Transactional
	public void updateUser(User user) {
		userDao.update(user);
	}

	@Transactional
	public void deleteUser(String job_Number) {
		User user = userDao.findUser(job_Number);
		userDao.delete(user);
	}
	
}
