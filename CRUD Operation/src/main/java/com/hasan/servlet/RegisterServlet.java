package com.hasan.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.hasan.DAO.RegisterDAO;
import com.hasan.bean.Register;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String i=req.getParameter("id");
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		int id=Integer.parseInt(i);
		
		Register r=new Register();
		r.setId(id);
		r.setName(name);
		r.setEmail(email);
		r.setPassword(password);
		
		RegisterDAO rd=new RegisterDAO();
		int row=rd.registration(r);
		
		if(row>0) resp.sendRedirect("home.html");
		else resp.getWriter().println("Registration Failed..");
	}

	
}
