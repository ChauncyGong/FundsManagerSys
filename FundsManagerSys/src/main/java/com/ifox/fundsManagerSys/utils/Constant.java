package com.ifox.fundsManagerSys.utils;

import java.util.HashMap;
import java.util.Map;

public class Constant {
	
	public static final String ADMIN_ACCOUNT = "admin";
	
	public static final String ADMIN_PASSWORD = "96e79218965eb72c92a549dd5a330112";
	
	public static final float COST_SPEMAT = 65000.00f;			//专用材料费
	
	public static final float COST_TRAVEL = 55000.00f;			//差旅费
	
	public static final float COST_INFORM = 12500.00f;			//咨询费
	
	public static final float COST_MEETTING = 7500.00f;		//会议费
	
	public static final float COST_POST = 6500.00f;			//邮电费
	
	public static final float COST_OFFICE = 1600.00f;			//办公费
	
	public static final float COST_OTHER = 6500.00f;			//其他费用
	
	public static Map<Object, Object> getAdvance(){
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("spemat", COST_SPEMAT);
		map.put("travel", COST_TRAVEL);
		map.put("inform", COST_INFORM);
		map.put("meetting", COST_MEETTING);
		map.put("post", COST_POST);
		map.put("office", COST_OFFICE);
		map.put("other", COST_OTHER);
		map.put("total", COST_INFORM+COST_MEETTING+
				COST_OFFICE+COST_OTHER+COST_POST+
				COST_SPEMAT+COST_TRAVEL+COST_OTHER);
		return map;
	}
}
