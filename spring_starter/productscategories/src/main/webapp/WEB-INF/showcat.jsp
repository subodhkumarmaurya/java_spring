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
	<h1>${ cat.name }</h1>
		<form action="/addproduct/${ cat.id }" method="post">
		<select name="product_id" id="">
			<c:forEach items="${ products }" var="product">
			<c:if test="${ !cat.products.contains(product) }">
			<option value="${ product.id }">${ product.name }</option>
			</c:if>
			</c:forEach>
		</select>
		<input type="submit" value="Add" />
	</form>
</body>

</html>