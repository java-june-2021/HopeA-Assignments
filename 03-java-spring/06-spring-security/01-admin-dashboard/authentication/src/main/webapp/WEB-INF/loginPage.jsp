<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<h1>Login</h1>
	<p><c:out value="${error}"/></p>
	<form method="POST" action="/login">
		<p>
			<label >Email</label>
			<input type="email" id="email" name="email"/>
		</p>
		<p>
			<label>Password</label>
			<input type="password" id="password" name="password"/>
		</p>
		<input type="submit" value="login!"/>
	</form>

</body>
</html>