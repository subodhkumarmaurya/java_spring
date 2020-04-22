<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Dashboard</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
</head>

<body>
	<h1>Welcome, <c:out value="${user.email}" /></h1>
	<a href="/logout">Logout</a>
	<br /><br />
	<table>
		<thead>
			<tr>
				<th>Task</th>
				<th>Creator</th>
				<th>Assignee</th>
				<th>Priority</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${ tasks }" var="task">
			<tr>
				<td>
				<a href="/tasks/show/${ task.id }">${ task.name }</a>
				</td>
				<td>${ task.creator.firstName } ${ task.creator.lastName }</td>
				<td>${ task.assignee.firstName } ${ task.assignee.lastName }</td>
				<c:choose>
				<c:when test="${ task.priority == 1 }"><td>High Priority</td></c:when>
				<c:when test="${ task.priority == 2 }"><td>Medium Priority</td></c:when>
				<c:when test="${ task.priority == 3 }"><td>Low Priority</td></c:when>
				</c:choose>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<br />
	<a href="/tasks/new">New Task</a>
</body>

</html>