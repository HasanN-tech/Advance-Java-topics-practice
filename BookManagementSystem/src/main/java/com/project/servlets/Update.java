package com.project.servlets;

import java.io.IOException;

import com.project.DAO.BookDAO;
import com.project.beans.BookBean;

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
		String author=req.getParameter("author");
		Double price=Double.parseDouble(req.getParameter("price"));
		int qty=Integer.parseInt(req.getParameter("quantity"));
		
		BookBean bb=new BookBean();
		bb.setBookId(id);
		bb.setBookName(name);
		bb.setAuthor(author);
		bb.setPrice(price);
		bb.setQty(qty);
		
		BookDAO bd=new BookDAO();
		int k=bd.updateBook(bb);
		
		if(k>0) resp.sendRedirect("loginSuccess.html");
		else resp.getWriter().println("Updation Failed");
		
	}
	
}
