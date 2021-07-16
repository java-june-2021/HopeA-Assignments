<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category</title>
</head>
<body>
<h1>${category.name}</h1>
<p>
<h3>Products:</h3>
<c:forEach items="${category.products}" var="pro">
<ul>
<li>${pro.name}</li>
</ul>
</c:forEach>
<form action="/category/${category.id}" method="POST">
<select name="showPro">
<c:forEach items="${product}" var="onePro">
<option value="${onePro.id}">${onePro.name}</option>
</c:forEach>
</select>
<button>Add</button>
</form>

</body>
</html>