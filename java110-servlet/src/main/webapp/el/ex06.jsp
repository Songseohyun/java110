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
<h1>el - List객체에서 값 꺼내기</h1>
<%
java.util.ArrayList<String> nameList = new java.util.ArrayList<>();
nameList.add("wow");
nameList.add("QWEQWEQWE");
nameList.add("wqesdffsdfssdfsdfdsdfsdfsdfdsdf");
pageContext.setAttribute("names", nameList);
%>
${names[0]}<br>
${names[1]}<br>
${names[2]}<br>
${names[3]}<br>
${names[4]}<br>
<%-- 보관소가 아닌 로컬 변수는 EL에서 사용할 수 없다. --%>
</body>
</html>