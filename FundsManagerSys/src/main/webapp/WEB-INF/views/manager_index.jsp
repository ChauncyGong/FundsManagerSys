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
<script src="<%=basePath%>resources/script/managerPage.js"></script>
</head>
<body>

<div class="index_div">

    <div class="index_top">
        <label class="systemTitle">管理员操作界面</label><br/>
    </div>

    <div class="index_nav">
        <div id="logo">
            <img src="${pageContext.request.contextPath}/resources/img/systemlogo.jpg" alt=""/>
            <h3>admin</h3>
        </div>
        <div id="menu" class="menu">
            <ul>
                 <li><label id="home">首页</label></li>
                 <li><label id="record">所有记录</label></li>
                <li></li>
            </ul>
        </div>
    </div>

    <div class="index_matter">
        <div id="matter1">
        	<div id="main" style="width:80%;height: 70%;top:5%;left:10%;position:absolute;"></div>
        </div>
        
        <div class="record_css" id="matter2" style="display:none">
			<table id="table_record" class="table_css">
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
    </div>
</div>
</body>
</html>
