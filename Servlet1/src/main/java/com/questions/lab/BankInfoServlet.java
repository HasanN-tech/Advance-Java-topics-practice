package com.questions.lab;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BankInfoServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		PrintWriter out=resp.getWriter();
		
		ServletConfig config=getServletConfig();
		
		String bname=config.getInitParameter("BranchName");
		String mname=config.getInitParameter("BranchManager");
		
		out.println("Branch Name: "+bname);
		out.println("Manager Name: "+mname);
	}
}
