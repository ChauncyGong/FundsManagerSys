package com.ifox.fundsManagerSys.Handler;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ifox.fundsManagerSys.entities.User;
import com.ifox.fundsManagerSys.service.BillService;
import com.ifox.fundsManagerSys.service.UserService;
import com.ifox.fundsManagerSys.utils.Constant;
import com.ifox.fundsManagerSys.utils.MD5Util;

@Controller
public class UserHandler{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BillService billService;
	
	@RequestMapping(value="/login")
	public String login(){
		return "system_login";
	}
	
	@RequestMapping(value="/login_in", method=RequestMethod.POST,
			produces = "text/html;charset=UTF-8")
	public String login(HttpSession session, HttpServletRequest request,
			String job_Number, String password,Map<String, Object> map) throws Exception{
		String pass = MD5Util.getMD5Code(password);
		if(job_Number.equals(Constant.ADMIN_ACCOUNT)){
			if(pass.equals(Constant.ADMIN_PASSWORD)){
				map.put("LOGIN_STATUS", "SUCCESS");
				session.setAttribute("ROLE", "ADMIN");
				return "manager_index";
			}else{
				map.put("LOGIN_STATUS", "FAIL_PASSWORD");
			}
		}else{
			User user = null;
			try {
				user = userService.findUser(job_Number);
				if(user==null){
					map.put("LOGIN_STATUS", "FAIL_ACCOUNT");
				}else{
					if(pass.equals(user.getPassword())){
						map.put("LOGIN_STATUS", "SUCCESS");
						map.put("billList", billService.findBills(user.getJob_Number()));
						session.setAttribute("ROLE", user.getName());
						session.setAttribute("user", user);
					}else{
						map.put("LOGIN_STATUS", "FAIL_PASSWORD");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				map.put("LOGIN_STATUS", "FAIL_ACCOUNT");
			}
		}
		if(map.get("LOGIN_STATUS").equals("SUCCESS")){
			return "system_index";
		}else{
			return "system_login";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/addUser", method=RequestMethod.POST,
			produces = "text/html;charset=UTF-8")
	public boolean addUser(String job_Number, String name,
			String password, String phone_Number){
		try {
			User user = new User(job_Number, name,
					MD5Util.getMD5Code(password));
			userService.addUser(user);	
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/setAdvance",method=RequestMethod.POST,
			produces = "text/html;charset=UTF-8")
	public boolean setAdvance(String job_Number, String advance){
		try{
			User user = userService.findUser(job_Number);
			user.setAdvance_Amount(Float.valueOf(advance));
			user.setReimbursed_Expenses(0);
			user.setBalance(Float.valueOf(advance));
			userService.updateUser(user);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/delete", method=RequestMethod.POST,
			produces = "text/html;charset=UTF-8")
	public boolean delete(String job_Number){
		try {
			userService.deleteUser(job_Number);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/listAllUser", method=RequestMethod.GET,
			produces = "text/html;charset=UTF-8")
	public String listAllUser(){
		try {
			return new Gson().toJson(userService.findAll());
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/updatePass",method=RequestMethod.POST,
			produces = "text/html;charset=UTF-8")
	public String updatePass(String job_Number, String newPassword, String oldPassword){
		try {
			User user = userService.findUser(job_Number);
			if(user.getPassword().equals(MD5Util.getMD5Code(oldPassword))){
				user.setPassword(MD5Util.getMD5Code(newPassword));
				userService.updateUser(user);
				return "修改成功";
			}else{
				return "旧密码输入错误";
			}
		} catch (Exception e) {
			return "修改失败";
		}
	}
	
}