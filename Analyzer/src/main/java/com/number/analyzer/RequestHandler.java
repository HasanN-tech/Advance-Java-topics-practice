package com.number.analyzer;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class RequestHandler extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action=req.getParameter("action");
		RequestDispatcher rd = null;
		
		if(action.equals("Palindrome")) {
			rd=req.getRequestDispatcher("palindrome");
		}else if(action.equals("Prime")) {
			rd=req.getRequestDispatcher("prime");
		}else if(action.equals("Spy")) {
			rd=req.getRequestDispatcher("spy");
		}else if(action.equals("EvenOdd")) {
			rd=req.getRequestDispatcher("evenOdd");
		}
		
		rd.forward(req, resp);
	}
}
