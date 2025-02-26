<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>이름</td>
			<td>가격</td>
		</tr>
		<c:forEach var="s" items="${s}">
			<tr class="comments">
				<td >${s.name }</td>
				<td>${s.price }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>