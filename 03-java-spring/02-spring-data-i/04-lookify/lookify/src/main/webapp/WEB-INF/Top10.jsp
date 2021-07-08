<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Top Ten</title>
</head>
<body>
<h1>Top Ten Songs:</h1>
<table border = 1>
<thead>
<tr>
<td>Rating</td>
<td>Name</td>
<td>Actions<td>
</tr>
</thead>
<tbody>
<c:forEach items="${song}" var="topSong">
<tr>
<td>${topSong.rating}</td>
<td><a href="/show/${topSong.id}">${topSong.title}</a></td>
<td><form method="POST" action="/delete/${topSong.id}">
<input type="hidden" name="_method" value="delete">
<button>Delete</button>
</form></td>
</tr>
</c:forEach>
</tbody>
</table>
<div>
<a href="/dashboard">Home</a>
</div>
</body>
</html>