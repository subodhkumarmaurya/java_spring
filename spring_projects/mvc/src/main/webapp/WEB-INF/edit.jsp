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

</body>
<h1>Edit Book</h1>
<form:form action="/books/edit/${ book.id }" method="post" modelAttribute="book">
    <p>
    	<form:errors path="title"/>
        <form:label path="title">Title</form:label>
        <form:input path="title"/>
    </p>
    <p>
        <form:errors path="description"/>
        <form:label path="description">Description</form:label>
        <form:textarea path="description"/>
    </p>
    <p>
        <form:errors path="language"/>
        <form:label path="language">Language</form:label>
        <form:input path="language"/>
    </p>
    <p>
    	<form:errors path="numberOfPages"/>
        <form:label path="numberOfPages">Pages</form:label>
        <form:input type="number" path="numberOfPages"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form>  
</html>