<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>Insert title here</title>
</head>
<body>
	<h1 id="lotto">WEATHER</h1>
	<c:forEach var="www" items="${weathers }">
		<table id="weatherTable">
			<tr>					
				<td rowspan="3">
					<img src="${www.img }">
				</td>
				<td>${www.hour }시까지</td>
			</tr>
			<tr>
				<td>${www.wfKor}</td>
			</tr>
			<tr>
				<td>${www.temp}℃</td>
			</tr>
		</table>
		<c:if test="${w.hour == 24 }">
			<hr>
		</c:if>
	</c:forEach>
</body>
</html>