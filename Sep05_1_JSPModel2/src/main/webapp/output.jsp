<%@page import="com.kdy.sep051jm.main.UCResult"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="unitChangeCSS.css">
</head>
<body>
	<%
		UCResult ucr = (UCResult) request.getAttribute("result");
	%>
	<table id=<%=ucr.getUnit() %>>
		<tr>
			<th align="center" colspan="2">변환 결과</th>
		</tr>
		<tr>
			<td align="center">
				<%=ucr.getNum() %> <%=ucr.getUnit1() %>
			</td>
		</tr>
		<tr>
			<td align="center" colspan="2">
				↓
			</td>
		</tr>
		<tr>
			<td align="center">
				<%=ucr.getResult()%> <%=ucr.getUnit2() %>
			</td>
		</tr>
	</table>
</body>
</html>