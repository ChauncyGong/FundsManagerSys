package com.ifox.fundsManagerSys.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ifox.fundsManagerSys.dao.BillDao;
import com.ifox.fundsManagerSys.entities.Bill;

@Repository
public class BillDaoHibernate extends BaseDaoHibernate<Bill> implements BillDao{

	public Bill find(String bill_Number) {
		String jpql = "from Bill b where b.bill_Number = ?0";
		Query query = entityManager.createQuery(jpql).setParameter(0, bill_Number);
		return (Bill) query.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Bill> findBySubmitter(String job_Number) {
		String jpql = "from Bill b where b.submitter = (from User u where u.job_Number = ?0)";
		Query query = entityManager.createQuery(jpql).setParameter(0, job_Number);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Bill> findAll() {
		String jpql = "from Bill b order by b.submit_Time Asc";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}	
	
	public List<Bill> findBillsByPage(String job_Number, int pageNo, int pageSize) {
		String jpql = "from Bill b where b.submitter = (from User u where u.job_Number = ?0)";
		Object[] params ={job_Number};
		return super.findByPage(jpql, pageNo, pageSize, params);
	}
	
	public List<Bill> findBillsByPage(int pageNo, int pageSize) {
		String jpql = "form Bill b";
		Object[] params = {};
		return super.findByPage(jpql, pageNo, pageSize, params);
	}
	
}
