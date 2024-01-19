<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
</head>
<body>
HOMEPAGE
<h1><a href="<%= request.getContextPath() %>/Controller?page=login">Login</a></h1>
<h1><a href="<%= request.getContextPath() %>/Controller?page=signUp">Sign Up</a></h1>
<h1><a href="<%= request.getContextPath() %>/Controller?page=about-us">About Us</a></h1>
</body>
</html>