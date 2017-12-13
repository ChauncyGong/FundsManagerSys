package com.ifox.fundsManagerSys.Handler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ifox.fundsManagerSys.entities.Bill;
import com.ifox.fundsManagerSys.entities.User;
import com.ifox.fundsManagerSys.exception.BudgetOverrunsException;
import com.ifox.fundsManagerSys.exception.LackofbalanceException;
import com.ifox.fundsManagerSys.service.BillService;
import com.ifox.fundsManagerSys.utils.BalanceOfExpenses;
import com.ifox.fundsManagerSys.utils.Constant;

@Controller
public class BillHandler {

	@Autowired
	private BillService billService;
	
	Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:SS").create();
	
	private Map<Object, Object> map = new HashMap<Object, Object>();
	
	@ResponseBody
	@RequestMapping(value="/getValidateInfo", method=RequestMethod.GET,
	produces = "text/html;charset=UTF-8")
	public String getValidateInfo(HttpSession session){
		User user = (User) session.getAttribute("user");
		map.put("user", user);
		map.put("totalAdvance", Constant.getAdvance());
		map.put("balance", BalanceOfExpenses.getInstance());
		return new Gson().toJson(map);
	}
	
	@ResponseBody
	@RequestMapping(value="/commitBill", method=RequestMethod.POST,
			produces = "text/html;charset=UTF-8")
	public String addBill(HttpSession session, String cost_SpeMat, 
			String cost_Travel, String cost_Inform, String cost_Meetting,
			String cost_Post, String cost_Office, String cost_Other, 
			Map<Object, Object> map){
		float speMat = 0, travel = 0, inform = 0, meetting = 0, post = 0, office = 0, other = 0;
		if(!"".equals(cost_SpeMat)){
			speMat = Float.valueOf(cost_SpeMat);
		}
		if(!"".equals(cost_Travel)){
			travel = Float.valueOf(cost_Travel);
		}
		if(!"".equals(cost_Inform)){
			inform = Float.valueOf(cost_Inform);
		}
		if(!"".equals(cost_Meetting)){
			meetting = Float.valueOf(cost_Meetting);
		}
		if(!"".equals(cost_Post)){
			post = Float.valueOf(cost_Post);
		}
		if(!"".equals(cost_Office)){
			office = Float.valueOf(cost_Office);
		}
		if(!"".equals(cost_Other)){
			other = Float.valueOf(cost_Other);
		}
		try {		
			Bill bill = new Bill(speMat, travel, inform, meetting, post, office, other);
			System.out.println(bill);
			User user = (User) session.getAttribute("user");
			System.out.println(user);
			bill.setSubmitter(user);
			bill.setSubmit_Time(new Date());
			billService.addBill(bill);
			System.out.println(bill.getSubmitter());
			System.out.println(bill);
			map.put("status", "SUCCESS");
		} catch (LackofbalanceException le) {
			map.put("status", "LackofbalanceException");
			le.printStackTrace();
		} catch (BudgetOverrunsException be) {
			map.put("status", "BudgetOverrunsException");
			be.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Gson().toJson(map);
	}
	
	@ResponseBody
	@RequestMapping(value="/findUserBill/{job_Number}", method=RequestMethod.GET,
			produces = "text/html;charset=UTF-8")
	public String findUserBill(@PathVariable("job_Number")String job_Number,
			HttpServletRequest request){
		List<Bill> billList = null;
		try {
			billList = billService.findBills(job_Number);
			return gson.toJson(billList);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/findAll", method=RequestMethod.GET,
			produces = "text/html;charset=UTF-8")
	public String findAll(){
		return gson.toJson(billService.findAll());
	}
}
