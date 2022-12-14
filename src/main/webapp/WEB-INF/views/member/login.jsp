<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bank</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
  </head>
  <body>
	<c:import url="../template/header.jsp"></c:import>
		<div class="row">
			<form action="login" id="frm" method="post">
				<div class="mb-3">
 				 <label for="exampleFormControlInput1" class="form-label">ID</label>
 				 <input type="text" name="user_name" class="form-control" id="id">
				</div>
				<div class="mb-3">
 				 <label for="exampleFormControlTextarea1" class="form-label">Password</label>
 				 <input type="text" name="password" class="form-control" id="pw">
				 <label id="error"></label>
				</div>
				<button type="button" id="btn" class="btn btn-dark">로그인</button>
			</form>
		</div>
	<c:import url="../template/footer.jsp"></c:import>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
	<script src="/resources/js/member.js"></script>
	<script>logincheck();</script>
  </body>
</html>