<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Dashboard</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
</head>

<body>
	<h1>Welcome, <c:out value="${user.email}" /></h1>
	<a href="/logout">Logout</a>
	
	<br/>
	<br/>
	
	<h3>Events in your city:</h3>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Date</th>
				<th>Location</th>
				<th>Host</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ events }" var="event">
			<c:if test="${ event.location == user.location }">
			<tr>
				<td>
				<a href="/events/show/${ event.id }">${ event.name }</a>
				</td>
				<td>${ event.date }</td>
				<td>${ event.location }</td>
				<td>${ event.host.firstName } ${ event.host.lastName }</td>
				<td>
				<c:if test="${ event.host.id != user_id }">
					<c:choose>
						<c:when test="${ event.attendees.contains(user) }">
					<a href="/events/leave/${ event.id }">Leave</a>
						</c:when>
						<c:otherwise>
					<a href="/events/join/${ event.id }">Join</a>
						</c:otherwise>
					</c:choose>
				</c:if>
				<c:if test="${ event.host.id == user_id }">
					<a href="/events/edit/${ event.id }">Edit</a>
					<a href="/events/destroy/${ event.id }">Cancel</a>
				</c:if>
				</td>
			</tr>
			</c:if>
			</c:forEach>
		</tbody>
	</table>
	
	<h3>Events in other cities:</h3>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Date</th>
				<th>Location</th>
				<th>Host</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ events }" var="event">
			<c:if test="${ event.location != user.location }">
			<tr>
				<td>
				<a href="/events/show/${ event.id }">${ event.name }</a>
				</td>
				<td>${ event.date }</td>
				<td>${ event.location }</td>
				<td>${ event.host.firstName } ${ event.host.lastName }</td>
				<td>
				<c:if test="${ event.host.id != user_id }">
					<c:choose>
						<c:when test="${ event.attendees.contains(user) }">
					<a href="/events/leave/${ event.id }">Leave</a>
						</c:when>
						<c:otherwise>
					<a href="/events/join/${ event.id }">Join</a>
						</c:otherwise>
					</c:choose>
				</c:if>
				<c:if test="${ event.host.id == user_id }">
					<a href="/events/edit/${ event.id }">Edit</a>
					<a href="/events/destroy/${ event.id }">Cancel</a>
				</c:if>
				</td>
			</tr>
			</c:if>
			</c:forEach>
		</tbody>
	</table>
	
	<h2>Create an Event</h2>
	<p>${ error }</p>
	<p><form:errors path="event.*"></form:errors></p>
	<form:form action="/events/new" method="post" modelAttribute="event" >
		<p>
			<form:label path="name">Name</form:label>
			<form:input path="name"/>
		</p>
		<p>
			<form:label path="date">Date</form:label>
			<form:input type="date" path="date"/>
		</p>
		<p>
			<form:label path="location">Location</form:label>
			<form:input path="location"/>
		</p>
		<input type="submit" value="Add Event" />
	</form:form>
</body>

</html>