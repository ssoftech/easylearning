package edu.easylearning.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		   PrintWriter out=response.getWriter(); 
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		HttpSession admin = request.getSession();
		if (username.equals("admin") && password.equals("admin")) {
			
			  out.print("Welcome, "+username);  
			admin.setAttribute("username", username);
            
			response.sendRedirect("adminpanel/index.jsp");
		}

		else {
			String msg = "user name or password incorrect";
			admin.setAttribute("message", msg);
        
        
			response.sendRedirect("adminpanel/login.jsp");

		}
        out.close();
	}

}
