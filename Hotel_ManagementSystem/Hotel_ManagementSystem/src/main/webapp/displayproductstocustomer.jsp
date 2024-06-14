<%@page import="com.jsp.hotelmanagementSystem.entities.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% List<Product> products=(List) request.getAttribute("productsList");%>
	<table cellPadding="20px" border="1">
		<th>name</th>
		<th>type</th>
		<th>cost</th>
		<th>add</th>
		
		<%
		for (Product product:products) {
		%>	
		<tr>
			<td> <%= product.getName() %> </td>
			<td> <%= product.getType() %> </td>
			<td> <%= product.getCost() %> </td>
			<td> <a href="addproducttoorder?id=<%=product.getId()%>">Add</a> </td></tr>
		<%
		}
		%>
	</table>
</body>
</html>