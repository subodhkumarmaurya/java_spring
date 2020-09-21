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
</head>

<body>
	<a href="/">Dashboard</a>
	<h1>${ dojo.name }</h1>
	
		<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Age</th>
			</tr>
		</thead>
		<c:forEach items="${ dojo.ninjas }" var="ninja">
			<tr>
				<td>${ ninja.name }</td>
				<td>${ ninja.age }</td>
			</tr>
		</c:forEach>
		</table>
	
	
</body>

</html>