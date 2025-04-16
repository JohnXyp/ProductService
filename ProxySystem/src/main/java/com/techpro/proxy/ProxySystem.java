package com.techpro.proxy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * This servlet handles GET requests to /proxy-system.
 * It shows a simple message and redirects to Swagger UI after 2 seconds.
 */
@WebServlet("/proxy-system")
public class ProxySystem extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv='refresh' content='2;URL=http://localhost:8081/swagger-ui/index.html'/>");
        out.println("<title>Redirecting...</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>System reached</h2>");
        out.println("<p>You will be redirected to the Swagger UI shortly...</p>");
        out.println("</body>");
        out.println("</html>");
    }
}