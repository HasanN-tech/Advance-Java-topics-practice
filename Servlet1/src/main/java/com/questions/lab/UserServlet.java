package com.questions.lab;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		
		PrintWriter out=resp.getWriter();
		out.println("<html><body>");
        out.println("<h2>User Details</h2>");
        out.println("Name: Hasan<br>");
        out.println("Email: hasan@gmail.com<br>");
        out.println("Age: 22");
        out.println("</body></html>");
	}
}
