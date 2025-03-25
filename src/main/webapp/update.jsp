<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update</title>
<%@ include file="style.jsp" %>
</head>
<body>

	<%@ include file="navbar.jsp" %>
	<%
		int id = (int) request.getAttribute("id");
    	String name = (String) request.getAttribute("name");
    	int number = (int) request.getAttribute("number");
	%>

<form action="update" method="post">
	<h3>id=<%= id %></h3>
	<input type="text" name="name" value="<%= name %>">
	<input type="text" name="number" value="<%= number %>">
	<input type="submit" value="Update">
</form>
<h1><a href="home.jsp">Home</a>|<a href="showAll">Show all users</a></h1>
</body>
</html>