<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
<h1>JSTL - c:import</h1>
<pre>
- HTTP 요청을 수행하는 코드를 만든다.
</pre>
<h2>네이버 검색 요청하기</h2>
<pre>
https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%ED%99%8D%EC%A7%84%EC%98%81
</pre>

<c:url value="http://localhost:8888/jstl/ex05.jsp" var="url1">
    <c:param name="name" value="홍길동"></c:param>
    <c:param name="age" value="20"></c:param>
    <c:param name="gender" value="man"></c:param>
</c:url>

<%--지정된 URL을 요청하고 서버로부터 받은 콘텐트를 contents라는 이름으로 PageContext 보관소에 저장한다. --%>

<c:import url="${url1}" var="contents"/>

<textarea cols="120" rows="20">${contents}</textarea>

</body>
</html>












