<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Question</title>
</head>
<body>
<h1>${quest.question}</h1>
<p>
<c:forEach items="${quest.tags}" var="tag">
${tag.subject},
</c:forEach>
</p>
<hr>
<h2>Answers</h2>
<ul>
<c:forEach items="${quest.answers}" var="answer">
<li>${answer.aText}</li>
</c:forEach>
</ul>
<hr>
<h3>Add Your Answer</h3>
<form:form method="POST" action="/addAnswer" modelAttribute="answer">
<p>
<form:label path="aText">Answer:</form:label>
<form:errors path="aText"/>
<form:input path="aText"/>
<form:hidden path="question" value="${quest.id}"/>
</p>
<button>Add Your Answer</button>
</form:form>



</body>
</html>