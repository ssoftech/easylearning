package edu.easylearning.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.easylearning.model.Chapter;
import edu.easylearning.service.ChapterService;


@WebServlet("/ChapterController")
public class ChapterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("enter the connection");
		HttpSession session = request.getSession();
		if(request.getParameter("action")!=null)
		{
			String action = request.getParameter("action");
			if(action.equals("save")){
				
				int standard = Integer.parseInt(request.getParameter("standard"));
				System.out.println("standerd "+standard);
				int subject  = Integer.parseInt(request.getParameter("subject"));
				System.out.println("standerd "+standard);
				String chapter=request.getParameter("chapter");
				Chapter entity = new Chapter();
				entity.setName(chapter);
				entity.setStandardid(standard);
				entity.setSubjectid(subject);
				String username = (String) session.getAttribute("username");
				System.out.println("username" + username);
				entity.setCreatedby(username);
				
				ChapterService service = new ChapterService();
				int isSuccess = service.save(entity);
				

				
				if(isSuccess > 0)
				{
					request.setAttribute("Msg", "Data Saved Successfully !!");
					
					response.sendRedirect("adminpanel/chapter.jsp");
				}
				else
				{
					request.setAttribute("Msg", "Error !! Kindly Check..");
					
					response.sendRedirect("adminpanel/chapter.jsp");
				}
				
				
				
			}
			if(action.equals("edit"))
			{
				System.out.println("1");
				int id = Integer.parseInt(request.getParameter("id1"));
				String chapter = request.getParameter("chapter");
				
				Chapter entity = new Chapter();
				entity.setId(id);
				entity.setName(chapter);
				String username = (String) session.getAttribute("username");
				System.out.println("username" + username);
				entity.setModifiedby(username);
				
				ChapterService service = new ChapterService();
				int isSuccess = service.update(entity);
				System.out.println("isSuccess "+isSuccess);
				if(isSuccess > 0)
				{
					request.setAttribute("Msg", "Data Saved Successfully !!");
					
					response.sendRedirect("adminpanel/chapter.jsp");
				}
				else
				{
					request.setAttribute("Msg", "Error !! Kindly Check..");
					
					response.sendRedirect("adminpanel/chapter.jsp");
				}
				

			}
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("id"));
		Chapter entity = new Chapter();
		entity.setId(id);
		
		ChapterService service = new ChapterService();
		int isSuccess = service.delete(entity);
		
		
		if(isSuccess > 0)
		{
			request.setAttribute("Msg", "Data delete Successfully !!");
			
			response.sendRedirect("adminpanel/chapter.jsp");
			
		}
		else
		{
			request.setAttribute("Msg", "Error !! Kindly Check..");
			
			response.sendRedirect("adminpanel/chapter.jsp");
		}
		
		
		
	}

}
