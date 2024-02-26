<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 26-02-2024
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Name</title>
</head>
<body>
	Hello <%--<%= request.getAttribute("firstName")%>--%>
		${name}
	<br>
	Today is ${date}
	<br>
	List of Team members :
	<br>
	${list}
</body>
</html>