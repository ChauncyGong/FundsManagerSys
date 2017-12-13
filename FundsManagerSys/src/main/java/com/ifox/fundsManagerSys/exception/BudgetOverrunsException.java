package com.ifox.fundsManagerSys.exception;

public class BudgetOverrunsException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public BudgetOverrunsException() {}
	
	public BudgetOverrunsException(String message){
		super(message+"该项预算已超支");
	}
	
	public BudgetOverrunsException(String message, Throwable cause){
		super(message, cause);
	}
}
