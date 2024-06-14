<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="updateproductinfo" modelAttribute="existingProductInfo">
		Enter id:<form:input path="id" readonly="true"/> <br>
		Enter name:<form:input path="name"/> <br>
		Enter type:<form:input path="type"/> <br>
		Enter cost:<form:input path="cost"/> <br>
		Enter discount:<form:input path="discount"/> <br>
								<input type="submit">
	</form:form>
</body>
</html>