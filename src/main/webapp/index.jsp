<%--
  Created by IntelliJ IDEA.
  User: dengyb
  Date: 2020/7/3
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>测试保存</h2>
<a href="user/findAll">查询所有的用户信息</a>
<form action="user/add" method="post">
    用户姓名：<input type="text" name="userName"/><br/>
    性别：<input type="text" name="userSex"/><br/>
    账号：<input type="text" name="userAccount"/><br/>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
