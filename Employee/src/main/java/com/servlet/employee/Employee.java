package com.servlet.employee;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Employee extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		int age=Integer.parseInt(req.getParameter("age"));
		long salary=Long.parseLong(req.getParameter("salary"));
		String mailId=req.getParameter("mailId");
		String gender = req.getParameter("gender");
        String state = req.getParameter("state");
        String[] hobbies = req.getParameterValues("hobbies");
        
        String hobbyList="";
        if(hobbies !=null) {
        	for(int i=0;i<hobbies.length;i++) {
        		hobbyList +=hobbies[i];
        		if(i!=hobbies.length-1) {
        			hobbyList +=", ";
        		}
        	}
        }
        
        PrintWriter out=resp.getWriter();
        
        out.println("<html><body>");
        out.println("<h2>Employee Details</h2>");

        out.println("Employee Name: " + name + "<br>");
        out.println("Employee Age: " + age + "<br>");
        out.println("Employee Salary: " + salary + "<br>");
        out.println("Employee MailId: " + mailId + "<br>");
        out.println("Employee Gender: " + gender + "<br>");
        out.println("Employee Hobbies: " + hobbyList + "<br>");
        out.println("Employee State: " + state + "<br>");

        out.println("</body></html>");
	}
	
}
