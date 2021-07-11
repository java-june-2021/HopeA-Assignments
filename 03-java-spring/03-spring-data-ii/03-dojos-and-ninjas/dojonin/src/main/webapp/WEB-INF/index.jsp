<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojos and Ninjas</title>
</head>
<body>
<h2>Dojos and Ninjas</h2>
<hr>
<a href="dojo/new">Create a Dojo</a> | <a href="/ninja/create">Create a New Ninja</a>
<hr>
<table>
<tr>
<th>ID</th>
<th>Name</th>

</tr>
<tbody>
<c:forEach items="${dojos}" var="dojo">
<tr>
<td>${dojo.id}</td>
<td>${dojo.name}</td>

</tr>
</c:forEach>

</tbody>
</table>
</body>
</html>