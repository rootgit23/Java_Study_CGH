<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    모두 동의<input type="checkbox" id="all">
    <div>
        1번 항목<input type="checkbox" class="check">
        2번 항목<input type="checkbox" class="check">
        3번 항목<input type="checkbox" class="check">
        4번 항목<input type="checkbox" class="check">
    </div>
    <form action="join" method="get" id="joinfrm">
        <button type="button" id="btn1">확인</button>
    </form>
    <script src="/resources/js/member.js"></script>
</body>
</html>