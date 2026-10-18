package com.java.controller;

import java.io.IOException;
import java.util.*;

import com.bank.model.Account;
import com.java.services.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ViewAccountsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        AdminService service = new AdminServiceImpl();

        List<Account> list = service.viewAllAccounts();

        request.setAttribute("accounts", list);

        RequestDispatcher rd = request.getRequestDispatcher("viewAccounts.jsp");
        rd.forward(request, response);
    }
}