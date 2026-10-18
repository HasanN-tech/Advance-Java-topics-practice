package com.java.controller;

import java.io.IOException;

import com.java.services.AdminService;
import com.java.services.AdminServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AdminLoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 🔹 Step 1: Get data from form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 🔹 Step 2: Call Service Layer
        AdminService service = new AdminServiceImpl();
        boolean isValid = service.login(username, password);

        if (isValid) {

            HttpSession session = request.getSession();
            session.setAttribute("admin", username);

            response.sendRedirect("adminDashboard.jsp");

        } else {
            request.setAttribute("error", "Invalid Username or Password");

            RequestDispatcher rd = request.getRequestDispatcher("home.html");
            rd.forward(request, response);
        }
    }
}