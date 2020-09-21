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
	<a href="/dashboard">Dashboard</a>
	<h1>Add a Song:</h1>
	<form:form action="" method="post" modelAttribute="song">
		<p>
			<form:errors path="name"/>
			<form:label path="name">Name</form:label>
			<form:input path="name"/>
		</p>
				<p>
			<form:errors path="artist"/>
			<form:label path="artist">Artist</form:label>
			<form:input path="artist"/>
		</p>
				<p>
			<form:errors path="rating"/>
			<form:label path="rating">Rating</form:label>
			<form:select path="rating">
				<option selected disabled>Choose one</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
			</form:select>
		</p>
		<input type="submit" value="Add" />
	</form:form>
</body>

</html>