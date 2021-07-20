<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Questions Dashboard</title>
</head>
<body>
<h1>Questions Dashboard</h1>
<hr>
<table>
<tr>
<th>Questions</th>
<th>Tags</th>
</tr>
<c:forEach items="${allquest}" var="q">
<tr>
<td><a href="/show/${q.id}">${q.question}</a></td>
<td>
<p>
<c:forEach items="${q.tags}" var="taginfo">
${taginfo.subject},
</c:forEach>
</p>
</td>
</tr>

</c:forEach>





</table>

</body>
</html>