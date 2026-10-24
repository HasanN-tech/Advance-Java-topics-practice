package com.questions.lab;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CompanyServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		
		ServletContext context=getServletContext();
		
		String name=context.getInitParameter("websiteName");
		String company=context.getInitParameter("companyName");
		String email=context.getInitParameter("customerCare");
		
		out.println("Website Name : "+name);
		out.println("Company Name : "+company);
		out.println("Customer Care: "+email);
	}
	
}
