//package com.project.servlets;
//
//import java.io.IOException;
//
//import com.project.DAO.BookDAO;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//@SuppressWarnings("serial")
//@WebServlet("/deleteBook")
//public class DeleteBook extends HttpServlet{
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		int id=Integer.parseInt(req.getParameter("bookId"));
//		
//		BookDAO bd=new BookDAO();
//		int k=bd.deleteBook(id);
//		
//		if(k>0) resp.getWriter().println("Book Deleted");
//		else resp.getWriter().println("Deletion FAiled");
//	}
//}
