package com.number.analyzer;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Palindrome extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		
		int num=Integer.parseInt(req.getParameter("num"));
		int temp=num , rev=0;
		
		while(num>0) {
			rev=rev*10+num%10;
			num /=10;
		}
		if(rev==temp) out.println(temp+" is Palindrome");
		else out.println(temp+" is not Palindrome");
	}
	
}
