<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 20-01-2024
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form</title>
</head>
<body>
    <%--<form action ="submit.jsp" method="post">--%>
    <form action="<%= request.getContextPath()%>/Controller" method="post">
        Full Name : <input type="text" name="name" required><br/>
        Gender : <input type="radio" name="gender" value="male" checked>Male
                 <input type="radio" name="gender" value="female">Female<br/>
        Language know : <input type="checkbox" name="language" value="english">English
                        <input type="checkbox" name="language" value="hindi">Hindi
                        <input type="checkbox" name="language" value="french">French<br/>
        Country : <select name="country">
                    <option value="india">India</option>
                    <option value="usa">USA</option>
                    <option value="uk">UK</option>
                    <option value="finland">Finland</option>
                    <option value="fiji">Fiji</option>
                  </select><br/>
        <input type="submit" value="submit">
    </form>
</body>
</html>
