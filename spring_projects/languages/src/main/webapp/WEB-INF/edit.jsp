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
	<form:form action="/languages/edit/${ language.id }" method="post" modelAttribute="language">
	    <p>
	        <form:errors path="name"/>
	        <form:label path="name">Name</form:label>
	        <form:input path="name"/>
	    </p>
	    <p>
	        <form:errors path="creator"/>
	        <form:label path="creator">Creator</form:label>
	        <form:input path="creator"/>
	    </p>
	    <p>
	        <form:errors path="currentVersion"/>
	        <form:label path="currentVersion">Version</form:label>
	        <form:input path="currentVersion"/>
	    </p>
	    <input type="submit" value="Submit"/>
	</form:form>  
</body>

</html>