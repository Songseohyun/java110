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
<h1>JSTL - c:remove</h1>
<pre>
-보관소에 저장된 값을 제거한다.
</pre>
<%
pageContext.setAttribute("name1", "pageContext");
request.setAttribute("name2", "request");
session.setAttribute("name3", "session");
application.setAttribute("name4", "application");
%>
${pageScope.name1}<br>
${name2}<br>
${name3}<br>
${name4}<br>
<c:remove var="name1" scope="page"/>

${name1}<br>
${name2}<br>
${name3}<br>
${name4}<br>

<c:remove var="name2"/>
${name1}<br>
${name2}<br>
${name3}<br>
${name4}<br>

</body>
</html>












