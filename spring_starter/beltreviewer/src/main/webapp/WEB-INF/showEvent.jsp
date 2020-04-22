<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
	<div class="container">
		<div>
			<h1>${ event.name }</h1>
			<p>Host: ${ event.host.firstName }</p>
			<p>Date: ${ event.date }</p>
			<p>Location: ${ event.location }</p>
			<h3>Attending:</h3>
			<table class="table">
				<thead>
					<tr>
						<th>Name:</th>
						<th>Location:</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ event.attendees }" var="attendee">
					<tr>
						<td>${ attendee.firstName }</td>
						<td>${ attendee.location }</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div>
			<h1>Message Board:</h1>
			<div class="messageBoard">
			<c:forEach items="${ comments }" var="comment">
				<c:if test="${ comment.event.id == event.id }">
				<p>
					<span>${ comment.user.firstName } ${ comment.user.lastName }:</span>
					<span>${ comment.content }</span>
				</p>
				<p>----------</p>
				</c:if>
			</c:forEach>
			</div>
			<p><form:errors path="comment.*"></form:errors></p>
			<form:form action="/comments/new/${ event.id }" method="post" modelAttribute="comment">
				<p>
					<form:label path="content">Add Comment:</form:label>
				</p>
				<p>
					<form:textarea path="content" id="" cols="30" rows="10"></form:textarea>
				</p>
				<input type="submit" value="Submit" />
			</form:form>
		</div>
	</div>

</body>

</html>