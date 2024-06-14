<%@page import="com.jsp.hotelmanagementSystem.entities.Hotel"%>
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
<% List<Hotel> hotels=(List<Hotel>) request.getAttribute("unapprovedhotels"); %>
<table cellPadding="20px" border="1">
	<th>Id</th>
	<th>Name</th>
	<th>Email</th>
	<th>Address</th>
	<th>MobileNumber</th>
	<th>Approve</th>
	<th>Status</th>
<%for(Hotel h:hotels){ %>
  <tr>
  	<td><%=h.getId() %></td>
  	<td><%=h.getName() %></td>
  	<td><%=h.getEmail() %></td>
  	<td><%=h.getAddress() %></td>
  	<td><%=h.getMobilenumber() %></td>
  	<td><%= h.getStatus() %></td>
  	<td><a href="approvehotel?id=<%= h.getId() %>">approve</a></td>
  </tr>
<% } %>
</table>
<a href="Adminoptions.jsp">Back to menu</a><br>       <a href="adminlogout">LogOut</a>
</body>
</html>