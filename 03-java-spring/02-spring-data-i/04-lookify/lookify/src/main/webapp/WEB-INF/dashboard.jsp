<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Songs Dashboard</title>
</head>
<body>
<div>
<a href="/newsong">Add New</a>
</div>
<div>
<a href="/Top10">Top Songs</a>
</div>
<table border = 1>
<thead>
<tr>
<td>Name</td>
<td>Rating</td>
<td>Actions<td>
</tr>
</thead>
<tbody>
<c:forEach items="${allSongs}" var="song">
<tr>
<td><a href="/show/${song.id}">${song.title}</a></td>
<td>${song.rating}</td>
<td><form method="POST" action="/delete/${song.id}">
<input type="hidden" name="_method" value="delete"/>
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
</div>
</body>
</html>