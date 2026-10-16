package com.project.servlets;

import java.io.IOException;

import com.project.DAO.OrderDao;
import com.project.beans.OrderBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/updateBook")
public class Update extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		int qty=Integer.parseInt(req.getParameter("qty"));
		String status=req.getParameter("status");
		
		OrderBean bb=new OrderBean();
		bb.setId(id);
		bb.setProduct(name);
		bb.setQuantity(qty);
		bb.setStatus(status);
		
		OrderDao bd=new OrderDao();
		int k=bd.update(bb);
		
		if(k>0) resp.sendRedirect("loginSuccess.html");
		else resp.getWriter().println("Updation Failed");
		
	}
	
}
