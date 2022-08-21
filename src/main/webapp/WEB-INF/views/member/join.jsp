<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<h1>Join Page</h1>
	<form action="join" method="post">
		<div class="mb-3">
 				 <label for="exampleFormControlInput1" class="form-label">ID</label>
 				 <input type="text" name="user_name" class="form-control" id="exampleFormControlInput1">
		</div>
		<div class="mb-3">
 				 <label for="exampleFormControlTextarea1" class="form-label">Password</label>
 				 <input type="text" name="password" class="form-control" id="exampleFormControlInput1">
		</div>
		<div class="mb-3">
 				 <label for="exampleFormControlTextarea1" class="form-label">Name</label>
 				 <input type="text" name="name" class="form-control" id="exampleFormControlInput1">
		</div>
		<div class="mb-3">
 				 <label for="exampleFormControlTextarea1" class="form-label">Email</label>
 				 <input type="email" name="email" class="form-control" id="exampleFormControlInput1">
		</div>
		<div class="mb-3">
 				 <label for="exampleFormControlTextarea1" class="form-label">Phone</label>
 				 <input type="tel" name="phone" class="form-control" id="exampleFormControlInput1">
		</div>
		<button type="submit" class="btn btn-dark">가입하기</button>
	
	</form>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>

</body>
</html>