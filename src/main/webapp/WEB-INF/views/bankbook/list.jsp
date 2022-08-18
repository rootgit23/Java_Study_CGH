<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>this is list page</h1>
	
	
	<table border="1">
		<thead></thead>
		<tbody>
		
		
			
				<c:forEach items="${list}" var="ar" >
				<tr>
					<td><a href="./detail?book_Num=${ar.book_Num}">${ar.book_Num}</a></td>
					<td>${ar.book_Name}</td>
					
					<td>${ar.book_Rate}</td>
					<td>${ar.book_Sale}</td>
					
				</tr>
				</c:forEach>
			
		</tbody>
	
	
	
	</table>
<a href="./add"> Add </a>

	
	
	
	
	
	
	
</body>
</html>