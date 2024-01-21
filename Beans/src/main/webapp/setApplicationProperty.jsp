<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 20-01-2024
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Set Property</title>
</head>
<%--
    scope types  -->
            1. session - The bean is created once per HTTP session.
            2. application - The bean is scoped to the lifecycle of a ServletContext.
--%>
<body>
    <jsp:useBean id="user" class="com.example.beans.User" scope="application"></jsp:useBean>
    <jsp:setProperty name="user" property="firstName" value="Mr."/>
    <jsp:setProperty name="user" property="lastName" value="India"/>
    Values have been set
</body>
</html>
