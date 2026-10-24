package com.questions.lab;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LibraryServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		ServletContext context=getServletContext();
		String libName=context.getInitParameter("libName");
		
		ServletConfig config=getServletConfig();
		String sec=config.getInitParameter("secName");
		
		String bName=req.getParameter("bookName");
		String authorName=req.getParameter("authorName");
		
		out.println("<html><body>");
		out.println("<h2> Library Information </h2>");
		out.println("Library Name: "+libName+"<br>");
		out.println("Section Name: "+sec);
		
		out.println("<h3> Book Details </h3>");
		out.println("Book Name: "+bName+"<br>");
		out.println("Author Name: "+authorName+"<br>");
	}
}
