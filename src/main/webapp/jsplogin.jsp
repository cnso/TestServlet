<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: majie
  Date: 2022/1/10
  Time: 1:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <% List<String> list = (List<String>) request.getAttribute("list"); %>
</head>
<body>
<%--    <p><%= "root".equals(request.getParameter("username")) && "123".equals(request.getParameter("password")) ? "登录成功" : "登录失败"%></p>--%>
    <ol>
        <% for (String s: list) { %>
            <li style="font-family: 'Andale Mono',ui-monospace"><%= s %></li>
        <% } %>
    </ol>
</body>
</html>
