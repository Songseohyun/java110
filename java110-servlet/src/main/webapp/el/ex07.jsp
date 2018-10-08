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
<h1>el - Map객체에서 값 꺼내기</h1>
<%
java.util.Map<String,Object> map = new java.util.HashMap<>();
map.put("s01","김구");
map.put("s02","안중근");
map.put("s03","유관순");

pageContext.setAttribute("map", map);
%>
${map["s01"]}<br>
${map["s02"]}<br>
${map["s03"]}<br>
${map.s01}<br>
</body>
</html>