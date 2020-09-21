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
	<a href="/dashboard">Dashboard</a>
	<h1>${ song.name }</h1>
	<p>Artist: ${ song.artist }</p>
	<p>Rating: ${ song.rating }</p>
	<a href="">Edit</a>
	<a href="">Delete</a>
</body>

</html>