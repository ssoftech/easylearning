package edu.easylearning.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LogoutController")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("thank you!!, Your session was destroyed successfully!!");
		HttpSession session = request.getSession(false);
		// session.setAttribute("user", null);
		session.removeAttribute("Username");
		session.getMaxInactiveInterval();
		session.invalidate();
		response.sendRedirect("adminpanel/login.jsp");
	}



}
