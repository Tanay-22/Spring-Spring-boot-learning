package com.example.servletssessions;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "SiteController", value = "/SiteController")
public class SiteController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(username.equals("DogRaj") && password.equals("Maharaj"))
        {
            // Invalidating session if any
            request.getSession().invalidate();
            HttpSession newSession = request.getSession(true);
            newSession.setMaxInactiveInterval(300);
            // cookies should not be use for login-logout
            /*Cookie cUsername = new Cookie("username", username);
            response.addCookie(cUsername);*/

            newSession.setAttribute("username", username);
            response.sendRedirect("memberArea.jsp");


        }
        else
            response.sendRedirect("login.jsp");
    }
}
