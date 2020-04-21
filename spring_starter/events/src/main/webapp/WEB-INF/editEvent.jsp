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
	<h1>Edit Event</h1>
	<p><form:errors path="event.*"></form:errors></p>
	<form:form action="/events/edit/${ event.id }" method="post" modelAttribute="event" >
<%-- 		<form:input type="hidden" path="attendees" value="${ event.attendees }"></form:input> --%>
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
		<input type="submit" value="Submit" />
	</form:form>
</body>

</html>