<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" %>
    
<!-- 사제품 커스텀태그를 사용하기 위해 추가해야할 것 | prefix : 접두어 설정 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		// .jsp에서 Java를 없애자
		// JSP Mobel 2구조를 쓰는데 java를 쓸일
		//		- 값 받기 : EL
		//		- include : JSP 표준액션태그
		//		- 기본 제어문 (if, for, switch)
		
		// CustomTag : <접두어:xxx>
		//		JSP 표준액션태그 : .jsp에서 그냥 되는거 <jsp: xxx>
		//		커스텀태그 : .jar 파일 넣고 쓰는거
		//			- JSTL (Jsp Standard Tag Library)
		//				정품은 아닌데 정품처럼 만들어놨음 / maven -> .jar 파일 / <맘대로: xxx>
		//				- core : 프로그래밍 언어 제어문 | EL을 조건식으로
		//				- formatting, function, ...
	%>
	<!-- JSTL core -->
	<!-- if문 -->
		<c:if test="${result > 3}"> <!-- EL을 조건식으로 -->
			3보다 큼
		</c:if> <hr>
		
	<!-- switch문 느낌? -->
		<c:choose>
			<c:when test="${result > 7}"> 7보다 큼</c:when>
			<c:when test="${result > 5}"> 5보다 큼</c:when>
			<c:when test="${result > 3}"> 3보다 큼</c:when>
			<c:otherwise>나머지</c:otherwise>
		</c:choose> <hr>

	<!-- for문 								  step은 음수 불가	-->
		<c:forEach var="i" begin="0" end="10" step="2">
			${i }
		</c:forEach> <hr>
		
	<!-- 구구단 -->
		<table>
			<tr>
				<th>${result }단</th>
			</tr>
			<c:forEach var="g" items="${gugu }">
				<tr>
					<td>${g }</td>
				</tr>
			</c:forEach>
		</table> <hr>
		
	<!-- snack 객체 -->
		<c:forEach var="s" items="${snacks }">
			<h4>${s.name } : ${s.price }</h4>
		</c:forEach> <hr>
		
		
		
	<img id="jstlCimg" src="img/pooh_bf2.png">
</body>
</html>