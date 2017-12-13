package com.ifox.fundsManagerSys.utils;

public class BalanceOfExpenses {

	private static Balance budget = null;
	
	private BalanceOfExpenses(){}
	
	public static Balance getInstance(){
		if(budget == null){
			budget = new Balance();
		}
		return budget;
	}

}
