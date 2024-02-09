<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 22-01-2024
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Member Area</title>
</head>
<body>
	<%
		String username = null, sessionID = null;

        /*Cookie cookies[] = request.getCookies();
        if(cookies != null)
		{
			for (Cookie cookie: cookies)
			{
				if(cookie.getName().equals("username"))
					username = cookie.getValue();
				if(cookie.getName().equals("JSESSIONID"))
					sessionID = cookie.getValue();

			}
		}*/

		if(request.getSession().getAttribute("username") == null)
			response.sendRedirect(request.getContextPath()+"/SiteController?action=login");
        else
		{
            username = request.getSession().getAttribute("username").toString();
            sessionID = request.getSession().getId();
		}
        if (sessionID == null || username == null)
            response.sendRedirect("login.jsp");
	%>
	Username : <%= username%><br/>
	Current Session : <%= sessionID%><br/>
	Member Area
	<form action="<%= request.getContextPath()%>/MemberAreaController" method="get">
		<input type="hidden" name="action" value="destroy">
		<input type="submit" value="logout">
	</form>
</body>
</html>
