<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Integer hotel=(Integer) session.getAttribute("hotelinfo");
if(hotel!=null) { 
%>
<h1>${message}</h1>
	<a href="addproduct">Add Product</a>
	<br>
	<a href="viewproducts">View All Products</a>
	<br>
	<a href="">Update Product By Id</a>
	<br>
	<a href="">Delete Product By Id</a>
	<br>
	<a href="">Provide Discount</a>
	<br>
<% } else { %>
	<a href="HotelLogin.jsp">Login First</a>
<% } %>	
</body>
</html>