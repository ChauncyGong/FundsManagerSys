package com.ifox.fundsManagerSys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ifox.fundsManagerSys.dao.BillDao;
import com.ifox.fundsManagerSys.dao.UserDao;
import com.ifox.fundsManagerSys.entities.Bill;
import com.ifox.fundsManagerSys.entities.User;
import com.ifox.fundsManagerSys.exception.BudgetOverrunsException;
import com.ifox.fundsManagerSys.exception.LackofbalanceException;
import com.ifox.fundsManagerSys.service.BillService;
import com.ifox.fundsManagerSys.utils.Balance;
import com.ifox.fundsManagerSys.utils.BalanceOfExpenses;

@Component
public class BillServiceImpl implements BillService{
	
	@Autowired
	private  BillDao billdao;
	
	@Autowired
	private UserDao userDao;

	public Bill findBill(String bill_Number) {
		return billdao.find(bill_Number);
	}

	public List<Bill> findBills(String job_Number) {
		return billdao.findBySubmitter(job_Number);
	}

	public List<Bill> findAll() {
		return billdao.findAll();
	}
	
	public List<Bill> findBillsByPage(int pageNo, int pageSize){
		return billdao.findBillsByPage(pageNo, pageSize);
	}
	
	public List<Bill> findBillsByPage(String job_Number, int pageNo, int pageSize){
		return billdao.findBillsByPage(job_Number, pageNo, pageSize);
	}
	

	@Transactional
	public void addBill(Bill bill) throws LackofbalanceException, BudgetOverrunsException {
		System.out.println(bill);
		User user = bill.getSubmitter();
		user.setReimbursed_Expenses(user.getReimbursed_Expenses()+bill.getTotal_Expenses());
		user.setBalance(user.getAdvance_Amount()-user.getReimbursed_Expenses());
		userDao.update(user);
		Balance balance = BalanceOfExpenses.getInstance();
		balance.setBalance_Inform(balance.getBalance_Inform()-bill.getCost_Inform());
		balance.setBalance_Meetting(balance.getBalance_Meetting()-bill.getCost_Meetting());
		balance.setBalance_Office(balance.getBalance_Office()-bill.getCost_Office());
		balance.setBalance_Other(balance.getBalance_Other()-bill.getCost_Other());
		balance.setBalance_Post(balance.getBalance_Post()-bill.getCost_Post());
		balance.setBalance_SpeMat(balance.getBalance_SpeMat()-bill.getCost_SpeMat());
		balance.setBalance_Travel(balance.getBalance_Travel()-bill.getCost_Travel());
		billdao.save(bill);
	}
	
	@Transactional
	public void deleteBill(String bill_Number) {
		Bill bill = billdao.find(bill_Number);
		billdao.delete(bill);
	}
	
}
