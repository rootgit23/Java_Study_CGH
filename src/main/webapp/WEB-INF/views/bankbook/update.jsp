<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>this is update page</h1>
	
	
	<form action="./update" method="post">
	
		
		<input type="text" name="book_Num" value="${update.book_Num}">
		<input type="text" name="book_Name" value="${update.book_Name}">
		<input type="text" name="book_Rate" value="${update.book_Rate}">
		<input type="submit">
	
	</form>
	
	
</body>
</html>