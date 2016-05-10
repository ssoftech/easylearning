package edu.easylearning.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.easylearning.model.Subcategory;
import edu.easylearning.service.SubcategoryService;

@WebServlet("/SubcategoryController")
public class SubcategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("enter the connection");
		HttpSession session = request.getSession();
		if(request.getParameter("action")!=null)
		{
			String action = request.getParameter("action");
			if(action.equals("save")){
				
				int category = Integer.parseInt(request.getParameter("category"));
				System.out.println("category"+category);
				String subcategory=request.getParameter("subcategory");
				
				Subcategory entity = new Subcategory();
				entity.setName(subcategory);
				entity.setCategoryid(category);
				String username = (String) session.getAttribute("username");
				System.out.println("username" + username);
				entity.setCreatedby(username);
				
				SubcategoryService service = new SubcategoryService();
				int isSuccess = service.save(entity);
				

				
				if(isSuccess > 0)
				{
					request.setAttribute("Msg", "Data Saved Successfully !!");
					
					response.sendRedirect("adminpanel/subcategory.jsp");
				}
				else
				{
					request.setAttribute("Msg", "Error !! Kindly Check..");
					
					response.sendRedirect("adminpanel/subcategory.jsp");
				}
				
				
				
			}
			if(action.equals("edit"))
			{
				System.out.println("1");
				int id = Integer.parseInt(request.getParameter("id1"));
				String subcategory = request.getParameter("subcategory");
				
				Subcategory entity = new Subcategory();
				entity.setId(id);
				entity.setName(subcategory);
				String username = (String) session.getAttribute("username");
				System.out.println("username" + username);
				entity.setModifiedby(username);
				
				SubcategoryService service = new SubcategoryService();
				int isSuccess = service.update(entity);
				System.out.println("isSuccess "+isSuccess);
				if(isSuccess > 0)
				{
					request.setAttribute("Msg", "Data Saved Successfully !!");
					
					response.sendRedirect("adminpanel/subcategory.jsp");
				}
				else
				{
					request.setAttribute("Msg", "Error !! Kindly Check..");
					
					response.sendRedirect("adminpanel/Subcategory.jsp");
				}
				

			}
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("id"));
		Subcategory entity = new Subcategory();
		entity.setId(id);
		
		SubcategoryService service = new SubcategoryService();
		int isSuccess = service.delete(entity);
		
		
		if(isSuccess > 0)
		{
			request.setAttribute("Msg", "Data delete Successfully !!");
			
			response.sendRedirect("adminpanel/subcategory.jsp");
			
		}
		else
		{
			request.setAttribute("Msg", "Error !! Kindly Check..");
			
			response.sendRedirect("adminpanel/subcategory.jsp");
		}
		
		
		
	}

}
