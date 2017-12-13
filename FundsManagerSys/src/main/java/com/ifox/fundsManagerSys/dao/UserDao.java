package com.ifox.fundsManagerSys.dao;

import com.ifox.fundsManagerSys.entities.User;

public interface UserDao extends BaseDao<User>{
	
	User findUser(String job_Number);
	
	
}
