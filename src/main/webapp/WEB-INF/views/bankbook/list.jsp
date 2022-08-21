<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<h1>this is list page</h1>
	<table class="table table-success table-striped">
			<thead>
				<tr>
					<th>Num</th>
					<th>Name</th>
					<th>Rate</th>
					<th>Sale</th>
					<th>Contents</th>
				</tr>
			</thead>
			<tbody>
		
		
			
				<c:forEach items="${list}" var="ar" >
				<tr>
					<td><a href="./detail?book_Num=${ar.book_Num}">${ar.book_Num}</a></td>
					<td>${ar.book_Name}</td>
					
					<td>${ar.book_Rate}</td>
					<td>${ar.book_Sale}</td>
					<td>${ar.bookContents }</td>
					
				</tr>
				</c:forEach>
			
			</tbody>
		
	
	
		</table>
		<a href="./add"> Add </a>

	
	
	
	
	
	
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>