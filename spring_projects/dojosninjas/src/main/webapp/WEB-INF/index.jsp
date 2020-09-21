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
	<a href="/dojos/new">Add Doj</a>
	<a href="/ninjas/new">Add Ninj</a>
	<table>
	    <thead>
	        <tr>
	            <th>Dojo</th>
	            <th>Total Ninjas</th>
	        </tr>
        </thead>
        <tbody>
            	<c:forEach items="${dojos}" var="dojo">
            <tr>
            		<c:set var="c" value="${ 0 }"></c:set>
                <td>
                <a href="/dojo/${ dojo.id }">${dojo.name}</a>
                </td>
<%-- 					<c:forEach items="${ ninjas }" var="ninja">
	                <c:if test="${ ninja.dojo.name == dojo.name }">
	                <c:set var="c" value="${ c + 1 }"></c:set>
	                </c:if> 
					</c:forEach> --%>
				<td>${ dojo.ninjas.size() }</td>
            </tr>
            	</c:forEach>
        </tbody>
	</table>
</body>

</html>