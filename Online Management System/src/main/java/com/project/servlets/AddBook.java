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
@WebServlet("/addBook")
public class AddBook extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String qty=req.getParameter("qty");
		String status=req.getParameter("status");
		
		Integer i=Integer.parseInt(id);
		Integer q=Integer.parseInt(qty);
		
		OrderBean bb=new OrderBean();
		
		bb.setId(i);
		bb.setProduct(name);
		bb.setQuantity(q);
		bb.setStatus(status);
		
		OrderDao bd=new OrderDao();
		int k=bd.add(bb);
		
		if(k>0)
			resp.getWriter().println("Added Successfully");
		else resp.getWriter().println("Failed to Add");
	}

}
