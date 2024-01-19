package control;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Controller", value = "/Controller")
public class Controller extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String params = request.getParameter("page");
        if(params.equals("login"))
            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        else if (params.equals("signUp"))
            getServletContext().getRequestDispatcher("/Signup.jsp").forward(request, response);
        else if(params.equals("about-us"))
            getServletContext().getRequestDispatcher("/About.jsp").forward(request, response);
        else
            getServletContext().getRequestDispatcher("/NotFound.jsp").forward(request, response);
    }
}
