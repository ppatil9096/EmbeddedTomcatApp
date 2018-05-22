package com.pravin.embeded.tomcat;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int a = Integer.parseInt(req.getParameter("a"));
	int b = Integer.parseInt(req.getParameter("b"));
	int sum = a + b;

	String result = String.format("%d + %d = %d", a, b, sum);

	PrintWriter writer = resp.getWriter();
	writer.println("<html><title>Addition</title><body>");
	writer.println("<h1>" + result + "</h1");
	writer.println("</body></html>");
    }
}
