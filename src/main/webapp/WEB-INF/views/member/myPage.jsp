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
	<h1>myPage</h1>
	<table class="table table-success table-striped">
		<thead>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>EMAIL</th>
				<th>PHONE</th>
			</tr>
		</thead>
		<tbody>
			
				<tr>
					<td>${dto.user_name }</td>
					<td>${dto.name}</td>
					<td>${dto.email }</td>
					<td>${dto.phone }</td>
				</tr>
			
	
	<!-- <table class="table table-success table-striped">
		<thead>
			<tr>
				<th>ACCOUNTNUM</th>
				<th>BOOKNAME</th>
				<th>DATE</th>
			</tr>
		</thead>
		<tbody>
			
			<c:forEach items="${map.list }" var="dto">
				<tr>
					<td>${dto.accountNum }</td>
					<td>${dto.bankBookDTO.book_Name }</td>
					<td>${dto.accountDate }</td>
				</tr>
			
			</c:forEach>
			-->
			<table class="table table-success table-striped">
				<thead>
					<tr>
						<th>ACCOUNTNUM</th>
						<th>BOOKNAME</th>
						<th>DATE</th>
					</tr>
				</thead>
				<tbody>
			
					<c:forEach items="${dto.bankAccountDTO }" var="dto">
						<tr>
							<td>${dto.accountNum }</td>
							<td>${dto.bankBookDTO.book_Name }</td>
							<td>${dto.accountDate }</td>
						</tr>
			
					</c:forEach>
		</tbody>
	</table>
	<c:import url="../template/footer.jsp"></c:import>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
	
	
	
	
</body>
</html>