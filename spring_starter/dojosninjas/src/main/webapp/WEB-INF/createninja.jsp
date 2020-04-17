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
	<a href="/">Dashboard</a>
	<h1>Create a Ninj:</h1>
	<form:form action="/ninjas/new" method="post" modelAttribute="ninja">
		<form:select path="dojo">
		<c:forEach items="${ dojos }" var="dojo">
		<option value="${ dojo.id }">${ dojo.name }</option>
		</c:forEach>
		</form:select>
	    <p>
	    	<form:errors path="name"/>
	        <form:label path="name">Name</form:label>
	        <form:input path="name"/>
	    </p>
	    <p>
	    	<form:errors path="age"/>
	        <form:label path="age">Age</form:label>
	        <form:input type="number" path="age"/>
	    </p>
	    <input type="submit" value="Submit"/>
	</form:form>
</body>

</html>