<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<% // �ڵ��ϼ� ������ ������ �ڹ��ڵ带 �� �Ⱦ��� ����
		int sum = (Integer) request.getAttribute("sum");
	%>
	<h1><%=sum %></h1>
</body>
</html>