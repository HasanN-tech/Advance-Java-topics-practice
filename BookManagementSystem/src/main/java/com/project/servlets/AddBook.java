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
@WebServlet("/addBook")
public class AddBook extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String author=req.getParameter("author");
		String p=req.getParameter("price");
		Double price=Double.parseDouble(p);
		String qty=req.getParameter("qty");
		Integer q=Integer.parseInt(qty);
		
		BookBean bb=new BookBean();
		
		bb.setBookName(name);
		bb.setAuthor(author);
		bb.setPrice(price);
		bb.setQty(q);
		
		BookDAO bd=new BookDAO();
		int k=bd.addBook(bb);
		
		if(k>0)
			resp.getWriter().println("Book Added Successfully");
		else resp.getWriter().println("Failed tp add Book");
	}

}
