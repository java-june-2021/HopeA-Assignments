<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a New Ninja</title>
</head>
<body>
<h1>Create A New Ninja</h1>
<hr>
<form:form method="POST" action="/newninja" modelAttribute="ninja">
<p>
<form:label path="dojo">Dojo</form:label>
<form:errors path="dojo"/>
<form:select path="dojo">
<c:forEach items="${dojos}" var="dojo">
<option value="${dojo.id}">${dojo.name}</option>
</c:forEach>
</form:select>
</p>

<p>
<form:label path="firstName">First Name:</form:label>
<form:errors path="firstName"/>
<form:input path="firstName"/>
</p>
<p>
<form:label path="lastName">Last Name:</form:label>
<form:errors path="lastName"/>
<form:input path="lastName"/>
</p>
<p>
<form:label path="age">Age:</form:label>
<form:errors path="age"/>
<form:input path="age"/>
</p>



<button>Add New Ninja</button>

</form:form>

</body>
</html>