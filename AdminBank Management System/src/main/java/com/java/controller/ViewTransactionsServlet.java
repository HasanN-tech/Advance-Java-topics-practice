package com.java.controller;

import java.io.IOException;
import java.util.*;

import com.java.services.*;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import com.bank.model.Transaction;

public class ViewTransactionsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        AdminService service = new AdminServiceImpl();

        String id = request.getParameter("id");

        List<Transaction> list;

        if(id == null || id.equals("")){
            list = service.viewAllTransactions();
        } else {
            list = service.viewTransactions(id);
        }

        request.setAttribute("transactions", list);

        RequestDispatcher rd = request.getRequestDispatcher("viewTransactions.jsp");
        rd.forward(request, response);
    }
}