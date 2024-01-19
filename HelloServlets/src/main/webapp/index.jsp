<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<%! public int i = 19; %>   <%--declaration element--%>
<br/>
<a href="hello-servlet"><%= i %> <%= new java.util.Date() %></a><%--expression elements--%>

<%
    for (int j = 0; j < 20; j++)
    {
        out.print("<br>" + j);
    }
%>
<% response.sendRedirect("https://www.youtube.com/");%>
</body>
</html>