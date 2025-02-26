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
	<form action="LottoController">
		<h1 id="lotto">LOTTO</h1>
		<c:forEach var="l" items="${lotto }">
			<img src="img/lotto/ball_${l }.png">
		</c:forEach>
	</form>
	
	<img id="jstlCimg" src="img/pooh_balloon.png">
</body>
</html>