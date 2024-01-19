package Parameter;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ParameterServlet", value = "/ParameterServlet")
public class ParameterServlet extends HttpServlet
{
    public ParameterServlet()
    {
        super();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //response.getWriter().println("Paramters huihuihui" + request.getParameter("get"));
        PrintWriter printWriter = response.getWriter();
        printWriter.println("Value 1: " + request.getParameter("value1"));
        printWriter.println("Value 2: " + request.getParameter("value2"));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
