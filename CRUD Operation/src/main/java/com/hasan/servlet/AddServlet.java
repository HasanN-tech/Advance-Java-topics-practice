package com.hasan.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.hasan.DAO.OrderDAO;
import com.hasan.bean.Order;

/**
 * Servlet implementation class Add
 */
@WebServlet("/Add")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String i=req.getParameter("id");
		int id=Integer.parseInt(i);
		String product=req.getParameter("product");
		int qty=Integer.parseInt(req.getParameter("quantity"));
		String status=req.getParameter("status");
		
		Order o=new Order();
		o.setId(id);
		o.setProduct(product);
		o.setQuantity(qty);
		o.setStatus(status);
		
		OrderDAO od=new OrderDAO();
		int row=od.add(o);
		if(row > 0) resp.sendRedirect("loginSuccess.html");
		else resp.getWriter().println("Addition failed");
	}

}
