<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户信息修改</title>
</head>
<body>
	<form action="/user/update" method="post">
				<input type="hidden" name="userId" value="${user.userId}" /> 
		用户姓名:<input name ="userName" value="${user.userName }" /><b/> <br /> 
		用户性别:<input type ="radio" ${(user.userSex eq '男') ? ' checked=checked ' :'' } name="userSex" value="1" />男 
				<input type ="radio" ${(user.userSex eq '女' ) ? ' checked=checked ' :'' } name="userSex" value="0" />女<br /> 
		用户账户名称:<input name="userAccount" value="${user.userAccount}" /><br /> 
		用户密码:<input name="userPasswordsha256" /><br /> 
		用户邮箱:<input name="userMail" value="${user.userMail}"  /><br /> 
		用户电话:<input name="userTelephone" value="${user.userTelephone }" /> 
				<input type="submit" value="修改" />
	</form>
</body>

</html>