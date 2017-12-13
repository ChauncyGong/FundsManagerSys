package com.ifox.fundsManagerSys.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ifox.fundsManagerSys.dao.BaseDao;

@Repository
public class BaseDaoHibernate<T> implements BaseDao<T>{
	
	@PersistenceContext
	protected EntityManager entityManager;

	public T get(Class<T> entityClazz, Serializable id) {
		return (T)entityManager.find(entityClazz, id);
	}

	public void save(T entity) {
		entityManager.persist(entity);
	}

	public void update(T entity) {
		entityManager.merge(entity);
	}

	public void delete(T entity) {
		entityManager.remove(entity);
	}

	public void delete(Class<T> entityClazz, Serializable id) {
		entityManager.createQuery("delete "+entityClazz.getSimpleName()
		+" en where en.id = ?0").setParameter(0, id).executeUpdate();
	}

	public List<T> findAll(Class<T> entityclazz) {
		return find("select en from "+entityclazz.getSimpleName()+" en");
	}

	public long findCount(Class<T> entityclazz) {
		List<?> list =find("select count(*) from "+entityclazz.getSimpleName());
		if(list!=null&&list.size()==1){
			return (Long) list.get(0);
		}
		return 0;
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> find(String jpql,Object... params){
		Query query = entityManager.createQuery(jpql);
		for(int i = 0;i<params.length;i++){
			query.setParameter(i, params[i]);
		}
		List<T> list = (List<T>)query.getResultList();
		if(list.isEmpty()){
			return null;
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String jpql,int pageNo,int pageSize,Object... params){
		Query query = entityManager.createQuery(jpql);
		for(int i = 0;i < params.length;i++){
			query.setParameter(i, params[i]);
		}
		return query.setFirstResult((pageNo-1)*pageSize)
				.setMaxResults(pageSize).getResultList();
	}

}
