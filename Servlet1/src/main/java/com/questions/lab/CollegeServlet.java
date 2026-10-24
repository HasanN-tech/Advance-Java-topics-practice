package com.questions.lab;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CollegeServlet  extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out=resp.getWriter();
		
		ServletContext context=getServletContext();
		ServletConfig config=getServletConfig();
		
		String clgName=context.getInitParameter("clgName");
		String deptName=config.getInitParameter("deptName");
		
		out.println("College Name: "+clgName);
		out.println("Department Name: "+deptName);
	}
}
