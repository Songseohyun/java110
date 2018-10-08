<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"
    isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 액션 태그</title>
</head>
<body>
<h1>jsp:forward - RequestDispatcher.forward() 15에서 Error 발생!</h1>
<pre>
    - 다른 서블릿(또는 JSP)으로 실행을 위임한다.
    &lt;jsp:forward page="서블릿 또는 JSP URL"
</pre>
<p>연산자 '<%=request.getParameter("op") %>'를 지원하지 않습니다.!</p>

</body>
</html>


