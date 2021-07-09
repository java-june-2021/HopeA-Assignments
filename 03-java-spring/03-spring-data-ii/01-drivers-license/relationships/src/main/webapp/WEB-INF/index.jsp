<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Persons and Licenses</title>
</head>
<body>
<h1>Persons and Licenses</h1>
<hr>
<a href="/persons/new">Create a New Person</a> | <a href="/licenses/create">Create a New License</a>
<hr>
<table>
<tr>
<th>ID</th>
<th>First Name</th>
<th>Last Name</th>
</tr>
<tbody>
<c:forEach items="${persons}" var="person">
<tr>
<td>${person.id}</td>
<td>${person.firstName}</td>
<td>${person.lastName}</td>
</tr>
</c:forEach>

</tbody>
</table>

</body>
</html>