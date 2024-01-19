package withServlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Controller", value = "/Controller")
public class Controller extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        response.getWriter().println(request.getParameter("name"));
        response.getWriter().println(request.getParameter("gender"));

        String languages[] =  request.getParameterValues("language");
        if(languages != null)
            for ( String language : languages )
                out.println(language + " ");
        else
            out.print("None Selected");

        response.getWriter().println(request.getParameter("country"));
        response.getWriter().println(request.getParameter("name"));
    }
}
