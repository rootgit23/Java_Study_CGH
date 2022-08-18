
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<c:if test="${ empty member}">

<a href="/member/login">Login</a>
<a href="/member/join">Join</a>
</c:if>

<c:if test="${ not empty member }">
<h3>${member.name } 님 환영합니다</h3>
<a href="./member/logout">LogOut</a>
</c:if>

<a href="/member/search">검색</a>

<a href="./bankbook/add"> Add </a>
<a href="./bankbook/detail"> Detail </a>
<a href="./bankbook/list"> List </a>



</body>
</html>
