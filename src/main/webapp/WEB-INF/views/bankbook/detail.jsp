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

	<div class="row">
		<div class="mb-3">
			<label for="exampleFormControlInput1" class="form-label">UserName</label>
			<input type="text" class="form-control" id="writer">
		</div>
		<div class="mb-3">
			<label for="exampleFormControlTextarea1" class="form-label">WriteContents</label>
			<textarea class="form-control" id="contents" rows="3"></textarea>
		</div>
		<div class="mb-3">
			<button type="button" class="form-control" id="button" data-bookNum="${detail.book_Num}">클릭</button>
		</div>

	</div>

	<div>
		<table id="commentList">

		</table>
	</div>
	<button id="more">더보기</button>
	
	<div>
		<!-- Button trigger modal -->
		<button type="button" id= "up" style="display:none" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
			Launch demo modal
  		</button>
  
  		<!-- Modal -->
  		<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
	  			<div class="modal-content">
					<div class="modal-header">
		  				<h5 class="modal-title" id="exampleModalLabel">댓글 수정</h5>
		  				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					</div>
					<div class="modal-body">
		  
					</div>
					<div class="modal-footer">
		 			 <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
		  			 <button type="button" class="btn btn-primary">수정</button>
					</div>
	  			</div>
			</div>
  		</div>
	</div>




	<a href="./delete?book_Num=${detail.book_Num}"> Delete </a>
	<a href="./update?book_Num=${detail.book_Num}"> Update </a>
	<c:if test="${ not empty member }">
		<a href="../bankAccount/add?book_Num=${detail.book_Num }">상품가입하기</a>
	</c:if>
	<c:import url="../template/footer.jsp"></c:import>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
	<script src="/resources/js/bankBookComment.js"></script>
</body>
</html>