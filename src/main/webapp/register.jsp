<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register</title>
<%@ include file="style.jsp" %>
</head>
<body>

	<%@ include file="navbar.jsp" %>
	<%
		Boolean flag = (Boolean) request.getAttribute("error");	
	%>

	<form action="register" method="post">
		<input type="text" name="id" placeholder="id" required>
		<input type="text" name="name" placeholder="name" required>
		<input type="number" name="number" placeholder="number" required><br>
		<input type="submit" value="submit">	
	</form>
	
	<%
	if(flag != null) { 
	%>
		<span style="color: red">*id already present in the database*</span>
	<%
	}
	%>

	<h1><a href="login">Login</a></h1>
</body>
</html>