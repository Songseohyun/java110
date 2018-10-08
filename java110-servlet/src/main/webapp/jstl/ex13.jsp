<%@page import="java.util.Date"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
<h1>JSTL - fmt:parseDate</h1>
<pre>
- 문자열로 지정된 날짜 값을 java.util.Date 객체로 만들기
</pre>


<%
pageContext.setAttribute("today", new Date());
%>

<fmt:formatDate value="${today}" pattern="yyyy/MM/dd HH:mm:ss" var="date"></fmt:formatDate>
<p>오늘 날짜는 '${date}' 입니다.</p>


</body>
</html>












