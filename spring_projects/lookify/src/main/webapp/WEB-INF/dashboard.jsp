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
	<a href="/songs/new">Add New</a>
	<a href="/songs/topten">Top Songs</a>
	<form action="/search" method="post">
		<input type="text" name="search" id="" />
		<input type="submit" value="Search Artists" />
	</form>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Artist</th>
				<th>Rating</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ songs }" var="song">
				<tr>
					<td>
					<a href="/songs/${ song.id }">${ song.name }</a>
					</td>
					<td>${ song.artist }</td>
					<td>${ song.rating }</td>
					<td>
						<a href="">Edit</a>
						<a href="">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>

</html>