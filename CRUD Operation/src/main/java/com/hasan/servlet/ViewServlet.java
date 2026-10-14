package com.hasan.servlet;

import java.io.IOException;
import java.util.List;

import com.hasan.DAO.OrderDAO;
import com.hasan.bean.Order;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    
        OrderDAO dao = new OrderDAO();
        List<Order> list = dao.getAllOrders();

        // Step 2: Set data in request scope
        request.setAttribute("orderList", list);

        // Step 3: Forward to JSP
        RequestDispatcher rd = request.getRequestDispatcher("/view");
        rd.forward(request, response);
    }
}