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
	<form method="POST" action="/checkcode">
		<c:out value="${error}"></c:out>
	    <label for="code">What is the code?</label>
	    <input type="text" name="code" id="">
	    <input type="submit" value="Submit">
	</form>
</body>

</html>