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
	<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
</head>

<body>
	<h3>Your Gold</h3>
	<div class="totalGold">
		<c:out value="${ gold }"></c:out>
	</div>
	<div class="container">
		<div class="col">
			<h3>Farm</h3>
			<p>(earns 10-20 gold)</p>
			<form action="/setgold" method="post">
			    <input type="hidden" name="git" value="farm">
			    <input type="submit" value="Git Gold!">
			</form>
		</div>
		<div class="col">
			<h3>Cave</h3>
			<p>(earns 5-10 gold)</p>
			<form action="/setgold" method="post">
			    <input type="hidden" name="git" value="cave">
			    <input type="submit" value="Git Gold!">
			</form>
		</div>
		<div class="col">
			<h3>House</h3>
			<p>(earns 2-5 gold)</p>
			<form action="/setgold" method="post">
			    <input type="hidden" name="git" value="house">
			    <input type="submit" value="Git Gold!">
			</form>
		</div>
		<div class="col">
			<h3>Casino</h3>
			<p>(earns/takes 0-50 gold)</p>
			<form action="/setgold" method="post">
			    <input type="hidden" name="git" value="casino">
			    <input type="submit" value="Git Gold!">
			</form>
		</div>
		<form class="reset" action="/reset" method="post">
		    <input type="submit" value="Reset">
		</form>
	</div>
	<h3>Activity:</h3>
	<div class="log">
		<c:out value="${ log }" escapeXml="false"></c:out>
	</div>
</body>

</html>