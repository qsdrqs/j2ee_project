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
<a href="agent/findAll">测试查询所有经纪人信息 </a>
<form action="agent/findById" method="post">
    输入要查询的经纪人ID：<input type="text" name="id"/>
    <input type="submit" value="提交查询"/>
</form>

<h3>添加经纪人信息</h3>
<form action="${pageContext.request.contextPath}/agent/addagent" method="post">
    姓名：<input type="text" name="agentName"><br/>
    性别：<input type="text" name="agentSex"><br/>
    电话:<input type="text" name="agentTel"><br/>
    邮件:<input type="text" name="agentEmail"><br/>
    个人说明：<input type="text" name="agentProfile"><br/>
    账户名称:<input type="text" name="agentAccount"><br/>
    密码：<input type="password" name="agentPassword"><br/>
    <input type="submit" value="提交">

</form>

</body>
</html>
