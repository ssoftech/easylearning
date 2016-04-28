package edu.easylearning.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.easylearning.model.Subject;
import edu.easylearning.service.SubjectService;

@WebServlet("/SubjectController")
public class SubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 
		HttpSession session = request.getSession();
		if (request.getParameter("action") != null) {
			String action = request.getParameter("action");
			if (action.equals("save")) {

				String subject = request.getParameter("subject");

				Subject entity = new Subject();
				entity.setName(subject);
				String username = (String) session.getAttribute("username");
				System.out.println("username" + username);
				entity.setCreatedby(username);

				SubjectService service = new SubjectService();
				int isSuccess = service.save(entity);

				if (isSuccess > 0) {
					request.setAttribute("Msg", "Data Saved Successfully !!");

					response.sendRedirect("adminpanel/subject.jsp");
				} else {
					request.setAttribute("Msg", "Error !! Kindly Check..");

					response.sendRedirect("adminpanel/subject.jsp");
				}

			}
			if (action.equals("edit")) {
				System.out.println("1");
				int id = Integer.parseInt(request.getParameter("id1"));
				String subject = request.getParameter("subject");

				Subject entity = new Subject();
				entity.setId(id);
				entity.setName(subject);
				String username = (String) session.getAttribute("username");
				System.out.println("username" + username);
				entity.setModifiedby(username);
				
				SubjectService service = new SubjectService();
				int isSuccess = service.update(entity);
				System.out.println("isSuccess " + isSuccess);
				if (isSuccess > 0) {
					request.setAttribute("Msg", "Data Saved Successfully !!");

					response.sendRedirect("adminpanel/subject.jsp");
				} else {
					request.setAttribute("Msg", "Error !! Kindly Check..");

					response.sendRedirect("adminpanel/subject.jsp");
				}

			}
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		Subject entity = new Subject();
		entity.setId(id);

		SubjectService service = new SubjectService();
		int isSuccess = service.delete(entity);

		if (isSuccess > 0) {
			request.setAttribute("Msg", "Data Saved Successfully !!");

			response.sendRedirect("adminpanel/subject.jsp");
		} else {
			request.setAttribute("Msg", "Error !! Kindly Check..");

			response.sendRedirect("adminpanel/subject.jsp");
		}

	}
}
