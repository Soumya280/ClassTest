<%@page import="com.jsp.Servlets.DBElements"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>display</title>
<%@ include file="style.jsp" %>
</head>
<body>

	<%@ include file="navbar.jsp" %>
	

	<%
		int id = (int) request.getAttribute("id");
    	String name = (String) request.getAttribute("name");
    	int number = (int) request.getAttribute("number");
	%>

	<h1>ID : <%= id %> </h1>
	<h1>NAME : <%= name %> </h1>
	<h1>NUMBER : <%= number %></h1>

	<h1><a href="home.jsp">Home</a>|<a href="showAll">Show all users</a>|<a href="logout">LogOut</a></h1>
</body>
</html>