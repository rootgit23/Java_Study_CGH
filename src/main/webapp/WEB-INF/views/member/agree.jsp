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
        1번 항목<input type="checkbox" class="cb req">
        2번 항목<input type="checkbox" class="cb req">
        3번 항목<input type="checkbox" class="cb">
        4번 항목<input type="checkbox" class="cb">
    </div>
    <form action="join" method="get" id="frm">
        <button type="button" id="join">확인</button>
    </form>
    <script src="/resources/js/member.js"></script>
    <script>
        check();
    </script>
</body>
</html>