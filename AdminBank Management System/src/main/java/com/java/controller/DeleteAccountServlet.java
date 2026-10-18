package com.java.controller;

import java.io.IOException;
import com.java.services.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteAccountServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acc = request.getParameter("id");

        AdminService service = new AdminServiceImpl();

        if(service.deleteAccount(acc)) {        	
        	response.sendRedirect("ViewAccountsServlet");
        }
        else {
        	response.sendRedirect("ViewAccountsServlet");
        }

    }
}