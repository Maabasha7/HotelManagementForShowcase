<%@page import="com.jsp.hotelmanagementSystem.entities.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Admin admin=(Admin) session.getAttribute("admininfo");
	if(admin!=null) { %>
	<h1>${message}</h1><br>
		<a href="fetchunapprovedhotels">Approve Hotel</a>
		<br>
		<a href="fetchunblockedhotels">Block Hotel</a>
		<br>
		<a href="fetchblockedhotels">Unblock Hotel</a>
		<br>
		<a href="providediscount">Provide Discount</a>
		<br>
<% } else { %>
 	<a href="Adminhome.jsp"><h1> Please Login First </h1></a>
 <% } %>	
</body>
</html>