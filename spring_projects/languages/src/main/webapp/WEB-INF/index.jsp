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
	<table>
	    <thead>
	        <tr>
	            <th>Name</th>
	            <th>Creator</th>
	            <th>Version</th>
	            <th>Action</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${languages}" var="language">
	        <tr>
	            <td>${language.name}</td>
	            <td>${language.creator}</td>
	            <td>${language.currentVersion}</td>
	            <td>
	                <a href="/languages/${ language.id }">Go</a>
	                <a href="/languages/delete/${ language.id }">Delete</a>
	            </td>
	        </tr>
	        </c:forEach>
	    </tbody>
	</table>
	<form:form action="/languages" method="post" modelAttribute="language">
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