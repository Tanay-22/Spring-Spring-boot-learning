package com.example.servletssessions;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "MemberAreaController", value = "/MemberAreaController")
public class MemberAreaController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String action = request.getParameter("action");
        switch (action)
        {
            case "destroy":
                request.getSession().invalidate();
                /*Cookie cookies[] = request.getCookies();
                for(Cookie cookie : cookies)
                {
                    if(cookie.getName().equals("username"))
                    {
                        cookie.setValue(null);
                        cookie.setMaxAge(0);
                        response.addCookie(cookie);
                    }
                }*/
                response.sendRedirect("login.jsp");
                break;
            case "memberArea":
                request.getRequestDispatcher("memberArea.jsp").forward(request, response);
                break;
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
