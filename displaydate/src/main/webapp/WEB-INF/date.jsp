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
<script src="js/date.js"></script>
</head>

<body>
	<h2 class="date">
		<fmt:formatDate pattern="EEEE, 'the' dd 'of' MMMM, yyyy" value="${date}"/>
	</h2>
</body>

</html>