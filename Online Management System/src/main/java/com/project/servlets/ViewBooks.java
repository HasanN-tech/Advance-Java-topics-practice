//package com.project.servlets;
//
//import java.io.IOException;
//import java.util.List;
//
//import com.project.DAO.BookDAO;
//import com.project.beans.BookBean;
//
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@SuppressWarnings("serial")
//@WebServlet("/view")
//public class ViewBooks extends HttpServlet {
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		BookDAO bd=new BookDAO();
//		List<BookBean> list=bd.viewAllBooks();
//		
//		req.setAttribute("bookList", list);
//		
//		RequestDispatcher rd=req.getRequestDispatcher("view.jsp");
//		rd.forward(req, resp);
//	}
//	
//}
