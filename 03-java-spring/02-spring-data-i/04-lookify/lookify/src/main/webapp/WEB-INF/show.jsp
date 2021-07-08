<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Song Details</title>
</head>
<body>
<p>Title:<c:out value="${thisSong.title}"/></p>
<p>Artist:<c:out value="${thisSong.artist}"/></p>
<p>Rating(1-10):<c:out value="${thisSong.rating}"/></p>
<form method="POST" action="/delete/${thisSong.id}">
<input type="hidden" name="_method" value="delete">
<button>Delete</button>
</form>
</body>
</html>