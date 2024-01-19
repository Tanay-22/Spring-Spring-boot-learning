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
    <title>Get Property</title>
</head>
<body>
    <jsp:useBean id="user" class="com.example.beans.User" scope="session"></jsp:useBean>

    First Name : <jsp:getProperty name="user" property="firstName"/><br/>
    Last Name : <jsp:getProperty name="user" property="lastName"/>

</body>
</html>
