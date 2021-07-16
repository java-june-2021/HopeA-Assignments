<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products and Categories</title>
</head>
<body>
<h1>Products and Categories</h1>
<a href="/products/new">Add a New Product</a> | <a href="/category/new">Add a New Category</a>
<hr>
<table>
<tr>
<th>id</th>
<th>Name</th>
<th>Description</th>
<th>Price</th>
</tr>
<tbody>
<c:forEach items="${products}" var="product">
<tr>
<td>${product.id}</td>
<td><a href="/product/${product.id}">${product.name}</a></td>
<td>${product.description}</td>
<td>${product.price}</td>
</tr>
</c:forEach>
</tbody>
</table>

</body>
</html>