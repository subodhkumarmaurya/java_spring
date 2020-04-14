<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="css/style.css">
<script src="js/time.js"></script>
</head>

<body>
	<h2 class="time">
		<fmt:formatDate type="time" timeStyle="short" value="${time}"/>
	</h2>
</body>

</html>