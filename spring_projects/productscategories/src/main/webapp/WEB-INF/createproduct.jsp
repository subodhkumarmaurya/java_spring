<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
</head>

<body>
	<h1>New Product</h1>
	<form:form action="/products/new" method="post" modelAttribute="product">
	    <p>
	    	<form:errors path="name"/>
	        <form:label path="name">Name</form:label>
	        <form:input path="name"/>
	    </p>
	    <p>
	    	<form:errors path="description"/>
	        <form:label path="description">Description</form:label>
	        <form:input path="description"/>
	    </p>
	    <p>
	    	<form:errors path="price"/>
	        <form:label path="price">Price</form:label>
	        <form:input type="float" path="price"/>
	    </p>
	    <input type="submit" value="Submit"/>
	</form:form>
</body>

</html>