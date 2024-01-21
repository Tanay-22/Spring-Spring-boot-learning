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
    <jsp:useBean id="user" class="com.example.beans.User" scope="session"></jsp:useBean>
    <form action="getSessionProperty.jsp" method="post">
      First Name: <input type="text" name="firstName"
                         value="<jsp:getProperty name="user" property="firstName"/>">
        <br/>
      Last Name: <input type="text" name="lastName"
                         value="<jsp:getProperty name="user" property="lastName"/>">
        <br/>
        <input type="submit" value="submit">
    </form>

</body>
</html>
