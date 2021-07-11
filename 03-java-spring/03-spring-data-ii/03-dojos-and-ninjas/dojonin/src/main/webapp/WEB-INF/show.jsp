<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Info</title>
</head>
<body>
<h1>${dojo.name} Location Ninjas</h1>
<hr>
<table>
<tr>
<th>First Name</th>
<th>Last Name</th>
<th>Age</th>

</tr>
<tbody>
<c:forEach items="${ninjas}" var="ninja">
<tr>
<td>${ninja.firstName}</td>
<td>${ninja.lastName}</td>
<td>${ninja.age}</td>

</tr>
</c:forEach>

</tbody>
</table>

</body>
</html>