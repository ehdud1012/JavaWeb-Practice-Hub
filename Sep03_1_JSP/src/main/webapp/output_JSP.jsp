<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%  // �ڹټҽ� �ִ� �ڸ�
		int xxx = Integer.parseInt(request.getParameter("xx"));
		int yyy = Integer.parseInt(request.getParameter("yy"));
		int num = (xxx > yyy) ? xxx : yyy;
	%>
	<h1><%=num %></h1> <!-- ����� �� -->
</body>
</html>