<%@ page import="grp.wudi.j2ee.entity.Agent" %><%--
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
<h3>查询了所有的经纪人账户信息</h3>
<%--<c:forEach items="${requestScope.list}" var="user">--%>


<%--    ${user.userId }--%>
<%--    ${user.userName }--%>
<%--    ${user.userSex }--%>
<%--    ${user.userAccount }--%>
<%--    ${user.userPassword }--%>
<%--    ${user.userTelephone }--%>
<%--    ${user.userMail }--%>
<%--</c:forEach>--%>
<c:forEach items="${requestScope.agentList}" var="agent">
  ID:  ${agent.agentId}<br/>
   姓名: ${agent.agentName}<br/>
   性别: ${agent.agentSex}<br/>
   电话号码: ${agent.agentTel}<br/>
   电子邮件: ${agent.agentEmail}<br/>
   注册时间: ${agent.registerTimeStr}<br/>
    离职时间:${agent.leaveTimeStr}
</c:forEach>

ID:${agentInfo.agentId}<br/>
姓名：${agentInfo.agentName}<br/>
性别：${agentInfo.agentSex}<br/>
电话：${agentInfo.agentTel}<br/>
邮件：${agentInfo.agentEmail}<br/>

注册时间：${agentInfo.registerTimeStr}<br/>
离职时间：${agentInfo.leaveTimeStr}<br/>
个人说明：${agentInfo.agentProfile}<br/>
账户：${agentInfo.agentAccount}<br/>
密码：${agentInfo.agentPassword}<br/>

<br/>
</body>
</html>
