<%@page import="com.jsp.hotelmanagementSystem.entities.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% List<Product> products=(List<Product>) request.getAttribute("products"); %>
<table cellPadding="20px" border="1">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>type</th>
        <th>cost</th>
        <th>discount</th>
        <th>update</th>
        <th>delete</th>
    </tr>
    
    <% for(Product p:products){ %>
    <tr>
        <td><%=p.getId()%></td>
        <td><%=p.getName()%></td>
        <td><%=p.getType()%></td>
        <td><%=p.getCost()%></td>
        <td><%=p.getDiscount()%></td>
        <td><a href="updateproduct?id=<%=p.getId()%>">update</a></td>
        <td><a href="delete?id=<%=p.getId()%>">delete</a></td>
    </tr>
    <% } %>
</table>
<a href="HotelHomepage.jsp">Back to Options</a>     <br>   <a href="hotellogout">Logout</a>
</body>
</html>
