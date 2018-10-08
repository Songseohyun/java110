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
<h1>JSTL - c:set</h1>
<pre>
    -c:set 보관소에 값을 저장한다.
     &lt;c:set
     var = "변수명"
     scope="page(기본)|request|session|application"
     value = "보관소에 저장할 값"/>
     
</pre>
<c:set scope="request" var="name1" value="홍길동"></c:set>
${requestScope.name1}<br>

<c:set var="name2" value="wow"></c:set>
${pageScope.name2}<br>

<c:set var="name3">유관순</c:set>
${pageScope.name3}<br>

<h2>객체의 프로퍼티 값 설정하기</h2>
<jsp:useBean id="m1" class="bitcamp.java110.Member"/>
<jsp:setProperty name="m1" property="no" value="100"/>
<c:set target="${m1}" property="email" value="hong@test.com"/>
<c:set target="${m1}" property="name" value="안녕"/>
${pageScope.m1.no}<br>
${pageScope.m1.email}<br>
${pageScope.m1.name}<br>

</body>
</html>












