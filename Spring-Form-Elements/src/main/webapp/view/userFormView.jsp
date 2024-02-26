<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 26-02-2024
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>User Form</title>
</head>
<body>
	<form:form action="displayUserInfo" modelAttribute="user">
		Name: <form:input path="name"/>
		<p>
		Gender: Male<form:radiobutton path="gender" value="male"/>
				Female<form:radiobutton path="gender" value="female"/>
		</p>
		<input type="submit" value="submit">
	</form:form>
</body>
</html>
