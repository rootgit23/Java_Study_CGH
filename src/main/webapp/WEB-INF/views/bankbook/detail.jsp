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
	<h1>this is detail page</h1>
	
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
				<tr>
					<td>${detail.book_Num}</td>
					<td>${detail.book_Name}</td>
					
					<td>${detail.book_Rate}</td>
					<td>${detail.book_Sale}</td>
					<td>${detail.bookContents }</td>
					
				</tr>
		</tbody>
	
	
	
	</table>
	
	
	<a href="./delete?book_Num=${detail.book_Num}"> Delete </a>
	<a href="./update?book_Num=${detail.book_Num}"> Update </a>
	<c:if test="${ not empty member }">
	<a href="../bankAccount/add?book_Num=${detail.book_Num }">상품가입하기</a>
	</c:if>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>