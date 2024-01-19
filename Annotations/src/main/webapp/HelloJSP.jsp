<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 19-01-2024
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HELLO JSP</title>
</head>
<body>
    Hemlo JSP
<%--<jsp:forward page="forward.jsp"></jsp:forward>--%>
<%
    //request.getRequestDispatcher("forward.jsp").forward(request, response);
    response.sendRedirect("redirect.jsp");
%>
</body>
</html>
