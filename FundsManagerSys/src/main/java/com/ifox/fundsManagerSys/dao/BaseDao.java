package com.ifox.fundsManagerSys.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
	
	T get(Class<T> entityClass,Serializable id);   	//根据id获取实体
	
	void save(T entity);					 	    //保存实体
	
	void update(T entity);							//更新实体
	
	void delete(T entity);							//删除实体
	
	void delete(Class<T> entityClazz,Serializable id);	//根据id删除实体
	
	List<T> findAll(Class<T> entityclazz);			//获取所有记录
	
	long findCount(Class<T> entityclazz);			//获取记录数

	
}
