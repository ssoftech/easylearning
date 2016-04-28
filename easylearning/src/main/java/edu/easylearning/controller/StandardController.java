package edu.easylearning.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.easylearning.model.Standard;
import edu.easylearning.service.StandardServices;

@WebServlet("/StandardController")
public class StandardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Standard entity = new Standard();
		entity.setId(id);

		StandardServices service = new StandardServices();
		int isSuccess = service.delete(entity);

		if (isSuccess > 0) {
			request.setAttribute("Msg", "Data Saved Successfully !!");

			response.sendRedirect("adminpanel/standard.jsp");

		} else {
			request.setAttribute("Msg", "Error !! Kindly Check..");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("hiii");

		HttpSession session = request.getSession();

		if (request.getParameter("action") != null) {

			String action = request.getParameter("action");

			if (action.equals("save")) {
				System.out.println("2");
				System.out.println("hncjjk");
				String name = request.getParameter("standard");

				Standard entity = new Standard();
				entity.setName(name);
				String username = (String) session.getAttribute("username");
				System.out.println("username" + username);
				entity.setCreatedby(username);
				StandardServices service = new StandardServices();
				int isSuccess = service.save(entity);
				System.out.println("isSuccess " + isSuccess);
				if (isSuccess > 0) {
					request.setAttribute("Msg", "Data Saved Successfully !!");

					response.sendRedirect("adminpanel/standard.jsp");
				} else {
					request.setAttribute("Msg", "Error !! Kindly Check..");

					response.sendRedirect("adminpanel/standard.jsp");
				}

			}

		}

		if (request.getParameter("action") != null) {
			String action = request.getParameter("action");
			if (action.equals("edit")) {
				System.out.println("1");
				int id = Integer.parseInt(request.getParameter("id1"));
				String standard = request.getParameter("standard");

				Standard entity = new Standard();
				entity.setId(id);
				entity.setName(standard);
				String username = (String) session.getAttribute("username");
				System.out.println("username" + username);
				entity.setModifiedby(username);
                 
				StandardServices service = new StandardServices();
				int isSuccess = service.update(entity);
				System.out.println("isSuccess " + isSuccess);
				if (isSuccess > 0) {
					request.setAttribute("Msg", "Data Saved Successfully !!");

					response.sendRedirect("adminpanel/standard.jsp");
				} else {
					request.setAttribute("Msg", "Error !! Kindly Check..");

					response.sendRedirect("adminpanel/standard.jsp");
				}

			}

		}
	}
}
