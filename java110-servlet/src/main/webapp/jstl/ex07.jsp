<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
<h1>JSTL - c:foreach</h1>
<pre>
    반복문을 만든다.
</pre>
<h2>CVS(comma separated value) 문자열</h2>
<%
pageContext.setAttribute("names4", "Song,Kim,Gee");
%>
<ul>

<c:forEach items="${pageScope.names4}" var="n">
    <li>${n}</li>
</c:forEach>
</ul>


</body>
</html>












