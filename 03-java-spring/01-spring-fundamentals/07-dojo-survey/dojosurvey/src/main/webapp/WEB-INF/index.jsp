<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Survey Index</title>
</head>
<body>
<h1>Welcome to the Dojo Survey!</h1>
<form method="POST" action="/result">
<p>
<label>Your Name: <input type="text" name="name"></label>
</p>
<p>
<label>Dojo Location: </label>
<select name="location">
<c:forEach items="${locations}" var="location">
<option value="${location}">${location}</option>
</c:forEach>
</select>
</p>
<p>
<label>Favorite Language: </label>
<select name="favorite">
<c:forEach items="${favorites}" var="favorite">
<option value="${favorite}">${favorite}</option>
</c:forEach>
</select>
</p>
<p>
<label>Comments: </label>
<textarea name="comment"></textarea>
</p>
<button>Submit</button>
</form>

</body>
</html>