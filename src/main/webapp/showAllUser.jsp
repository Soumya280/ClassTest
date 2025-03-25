<%@page import="java.util.List"%>
<%@page import="com.jsp.Servlets.DBElements"%>
<%@page import="com.jsp.Servlets.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show All User</title>
<%@ include file="style.jsp" %>
</head>

<body>
		<%@ include file="navbar.jsp" %>
	
	<%
	List<DBElements> list = (List<DBElements>) request.getAttribute("list");
	%>
	
	<table>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>NUMBER</th>
			<th>ACTION</th>
		</tr>

		<%
		for (int i = 0; i < list.size(); i++) {
			DBElements elements = list.get(i);
		%>

		<tr>
			<td><%=elements.getId()%></td>
			<td><%=elements.getName()%></td>
			<td><%=elements.getNumber()%></td>
			<td>
				<form action="delete" method="post">

					<input type="hidden" name="id" value="<%=elements.getId()%>"> <input
						type="submit" value="DELETE">

				</form> <%-- <a href="update?id=<%=s.getId()%>" >UPDATE</a> --%>

				<form action="update" method="get">

					<input type="hidden" value="<%=elements.getId()%>" name="id"> <input
						type="submit" value="UPDATE">
				</form>


			</td>
		</tr>
		
		

		<%
		}
		%>

	</table>
	<h1><a href="home.jsp">Home</a>|<a href="register">Add new User</a></h1>
</body>
</html>