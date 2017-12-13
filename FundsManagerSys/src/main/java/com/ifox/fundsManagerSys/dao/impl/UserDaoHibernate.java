package com.ifox.fundsManagerSys.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ifox.fundsManagerSys.dao.UserDao;
import com.ifox.fundsManagerSys.entities.User;

@Repository
public class UserDaoHibernate extends BaseDaoHibernate<User> implements UserDao{
		
	public User findUser(String job_Number) {
		String jpql = "select u from User u where u.job_Number = ?0";
		System.out.println(jpql);
		Query query = entityManager.createQuery(jpql).setParameter(0, job_Number);
		System.out.println(query.toString());
		return (User) query.getSingleResult();
	}

}
