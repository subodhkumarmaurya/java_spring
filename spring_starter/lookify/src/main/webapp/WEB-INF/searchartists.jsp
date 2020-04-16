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
	<p>${ error }</p>
	<table>
	<c:forEach items="${ songs }" var="song">
		<tr>
			<td>${ song.rating }</td>
			<td>${ song.name }</td>
			<td>${ song.artist }</td>
		</tr>
	</c:forEach>
	</table>
</body>

</html>