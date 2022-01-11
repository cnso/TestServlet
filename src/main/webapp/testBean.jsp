<%@ page import="edu.zhuoxun.testservlet.entry.User" %><%--
  Created by IntelliJ IDEA.
  User: majie
  Date: 2022/1/10
  Time: 3:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" class="edu.zhuoxun.testservlet.entry.User" scope="session"/>
<%--<%--%>
<%--    User user = (User) request.getSession().getAttribute("user");--%>
<%--%>--%>

<html>
<head>
    <title>欢迎, <%= user.getNickname() %></title>
</head>
<body>
<p>登录用户: <%= user %></p>
<p>昵称: <%= user.getNickname() %></p>
<p>邮箱: <%= user.getEmail() %></p>
</body>
</html>
