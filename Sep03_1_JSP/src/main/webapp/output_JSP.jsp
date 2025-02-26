<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%  // 자바소스 넣는 자리
		int xxx = Integer.parseInt(request.getParameter("xx"));
		int yyy = Integer.parseInt(request.getParameter("yy"));
		int num = (xxx > yyy) ? xxx : yyy;
	%>
	<h1><%=num %></h1> <!-- 출력할 때 -->
</body>
</html>