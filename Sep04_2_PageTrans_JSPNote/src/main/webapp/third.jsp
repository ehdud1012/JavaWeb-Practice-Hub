<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
 		int a = Integer.parseInt(request.getParameter("a"));
 		int b = Integer.parseInt(request.getParameter("b"));
 		
 		Object cc = request.getAttribute("c");
 		String ccc = (String) cc;
 		
 		double ddd = (Double) request.getAttribute("d"); 
 		
	%>
	<h1>third</h1>
	<%=a %>, <%=b %> <p>
	<%=ccc %>, <%=ddd %>
	
</body>
</html>