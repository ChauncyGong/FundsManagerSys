package com.ifox.fundsManagerSys.dao;

import java.util.List;

import com.ifox.fundsManagerSys.entities.Bill;

public interface BillDao extends BaseDao<Bill> {
	
	Bill find(String bill_Number);

	List<Bill> findBySubmitter(String job_Number);
	
	List<Bill> findAll();
	
	List<Bill> findBillsByPage(String job_Number, int pageNo, int pageSize);
	
	List<Bill> findBillsByPage(int pageNo, int pageSize);
		
}
