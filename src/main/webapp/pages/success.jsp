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
<head>
    <title>测试成功专用</title>
</head>
<body>
<h3>查询了所有的账户信息</h3>
<c:forEach items="${requestScope.list}" var="user">


    ${user.userId }
    ${user.userName }
    ${user.userSex }
    ${user.userAccount }
    ${user.userPassword }
    ${user.userTelephone }
    ${user.userMail }
</c:forEach>
</body>
</html>
