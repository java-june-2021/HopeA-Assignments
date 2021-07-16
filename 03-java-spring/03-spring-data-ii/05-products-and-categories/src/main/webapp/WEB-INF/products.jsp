<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product</title>
</head>
<body>
<h1>${product.name}</h1>
<p>
<h3>Categories:</h3>
<c:forEach items="${product.categories}" var="cat">
<li><a href="/category/${cat.id}">${cat.name}</a></li>
</c:forEach>
<form action="/product/${product.id}" method="POST">
<select name="showCat">
<c:forEach items="${category}" var="oneCat">
<option value="${oneCat.id}">"${oneCat.name}"</option>
</c:forEach>
</select>
<button>Add</button>
</form>
</body>
</html>