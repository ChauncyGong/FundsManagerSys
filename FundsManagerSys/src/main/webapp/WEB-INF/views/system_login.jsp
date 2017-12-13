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
<title>教师网络报账查询系统-登录</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=basePath%>resources/css/login.css">
</head>
<body>
<div class="login_body">
    <div class="login_top">
        <label class="systemTitle">教师网络报账查询系统</label><br/>
    </div>
    <div class="login_bottom">
        <form action="login_in" method="post" class="login">
            <label class="logintitle">登录您的账户</label><br/>
            <label class="username">工号：</label><input id="username" type="text" name="job_Number" placeholder="请输入工号"/>
            <c:if test="${requestScope.LOGIN_STATUS=='FAIL_ACCOUNT'}">
            	<label id="name_error"><img src="<%=basePath%>resources/img/errorImage.png"/></label>
            </c:if>
            <br/>
            <label class="password">密码：</label><input id="password" type="password" name="password" placeholder="请输入密码"/>
            <c:if test="${requestScope.LOGIN_STATUS=='FAIL_PASSWORD'}">
            	<label id="pwd_error"><img src="<%=basePath%>resources/img/errorImage.png"/></label>
            </c:if>
            <br/>
            <input type="submit" value="登录"/><br/>
        </form>
    </div>
</div>
</body>
</html>
