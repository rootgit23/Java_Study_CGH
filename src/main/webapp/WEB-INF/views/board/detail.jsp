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
	<h1>${board} Detail Page</h1>
	<table class="table table-success table-striped">
		<thead>
			<tr>
				<th>Num</th>
				<th>Title</th>
				<th>Contents</th>
				<th>Writer</th>
				<th>RegDate</th>
				<th>HIT</th>
				<th>FILENUM</th>
			</tr>
		</thead>
		<tbody>
				<tr>
					<td>${boardDTO.num}</td>
					<td>${boardDTO.title}</td>
					<td>${boardDTO.contents }</td>
					<td>${boardDTO.writer}</td>
					<td>${boardDTO.regDate}</td>
					<td>${boardDTO.hit }</td>
					<td>
					<c:forEach items="${boardDTO.boardFileDTO }" var="fileDTO">
						<p>
						<a href="../resources/upload/${board }/${fileDTO.fileName}">${fileDTO.oriName}</a>
						<p>
					</c:forEach>
					</td>
				</tr>
		</tbody>
	
	
	
	</table>
	<div class="row">
		<a href="./reply?num=${boardDTO.num }" class="btn btn-danger">Reply</a>
	</div>
	<c:if test="${member.name == boardDTO.writer }">
		<a href="./delete?num=${boardDTO.num}"> Delete </a>
		<a href="./update?num=${boardDTO.num}"> Update </a>
	</c:if>
	<c:import url="../template/footer.jsp"></c:import>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>