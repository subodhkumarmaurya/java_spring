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
	<form action="/setresults" method="post">
	    <label for="name">Your Name:</label>
	    <input type="text" name="name" id="">
	    <label for="dojo">Dojo Location:</label>
	    <input type="text" name="dojo" id="">
	    <label for="language">Fav Lang</label>
	    <select name="language" id="">
	        <option value="python">Python</option>
	        <option value="javascript">Javascript</option>
	        <option value="java">Java</option>
	    </select>
	    <label for="comment">Comment:</label>
	    <textarea name="comment"></textarea>
	    <input type="submit" value="Submit">
	</form>
</body>

</html>