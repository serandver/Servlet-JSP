package io.javabrains.servletcourse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

public class XmlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String userName = req.getParameter("userName");
        PrintWriter writer = resp.getWriter();
        writer.println("Hello from GET method, " +  userName);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String userName = req.getParameter("userName");
        PrintWriter writer = resp.getWriter();
        writer.println("Hello from POST method, " +  userName);
        String profession = req.getParameter("prof");
        writer.println("Your profession is " + profession);
        String[] location = req.getParameterValues("location");
        writer.println("Your are in " + location.length + " places: \n");
        for (String s: location) {
            writer.println(s + " ");
        }
    }
}
