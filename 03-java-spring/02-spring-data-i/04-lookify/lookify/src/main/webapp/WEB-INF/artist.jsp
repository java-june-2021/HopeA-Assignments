<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Artist Search</title>
</head>
<body>
<h1>Songs by Artist: ${artist}</h1>
<table border = 1>
<thead>
<tr>
<td>Name</td>
<td>Rating</td>
<td>Actions<td>
</tr>
</thead>
<tbody>
<c:forEach items="${thisSong}" var="song">
<tr>
<td><a href="/show/${song.id}">${song.title}</a></td>
<td>${song.rating}</td>
<td><form method="POST" action="/delete/${song.id}">
<input type="hidden" name="_method" value="delete">
<button>Delete</button>
</form></td>
</tr>
</c:forEach>
</tbody>
</table>
<div>
<form action="/artist">
<input type="text" name="artist">
<button>Search Artist</button>
</form>
<a href="/dashboard">Home</a>
</div>
</body>
</html>