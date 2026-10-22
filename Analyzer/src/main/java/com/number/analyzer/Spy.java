package com.number.analyzer;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Spy extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		int num=Integer.parseInt(req.getParameter("num"));
		int sum=0,prod=1,temp=num;
		
		while(num>0) {
			int l=num%10;
			sum += l;
			prod *=l;
			num /=10;
		}
		if(sum==prod) out.println(temp+" is Spy number");
		else out.println(temp+" is not Spy number");
	}
	
}
