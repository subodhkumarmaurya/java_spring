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
	<a href="/products/new">Add Product</a>
	<a href="/cats/new">Add Category</a>
	<h1>Products</h1>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Desc</th>
				<th>Price</th>
				<th>Cats</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ products }" var="product">
			<tr>
				<td>
				<a href="/products/${ product.id }">${ product.name }</a></td>
				<td>${ product.description }</td>
				<td>${ product.price }</td>
				
				<td>
				<c:forEach items="${ product.categories }" var="cat">
				<span>${ cat.name }</span>
				</c:forEach>
				</td>
				
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<h1>Cats</h1>
	<table>
		<thead>
			<tr>
				<th>Name</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ cats }" var="cat">
			<tr>
				<td>
				<a href="/cats/${ cat.id }">${ cat.name }</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>

</html>