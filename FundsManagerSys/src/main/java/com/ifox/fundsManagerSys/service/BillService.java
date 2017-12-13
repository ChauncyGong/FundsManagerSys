package com.ifox.fundsManagerSys.service;

import java.util.List;

import com.ifox.fundsManagerSys.entities.Bill;

public interface BillService {
	
	Bill findBill(String bill_Number);
	
	List<Bill> findBills(String job_Number);
	
	List<Bill> findAll();
	
	List<Bill> findBillsByPage(int pageNo, int pageSize);
	
	List<Bill> findBillsByPage(String job_Number, int pageNo, int pageSize);
	
	void addBill(Bill bill) throws Exception;
	
	void deleteBill(String bill_Number);
	
}
