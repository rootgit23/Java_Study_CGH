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
	<c:import url="../template/header.jsp"></c:import>
	<h1>this is add page</h1>
	
	<form action="./add" method="post" enctype="multipart/form-data">
		<div class="mb-3">
 				 <label for="exampleFormControlInput1" class="form-label">Name</label>
 				 <input type="text" name="book_Name" class="form-control" id="exampleFormControlInput1">
		</div>
		<div class="mb-3">
 				 <label for="exampleFormControlInput1" class="form-label">Rate</label>
 				 <input type="text" name="book_Rate" class="form-control" id="exampleFormControlInput1">
		</div>
		<div class="mb-3">
 				 <label for="exampleFormControlInput1" class="form-label">Contents</label>
 				 <input type="text" name="bookContents" class="form-control" id="exampleFormControlInput1">
		</div>
		<div class="mb-3">
 				 <label for="exampleFormControlTextarea1" class="form-label">Photo</label>
 				 <input type="file" name="photo" class="form-control" id="exampleFormControlInput1">
		</div>
		<button type="submit" class="btn btn-dark">추가</button>
	
	
	</form>
	<c:import url="../template/footer.jsp"></c:import>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>
