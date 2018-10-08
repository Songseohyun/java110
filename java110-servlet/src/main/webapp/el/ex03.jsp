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
<h1>el - 보관소에서 값 꺼내기</h1>
<pre>
    -보관소의 이름을 지정하지 않으면 다음 순서로 값을 찾는다.
        pageScope -> requestScope -> sessionScope -> applicationScope
    -보관소에 지정된 값을 찾지 못하면 빈 문자열을 리턴한다.
    
</pre>
<%
session.setAttribute("name", null);
application.setAttribute("name", null);

//pageContext.setAttribute("name","홍길동");
//request.setAttribute("name", "임꺽정");
//session.setAttribute("name", "유관순");
//application.setAttribute("name", "wow");
%>

보관소에서 값 꺼내기 : ${name}<br>

</body>
</html>