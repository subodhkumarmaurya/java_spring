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
<a href="/">Dash</a>
	<h1>${ product.name }</h1>
	<p>Description: ${ product.description }</p>
	<p>Price: ${ product.price }</p>
	
	<form action="/addcat/${ product.id }" method="post">
		<select name="cat_id" id="">
			<c:forEach items="${ cats }" var="cat">
			<c:if test="${ !product.categories.contains(cat) }">
			<option value="${ cat.id }">${ cat.name }</option>
			</c:if>
			</c:forEach>
		</select>
		<input type="submit" value="Add" />
	</form>
	
</body>

</html>