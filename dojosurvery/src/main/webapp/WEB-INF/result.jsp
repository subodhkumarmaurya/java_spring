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
	<h2>Submitted Info:</h2>
	<p>Name: <c:out value="${ name }"></c:out></p>
	<p>Dojo: <c:out value="${ dojo }"></c:out></p>
	<p>Fav Lang: <c:out value="${ language }"></c:out></p>
	<p>Comment: <c:out value="${ comment }"></c:out></p>
</body>

</html>