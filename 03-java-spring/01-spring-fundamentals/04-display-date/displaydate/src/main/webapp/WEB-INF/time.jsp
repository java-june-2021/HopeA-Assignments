<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Time</title>
<link rel="stylesheet" type ="text/css" href="css/style.css">
<script type="text/javascript" src="js/app.js"></script>
</head>
<body>
<script>timeAlert()</script>
<p class="time"><fmt:formatDate pattern="h:mm a" value="${datetime}"/></p>

</body>
</html>