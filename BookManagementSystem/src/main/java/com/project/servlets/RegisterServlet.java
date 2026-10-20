package com.project.servlets;

import java.io.IOException;

import com.project.DAO.AdminDAO;
import com.project.beans.AdminBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/reg")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String fname=req.getParameter("fname");
		resp.getWriter().println("Fname added");
		String lname=req.getParameter("lname");
		resp.getWriter().println("Lname added");
		String name=req.getParameter("name");
		resp.getWriter().println("name added");
		String pass=req.getParameter("pass");
		resp.getWriter().println("pass added");
		String email=req.getParameter("mailId");
		resp.getWriter().println("email added");
		String phone=req.getParameter("phNo");
		Long phno=Long.parseLong(phone);
		resp.getWriter().println("Phone added");
		
		AdminBean ab=new AdminBean();
		ab.setFname(fname);
		ab.setLname(lname);
		ab.setName(name);
		ab.setPass(pass);
		ab.setEmail(email);
		ab.setPhone(phno);
		
		AdminDAO ad= new AdminDAO();
		int k=ad.register(ab);
		
		if(k>0) {
			resp.getWriter().println("Registration Successful");
		}
		else resp.getWriter().println("Registration Failed");
	}
	
}
