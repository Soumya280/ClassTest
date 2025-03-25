package com.jsp.Servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int number = Integer.parseInt(request.getParameter("number"));
		
		
		DBElements elements = new DBElements(id,name,number);
		
		boolean isSaved = DBConnection.getInstance().saveUser(elements); 
		
		if(isSaved==true) {
			response.sendRedirect("home.jsp");
		}else {
			request.setAttribute("error", true);
			
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
		
	}

}
