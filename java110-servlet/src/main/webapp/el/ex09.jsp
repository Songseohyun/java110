<%@page import="bitcamp.java110.Member"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
<h1>el - 연산자</h1>

<h2>산술 연산자</h2>
100 + 200 = ${100 + 200}<br>
100 - 200 = ${100 - 200}<br>
100 * 200 = ${100 * 200}<br>
100 / 200 = ${100 / 200}<br>
100 div 200 = ${100 div 200}<br>
100 % 200 = ${100 % 200}<br>
100 mod 200 = ${100 mod 200}<br>

<h2>논리 연산자</h2>
true && false = ${true && false}<br>
true and false = ${true and flase}<br>
true || false = ${true || false}<br>
true or false = ${true or false}<br>
!true = ${!true}<br>
not true = ${not true}<br>

<h2>관계 연산자</h2>
100 == 200 = ${100 == 200}<br>
100 eq 200 = ${100 eq 200}<br>
100 != 200 = ${100 != 200}<br>
100 ne 200 = ${100 ne 200}<br>
100 > 200 = ${100 > 200}<br>
100 gt 200 = ${100 gt 200}<br>
100 &lt 200 = ${100 < 200}<br>
100 lt 200 = ${100 lt 200}<br>
100 >= 200 = ${100 >= 200}<br>
100 ge 200 = ${100 ge 200}<br>
100 &lt= 200 = ${100 <= 200}<br>

<h2>empty 연산자</h2>
<p>보관소에 해당 객체가 비었는지 검사한다.</p>

<%
pageContext.setAttribute("name",new String("홍길동"));
%>

name 값이 비었는가 ? ${empty name}<br>
name2 값이 비었는가 ? ${empty name2}<br>

<h2>조건 연산자 - 조건 ? 식1 : 식2</h2>
name == "홍길동" : ${name == "홍길동" ? "맞다!" : "아니다!"}<br>

</body>
</html>