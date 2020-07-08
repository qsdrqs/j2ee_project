<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Ihouse后台管理系统</title>
<link rel="stylesheet" type="text/css"
	href="/css/login.css">
</head>
<body >
	<div id="login-container" >
		<h2>Ihouse后台管理系统</h2>
		<br />
		<form action="/admin/login.do" method="post">
			<input type="text" class="userName" name="adminAccount" value=""
				placeholder="用户名"><br /> 
			<input type="password"
				class="password" name="adminPassword" value="" placeholder="密码"><br />
			<button class="loginBtn" id="login-button" type="submit">登录</button>
			<br />
		</form>
		<p id="errorInfo">${param.msg }</p>
	</div>
	<script type="text/javascript"
		src="/js/jquery-3.2.js"></script>
</body>
</html>