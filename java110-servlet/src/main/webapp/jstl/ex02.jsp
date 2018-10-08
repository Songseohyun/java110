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
<h1>JSTL - c:out</h1>
<pre>
    -c:out 출력문을 만드는 태그이다.
        &lt;c:out value="출력될 내용 or 값" default="기본값"/>
        &lt;c:out value="출력될 값>기본값&lt;c:out>
</pre>
<%
pageContext.setAttribute("name","홍길동");
%>
<c:out value="임꺽정"></c:out><br>
<c:out value="${name}"></c:out><br>
<c:out value="${null}" default="기본값"></c:out><br>
<c:out value="${'wow'}" default="기본값"></c:out><br>
</body>
</html>












