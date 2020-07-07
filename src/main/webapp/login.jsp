<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>二手房交易后台管理系统</title>
</head>
<body>
	<div id="login-container">
		<h2>欢迎来到后台管理系统</h2>
		<br />
		<form action="/admin/login.do" method="post">
			<input type="text" id="adminid" name="adminAccount" value="" placeholder="用户名"><br /> <input
				type="password" id="password" name="adminPassword" value="" placeholder="密码"><br />
			<button class="loginBtn" id="login-button" type="submit">登录</button>
			<br />
		</form>
	</div>
</body>
</html>