<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		// JSTL
		//		core : 제어문
		//		formatting : 형식 지정
		//			-> 쓰려면 core 필요? xxxx
		
		//			3자리 마다 ,
		// 			소수점 이하 2자리까지만
		// 			날짜에 요일
	%>
	
	숫자 <p>
	<fmt:formatNumber value="${a }" type="number" /> <p>
	<fmt:formatNumber value="${b }" type="number" /> <hr>
	
	돈 단위 <p>
	<fmt:formatNumber value="${b }" type="currency" currencySymbol="||" /> <p>
	\<fmt:formatNumber value="${b }" type="number" /> <p>
	<fmt:formatNumber value="${b }" type="number" />원 <hr>
	
	백분율 <p>
	<fmt:formatNumber value="${c }" type="percent" /> <hr>
	
	소수점 <p>
	<fmt:formatNumber value="${c }" pattern="#.00" /> <hr>
	
	<%
		// pattern
		//		# : 숫자 있으면 출력, 없으면 비워두기
		//		0 : 숫자가 있든말든 그 자리는 보장
	%>
	
	날짜 / 시간 <p>
		<%
			// <fmt:formatDate value="${d }"/>
			// formatDate는 Java의 Date 객체여야 함
			// 대충 날짜스럽게 적은 String 안댐
			
			// java.sql.Date vs java.util.Date 후자가 메인임
		%>
	<fmt:formatDate value="${e }"/> <p>
	<fmt:formatDate value="${e }" type="date" dateStyle="short"/> <p>
	<fmt:formatDate value="${e }" type="date" dateStyle="long"/> <p>
	
	<fmt:formatDate value="${e }" type="time" timeStyle="short"/> <p>
	<fmt:formatDate value="${e }" type="time" timeStyle="long"/> <p>
	
	<fmt:formatDate value="${e }" type="both" dateStyle="long" timeStyle="short"/> <p> 
	<fmt:formatDate value="${e }" pattern="yyyy/MM/dd(E)" /> <hr> 
	
	<img id="jstlCimg" src="img/pooh_bee.png">
</body>
</html>