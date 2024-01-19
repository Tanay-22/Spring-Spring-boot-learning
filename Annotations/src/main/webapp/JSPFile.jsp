<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 19-01-2024
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP Files</title>
</head>
<body>
<h1>
    <%--Directive Elements--%>
    <%@ include file="file1.txt" %> <%--for files of STATIC nature--%>
</h1>
<h3> <jsp:include page="file2.txt"></jsp:include> </h3> <%--for files of DYNAMIC nature--%>


<%@ page import = "java.util.Date, userDefinedPackage.UserDefined" %> <%--importing CLASS--%>
<%= new Date()%>
<br>
<%  out.print(new UserDefined().demo());   %>

</body>
</html>
