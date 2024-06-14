<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>${message}</h1>
<form action="hotelloginvalidation" method="post">
		Enter Email: <input type="email" name="email"><br><br>
		Enter Password: <input type="password" name="password"><br><br>
		<input type="submit">
	</form>
	
</body>
</html>