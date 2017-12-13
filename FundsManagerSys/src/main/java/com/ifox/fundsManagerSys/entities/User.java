package com.ifox.fundsManagerSys.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ifox.fundsManagerSys.exception.LackofbalanceException;

@Entity
@Table
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private String job_Number;
	
	private String name;
	
	private String password;
	
	private float advance_Amount = 0;
	
	private float reimbursed_Expenses = 0;
	
	private float balance = 0;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String job_Number,String name,String password){
		this.job_Number = job_Number;
		this.name = name;
		this.password = password;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJob_Number() {
		return job_Number;
	}

	public void setJob_Number(String job_Number) {
		this.job_Number = job_Number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public float getAdvance_Amount() {
		return advance_Amount;
	}

	public void setAdvance_Amount(float advance_Amount) {
		this.advance_Amount = advance_Amount;
	}

	public float getReimbursed_Expenses() {
		return reimbursed_Expenses;
	}

	public void setReimbursed_Expenses(float reimbursed_Expenses) {
		this.reimbursed_Expenses = reimbursed_Expenses;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) throws LackofbalanceException {
		if(balance<0){
			throw new LackofbalanceException("账户余额不足");
		}
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", job_number=" + job_Number + ", name=" + name + ", password=" + password
				+ ", advance_Amount=" + advance_Amount + ", reimbursed_Expenses="
				+ reimbursed_Expenses + ", balance=" + balance + "]";
	}
	
}
