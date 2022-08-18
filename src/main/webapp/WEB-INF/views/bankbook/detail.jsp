<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>this is detail page</h1>
	
	<table border="1">
		<thead></thead>
		<tbody>
				<tr>
					<td>${detail.book_Num}</td>
					<td>${detail.book_Name}</td>
					
					<td>${detail.book_Rate}</td>
					<td>${detail.book_Sale}</td>
					
				</tr>
		</tbody>
	
	
	
	</table>
	
	
	<a href="./delete?book_Num=${detail.book_Num}"> Delete </a>
	<a href="./update?book_Num=${detail.book_Num}"> Update </a>
</body>
</html>