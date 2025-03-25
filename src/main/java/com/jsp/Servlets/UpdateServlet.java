package com.jsp.Servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = DBConnection.getInstance();
		int id = Integer.parseInt(request.getParameter("id"));
		
		DBElements elements = dao.findById(id);
		request.setAttribute("id", elements.getId());
		request.setAttribute("name", elements.getName());
		request.setAttribute("number", elements.getNumber());
		
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = DBConnection.getInstance();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int number = Integer.parseInt(request.getParameter("number"));
		
		dao.updateUser(id,name,number);
		
		request.getRequestDispatcher("showAll").forward(request, response);
	}

}
