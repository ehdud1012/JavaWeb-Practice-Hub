<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<% // 자동완성 불편한 이유가 자바코드를 잘 안쓰기 때문
		int sum = (Integer) request.getAttribute("sum");
	%>
	<h1><%=sum %></h1>
</body>
</html>