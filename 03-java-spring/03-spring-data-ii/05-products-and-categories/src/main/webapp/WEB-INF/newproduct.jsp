<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a New Product</title>
</head>
<body>
<h1>New Product</h1>
<form:form method="POST" action="/products/new" modelAttribute="product">
<p>
<form:label path="name">Name:</form:label>
<form:errors path="name"/>
<form:input path="name"/> 
</p>
<p>
<form:label path="description">Description:</form:label>
<form:errors path="description"/>
<form:input path="description"/> 
</p>
<p>
<form:label path="price">Price:</form:label>
<form:errors path="price"/>
<form:input path="price"/> 
</p>
<button>Add New Product</button>
</form:form>



</body>
</html>