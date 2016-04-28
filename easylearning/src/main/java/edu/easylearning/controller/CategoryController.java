package edu.easylearning.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.easylearning.model.Category;
import edu.easylearning.service.CategoryService;

@WebServlet("/CategoryController")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (request.getParameter("action") != null) {
			String action = request.getParameter("action");
			if (action.equals("save")) {

				String category = request.getParameter("category");

				Category entity = new Category();
				entity.setName(category);
				String username = (String) session.getAttribute("username");
				System.out.println("username" + username);
				entity.setCreatedby(username);

				CategoryService service = new CategoryService();
				int isSuccess = service.save(entity);

				if (isSuccess > 0) {
					request.setAttribute("Msg", "Data Saved Successfully !!");

					response.sendRedirect("adminpanel/category.jsp");
				} else {
					request.setAttribute("Msg", "Error !! Kindly Check..");

					response.sendRedirect("adminpanel/category.jsp");
				}

			}
			if (action.equals("edit")) {
				System.out.println("1");
				int id = Integer.parseInt(request.getParameter("id1"));
				String category = request.getParameter("category");

				Category entity = new Category();
				entity.setId(id);
				entity.setName(category);
				String username = (String) session.getAttribute("username");
				System.out.println("username" + username);
				entity.setModifiedby(username);
				CategoryService service = new CategoryService();
				int isSuccess = 0;
				try {
					isSuccess = service.update(entity);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("isSuccess " + isSuccess);
				if (isSuccess > 0) {
					request.setAttribute("Msg", "Data Saved Successfully !!");

					response.sendRedirect("adminpanel/category.jsp");
				} else {
					request.setAttribute("Msg", "Error !! Kindly Check..");

					response.sendRedirect("adminpanel/category.jsp");
				}

			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		Category entity = new Category();
		entity.setId(id);

		CategoryService service = new CategoryService();
		int isSuccess = service.delete(entity);

		if (isSuccess > 0) {
			request.setAttribute("Msg", "Data delete Successfully !!");

			response.sendRedirect("adminpanel/category.jsp");

		} else {
			request.setAttribute("Msg", "Error !! Kindly Check..");

			response.sendRedirect("adminpanel/category.jsp");
		}

	}

}
