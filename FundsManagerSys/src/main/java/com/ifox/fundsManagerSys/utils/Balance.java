package com.ifox.fundsManagerSys.utils;

import com.ifox.fundsManagerSys.exception.BudgetOverrunsException;

public class Balance {
	
	private float balance_SpeMat = Constant.COST_SPEMAT;

	private float balance_Travel = Constant.COST_TRAVEL;
	
	private float balance_Inform = Constant.COST_INFORM;
	
	private float balance_Meetting = Constant.COST_MEETTING;
	
	private float balance_Post = Constant.COST_POST;
	
	private float balance_Office = Constant.COST_OFFICE;
	
	private float balance_Other = Constant.COST_OTHER;

	public float getBalance_SpeMat() {
		return balance_SpeMat;
	}

	public void setBalance_SpeMat(float balance_SpeMat) throws BudgetOverrunsException {
		if(balance_SpeMat<0){
			throw new BudgetOverrunsException("专用材料费");
		}
		this.balance_SpeMat = balance_SpeMat;
	}
	
	public float getBalance_Travel() {
		return balance_Travel;
	}

	public void setBalance_Travel(float balance_Travel) throws BudgetOverrunsException {
		if(balance_Travel<0){
			throw new BudgetOverrunsException("差旅费");
		}
		this.balance_Travel = balance_Travel;
	}

	public float getBalance_Inform() {
		return balance_Inform;
	}

	public void setBalance_Inform(float balance_Inform) throws BudgetOverrunsException {
		if(balance_Inform<0){
			throw new BudgetOverrunsException("咨询费");
		}
		this.balance_Inform = balance_Inform;
	}

	public float getBalance_Meetting() {
		return balance_Meetting;
	}

	public void setBalance_Meetting(float balance_Meetting) throws BudgetOverrunsException {
		if(balance_Meetting<0){
			throw new BudgetOverrunsException("会议费");
		}
		this.balance_Meetting = balance_Meetting;
	}

	public float getBalance_Post() {
		return balance_Post;
	}

	public void setBalance_Post(float balance_Post) throws BudgetOverrunsException {
		if(balance_Post<0){
			throw new BudgetOverrunsException("邮电费");
		}
		this.balance_Post = balance_Post;
	}

	public float getBalance_Office() {
		return balance_Office;
	}

	public void setBalance_Office(float balance_Office) throws BudgetOverrunsException {
		if(balance_Office<0){
			throw new BudgetOverrunsException("办公费用");
		}
		this.balance_Office = balance_Office;
	}

	public float getBalance_Other() {
		return balance_Other;
	}

	public void setBalance_Other(float balance_Other) throws BudgetOverrunsException {
		if(balance_Other<0){
			throw new BudgetOverrunsException("其他费用");
		}
		this.balance_Other = balance_Other;
	}

	@Override
	public String toString() {
		return "Balance [balance_SpeMat=" + balance_SpeMat + ", balance_Travel=" + balance_Travel + ", balance_Inform="
				+ balance_Inform + ", balance_Meetting=" + balance_Meetting + ", balance_Post=" + balance_Post
				+ ", balance_Office=" + balance_Office + ", balance_Other=" + balance_Other + "]";
	}
	
}
