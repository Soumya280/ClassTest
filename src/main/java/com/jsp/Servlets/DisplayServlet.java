package com.jsp.Servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/display")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id1 =Integer.parseInt(request.getParameter("id"));
		String name1 = request.getParameter("name");
		
		DBElements elements = DBConnection.getInstance().findByIdAndName(id1, name1);

			if (elements == null) {
				request.setAttribute("error", true);
				
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else {
				request.setAttribute("id", elements.getId());
				request.setAttribute("name", elements.getName());
				request.setAttribute("number", elements.getNumber());
				
				Cookie cookie = new Cookie("username", name1);

 				cookie.setMaxAge(60 * 60 * 24);
 				
			    response.addCookie(cookie);
			    
				request.getRequestDispatcher("display.jsp").forward(request, response);
			}
			
			
//			request.setAttribute("id", elements.getId());
//			request.setAttribute("name", elements.getName());
//			request.setAttribute("number", elements.getNumber());
//			
//			request.getRequestDispatcher("display.jsp").forward(request, response);
		
	}

}
