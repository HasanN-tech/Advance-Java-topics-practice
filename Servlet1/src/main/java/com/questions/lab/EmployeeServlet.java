package com.questions.lab;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EmployeeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		 resp.setContentType("text/html");
		
		PrintWriter out=resp.getWriter();
		 out.println("<html><body>");
	        out.println("<h2>Employee Details</h2>");
	        out.println("ID: 101<br>");
	        out.println("Name: Aniket<br>");
	        out.println("Department: IT<br>");
	        out.println("Salary: 50000");
	        out.println("</body></html>");
	}
	
}
