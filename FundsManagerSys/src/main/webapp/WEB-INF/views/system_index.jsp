<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<title>教师网络报账查询系统-首页</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=basePath%>resources/css/index.css">
<script src="<%=basePath%>resources/script/jquery.js"></script>
<script src="<%=basePath%>resources/script/echarts.js"></script>
<script src="<%=basePath%>resources/script/chart.js"></script>
<script src="<%=basePath%>resources/script/jquery_form.js"></script>
<script src="<%=basePath%>resources/script/userPage.js"></script>
</head>
<body>
<div class="index_div">

    <div class="index_top">
        <label class="systemTitle">教师网络报账查询系统</label><br/>
    </div>
    <div class="index_nav">
        <div id="logo">
            <img src="${pageContext.request.contextPath}/resources/img/systemlogo.jpg" alt=""/>
            <h3>${sessionScope.user.name }</h3>
        </div>
        <div id="menu" class="menu">
            <ul>
                <li><label id="home">首页</label></li>
                <li><label id="record">查看我的记录</label></li>
                <li><label id="form">报账提交</label></li>
                <li><label id="update">修改密码服务</label></li>
                <li></li>
            </ul>
        </div>
    </div>

    <div  class="index_matter">
        <div id="matter1">
            <div id="main" style="width:80%;height: 60%;top:5%;left:10%;position:absolute;"></div>
            <div style="height:1px; background-color:#C8C8C8; position:absolute; top:70%; left:0px; width:100%;"></div>
            <div class="inform_user" style="width: 100%;height: 20%;top:70%;position: absolute;">
                <span><label class="inform_id">工号</label> </span><span>
                 <span><label class="inform_pre">项目金额</label></span>
                 <span><label class="inform_ed">已报销额</label></span>
                 <span><label class="inform_remain">剩余金额</label></span> <br/>
                <label class="number_id">${sessionScope.user.job_Number }</label></span>
                <span><label class="number_pre">${sessionScope.user.advance_Amount }</label></span>
                <span><label class="number_ed">${sessionScope.user.reimbursed_Expenses }</label></span>
                <span><label class="number_remain">${sessionScope.user.balance }</label></span>
            </div>
        </div>
        
        <div id="matter2" class="record_css" style="display: none">
			<table class="table_css" id ="table_record">
				<tr>
					<th>工号</th>
					<th>姓名</th>
					<th>专用材料费</th>
					<th>差旅费</th>
					<th>咨询费</th>
					<th>会议费</th>
					<th>邮电费</th>
					<th>办公费</th>
					<th>其他费用</th>
					<th>合计</th>
					<th>报账时间</th>
				</tr>
			</table>
			<input type="button" id="page_up" value="上一页"/>
        	<label id="page_num">当前第&nbsp;<span id="curPage"></span>&nbsp;页&nbsp;&nbsp;总共&nbsp;<span id="totalPage"></span>&nbsp;页</label>
        	<input type="button" id="page_down" value="下一页"/>
        </div>
        
         <div id="matter3" style="display: none" >
            <form id="billForm" action="commitBill" method="post" class="bill_form_css">
                <label class="bill_title">账单报销表</label><br/>
                <div style="height:1px; background-color:#E0E0E0; position:absolute; top:15%; left:0px; width:100%;"></div>
                <label id="cost_title">费用填写</label><br/>
                <label id="cost_speMat">专项材料费</label><input id="input_cost_speMat" name="cost_SpeMat" type="text" placeholder="默认为0"/><span id="span_speMat"></span>
                <label id="cost_travel">差旅费</label><input id="input_cost_travel" name="cost_Travel" type="text" placeholder="默认为0"/><span id="span_travel"></span>
                <label id="cost_inform">咨询费</label><input id="input_cost_inform" name="cost_Inform" type="text" placeholder="默认为0"/><span id="span_inform"></span><br/>
                <label id="cost_meeting">会议费</label><input id="input_cost_meeting" name="cost_Meetting" type="text" placeholder="默认为0"/><span id="span_meeting"></span>
                <label id="cost_post">邮电费</label><input id="input_cost_post" name="cost_Post" type="text" placeholder="默认为0"/><span id="span_post"></span>
                <label id="cost_office">办公费</label><input id="input_cost_office" name="cost_Office" type="text" placeholder="默认为0"/><span id="span_office"></span><br/>
                <label id="cost_other">其他费用</label><input id="input_cost_other" name="cost_Other" type="text" placeholder="默认为0"/><span id="span_other"></span>
                <div style="height:1px; background-color:#E0E0E0; position:absolute; top:80%; left:0px; width:100%;"></div>
                <input id="commit" type="button" value="提交"/><br/>
            </form>
        </div>
        
        <div id="matter4" class="find_pwd" style="display:none">
	       	<form action="" method="post" class="find_form">
               <label class="find_title">修改密码服务</label><br/>
               <div style="height:1px; background-color:#E0E0E0; position:absolute; top:15%; left:0px; width:100%;"></div> 
               <label id="old" class="pwd_ed">原始密码</label><input id="input_pwd_ed" name="" type="password" placeholder=""/>
               <label class="pwd_new">新密码</label><input id="input_pwd_new" name="" type="password" placeholder=""/>
               <label class="pwd_renew">确认密码</label><input id="input_pwd_renew" name="" type="password" placeholder=""/>
               <span id="span_find_renew"></span><br/>  
               <div style="height:1px; background-color:#E0E0E0; position:absolute; top:65%; left:0px; width:100%;"></div>
               <input id="updatePass" type="button" value="修改"/><br/>
	        </form>   
       	</div>
	</div>
</div>
</body>
</html>
