package com.project.servlets;

import java.io.IOException;

import com.project.DAO.LoginDAO;
import com.project.beans.AdminBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/log")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname=req.getParameter("logName");
		String pass=req.getParameter("logPass");
		
		LoginDAO ld=new LoginDAO();
		AdminBean ab= ld.login(uname, pass);
		
		if(ab != null) {
		    resp.sendRedirect("loginSuccess.html");
		} else {
		    resp.getWriter().println("Invalid Login");
		}
	}
	
}
