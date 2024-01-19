<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 20-01-2024
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Submit</title>
</head>
<body>
    Name : <%= request.getParameter("name")%><br/>
    Gender : <%= request.getParameter("gender")%><br/>
    Language know :
    <%
        String countries[] =  request.getParameterValues("language");
        if(countries != null)
            for ( String country : countries )
            out.println(country + " ");
        else
            out.print("None Selected");
    %><br/>
    Country : <%= request.getParameter("country")%>
</body>
</html>
