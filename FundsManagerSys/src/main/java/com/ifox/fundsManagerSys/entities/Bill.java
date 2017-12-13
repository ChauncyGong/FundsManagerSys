package com.ifox.fundsManagerSys.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Bill implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private User submitter;						//报账人
	
	private float cost_SpeMat = 0.00f;			//专用材料费
	
	private float cost_Travel = 0.00f;			//差旅费
	
	private float cost_Inform = 0.00f;			//咨询费
	
	private float cost_Meetting = 0.00f;		//会议费
	
	private float cost_Post = 0.00f;			//邮电费
	
	private float cost_Office = 0.00f;			//办公费
	
	private float cost_Other = 0.00f;			//其他费用
	
	private float total_Expenses = 0.00f;		//合计
	
	private Date submit_Time;					//提交时间
	
	public Bill() {}
	
	public Bill(float cost_SpeMat, float cost_Travel,float cost_Inform,
			float cost_Meetting, float cost_Post, float cost_Office,
			float cost_Other){
		this.cost_SpeMat = cost_SpeMat;
		this.cost_Travel = cost_Travel;
		this.cost_Inform = cost_Inform;
		this.cost_Meetting = cost_Meetting;
		this.cost_Post = cost_Post;
		this.cost_Office = cost_Office;
		this.cost_Other = cost_Other;
		this.total_Expenses = cost_SpeMat + cost_Travel + cost_Inform +
				cost_Meetting + cost_Post + cost_Office + cost_Other;
	}

	@Id
	@GeneratedValue
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn
	public User getSubmitter() {
		return submitter;
	}

	public void setSubmitter(User submitter) {
		this.submitter = submitter;
	}

	public float getCost_SpeMat() {
		return cost_SpeMat;
	}

	public void setCost_SpeMat(float cost_SpeMat) {
		this.cost_SpeMat = cost_SpeMat;
	}

	public float getCost_Travel() {
		return cost_Travel;
	}

	public void setCost_Travel(float cost_Travel) {
		this.cost_Travel = cost_Travel;
	}

	public float getCost_Inform() {
		return cost_Inform;
	}

	public void setCost_Inform(float cost_Inform) {
		this.cost_Inform = cost_Inform;
	}

	public float getCost_Meetting() {
		return cost_Meetting;
	}

	public void setCost_Meetting(float cost_Meetting) {
		this.cost_Meetting = cost_Meetting;
	}

	public float getCost_Post() {
		return cost_Post;
	}

	public void setCost_Post(float cost_Post) {
		this.cost_Post = cost_Post;
	}

	public float getCost_Office() {
		return cost_Office;
	}

	public void setCost_Office(float cost_Office) {
		this.cost_Office = cost_Office;
	}

	public float getCost_Other() {
		return cost_Other;
	}

	public void setCost_Other(float cost_Other) {
		this.cost_Other = cost_Other;
	}
	
	public Date getSubmit_Time() {
		return submit_Time;
	}

	public void setSubmit_Time(Date submit_Time) {
		this.submit_Time = submit_Time;
	}

	public float getTotal_Expenses() {
		return total_Expenses;
	}

	public void setTotal_Expenses(float total_Expenses) {
		this.total_Expenses = total_Expenses;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", submitter=" + submitter + ", cost_SpeMat="
				+ cost_SpeMat + ", cost_Travel=" + cost_Travel + ", cost_Inform=" + cost_Inform + ", cost_Meetting="
				+ cost_Meetting + ", cost_Post=" + cost_Post + ", cost_Office=" + cost_Office + ", cost_Other="
				+ cost_Other + ", total_Expenses=" + total_Expenses + ", submit_Time=" + submit_Time + "]";
	}

}
