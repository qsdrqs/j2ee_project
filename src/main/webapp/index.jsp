<%--
  Created by IntelliJ IDEA.
  User: dengyb
  Date: 2020/7/3
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>测试保存</h2>
<a href="user/findAll1">查询所有的用户信息</a>
<form action="${pageContext.request.contextPath}/user/add" method="post">
    用户姓名：<input type="text" name="userName"/><br/>
    性别：<input type="text" name="userSex"/><br/>
    账号：<input type="text" name="userAccount"/><br/>
    <input type="submit" value="提交"/>
</form>
<jsp:forward page="./pages/main.jsp"></jsp:forward>
</body>
</html>
