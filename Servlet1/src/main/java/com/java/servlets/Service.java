package com.java.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Service extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		String fname=req.getParameter("fname");
		String lname=req.getParameter("lname");
		String email=req.getParameter("email");
		Long phNo=Long.parseLong(req.getParameter("phNo"));
		
		PrintWriter out=resp.getWriter();
		
		if(id<=0) out.print("Id must be positive and Greater Than 0.");
		else if(!email.contains("@")) out.printf("Email is not valid");
		else {
		out.println("User ID: "+id);
		out.println("User FName: "+fname);
		out.println("User LName: "+lname);
		out.println("User Email: "+email);
		out.println("User Ph No.: "+phNo);
		}
	}
	
}
