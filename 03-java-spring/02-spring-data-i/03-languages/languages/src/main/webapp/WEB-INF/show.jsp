<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details</title>
</head>
<body>
<a href="/">Dashboard</a>

<p><c:out value="${thisLang.name}"/></p>
<p><c:out value="${thisLang.creator}"/></p>
<p><c:out value="${thisLang.currentVersion}"/></p>

<p><a href="/edit/${thisLang.id}">Edit</a>  | 
<form method="POST" action="/delete/${thisLang.id}">
<input type="hidden" name="_method" value="delete">
<button>Delete</button>
</form>

</body>
</html>