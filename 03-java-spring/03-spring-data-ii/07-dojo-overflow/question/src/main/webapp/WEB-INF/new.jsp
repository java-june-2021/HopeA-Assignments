<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Question</title>
</head>
<body>
<h1>What is your Question?</h1>
<form:form method="POST" action="/newQuest" modelAttribute="quest">
<p>
<form:label path="question">Question</form:label>
<form:errors path="question"/>
<form:textarea path="question"/>
</p>
<p>
<form:label path="frontTags">Tags(Please separate by comma)</form:label>
<form:errors path="frontTags"/>
<form:input path="frontTags"/>
</p>
<button>Submit Your Question</button>



</form:form>

</body>
</html>