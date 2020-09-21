<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
</head>

<body>
	<a href="/dashboard">Dashboard</a>
	<h1>Task: ${ task.name }</h1>
	<p>Creator: ${ task.creator.firstName } ${ task.creator.lastName }</p>
	<p>Assignee: ${ task.assignee.firstName } ${ task.assignee.lastName }</p>
	<p>Priority: 
		<c:choose>
		<c:when test="${ task.priority == 1 }">High</c:when>
		<c:when test="${ task.priority == 2 }">Medium</c:when>
		<c:when test="${ task.priority == 3 }">Low</c:when>
		</c:choose>
	</p>
	<c:if test="${ user_id == task.creator.id }">
	<a href="/tasks/edit/${ task.id }">Edit</a>
	<a href="/tasks/destroy/${ task.id }">Delete</a>
	</c:if>
	<c:if test="${ user_id == task.assignee.id }">
	<a href="/tasks/destroy/${ task.id }">Complete</a>
	</c:if>
</body>

</html>