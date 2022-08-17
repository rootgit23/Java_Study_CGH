<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Join Page</h1>
	<form action="join" method="post">
		ID를 입력 : <input type="text" name="USER_NAME">
		<div>
		비밀번호를 입력 : <input type="text" name="PASSWORD">
		</div>
		<div>
		이름을 입력 : <input type="text" name="NAME">
		</div>
		<div>
		이메일 입력 : <input type="text" name="EMAIL">
		</div>
		<div>
		전화번호 입력 : <input type="tel" name="PHONE">
		</div>
		<input type="submit" value="회원가입">
	
	</form>

</body>
</html>