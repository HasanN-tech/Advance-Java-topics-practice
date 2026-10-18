package com.java.controller;

import java.io.IOException;
import com.java.services.*;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import com.bank.model.Account;

public class SearchAccountServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	String id = request.getParameter("User_id");

        AdminService service = new AdminServiceImpl();

        Account acc = service.searchAccount(id);

        request.setAttribute("account", acc);

        RequestDispatcher rd = request.getRequestDispatcher("searchAccount.jsp");
        rd.forward(request, response);
    }
}