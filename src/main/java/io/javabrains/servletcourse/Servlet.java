package io.javabrains.servletcourse;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/Servlet"},
            initParams = {@WebInitParam(name = "defaultUser", value = "John Galt")})
public class Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println("Message from annotated-configured Servlet");
        String userName = request.getParameter("name");
        HttpSession session = request.getSession();
        ServletContext context = request.getServletContext();
        if(userName!=null && !userName.isEmpty()) {
            session.setAttribute("savedUserName", userName);
            context.setAttribute("savedUserName", userName);
        }
        writer.println("Request parameter userName is: " + userName);
        writer.println("Session parameter userName is: " + (String) session.getAttribute("savedUserName"));
        writer.println("Context parameter has default userName as: " + (String) context.getAttribute("savedUserName"));
        writer.println("Init parameter has default userName as: " + this.getServletConfig().getInitParameter("defaultUser"));

    }
}
