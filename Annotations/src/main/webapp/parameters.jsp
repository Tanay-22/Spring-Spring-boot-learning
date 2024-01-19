<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 19-01-2024
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Parameters</title>
</head>
<body>
<%
  out.println("Value 1: " + request.getParameter("value1"));
  out.println("Value 2: " + request.getParameter("value2"));
%>
</body>
</html>
