<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 22-01-2024
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Login</title>
</head>
<body>
	<form action="<%= request.getContextPath()%>/SiteController" method="post">
		Username : <input type="text" name="username" placeholder="Enter your name"><br/>
		Password : <input type="password" name="password"><br/>
		<input type="hidden" name="action" value="loginSubmit">
		<input type="submit" value="submit">
	</form>
</body>
</html>
