<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<%@ include file="style.jsp"%>
</head>
<body>

	<%@ include file="navbar.jsp"%>
	<%
	Boolean flag = (Boolean) request.getAttribute("error");
	%>

	<form action="login" method="post">
		<input type="text" name="id" value="${id}" placeholder="id" required>
		<%
		if (flag != null) {
		%>

		<span style="color: red">*not found*</span>


		<%
		}
		%>
		<input type="text" name="name" value="${name}" placeholder="name" required><br> 
		<input type="submit" value="submit">
	</form>



	<h1>
		<a href="register">Register</a>
	</h1>

</body>
</html>