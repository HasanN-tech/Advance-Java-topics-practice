package com.hasan.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.hasan.DAO.OrderDAO;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String i=req.getParameter("id");
		int id=Integer.parseInt(i);
		
		OrderDAO o=new OrderDAO();
		int row=o.delete(id);
		if(row>0) resp.sendRedirect("loginSuccess.html");
		else resp.getWriter().print("Deletion Failed");
	}
}
