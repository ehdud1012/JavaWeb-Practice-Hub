<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Sep09_1_CustomTag</title>
<link rel="stylesheet" href="css/index_css.css">
<link rel="stylesheet" href="css/calc_css.css">
<link rel="stylesheet" href="css/mart_css.css">
<script type="text/javascript" src ="js/KDYVaildChecker_v1.0.js"></script>
<script type="text/javascript" src ="js/sep091Check.js"></script>
<%
	// 이 페이지가 웹브라우저를 통해서 화면에 나올 때
	//		=> 실행 후
	// JSP Model 2 (Dynamic project - tomcat이 관리)
	//		경로 : .jsp기준 X -> webapp폴더 기준으로 
			
	//		css/js/그림/... : webapp폴더 기준
	//		include		   : index.jsp 기준
%>
</head>
<body>
	<table id="site">
		<tr>
			<td id="sitetitle" align="center">Sep09_1_CustomTag</td>
		</tr>	
		<tr>
			<td id="sitemenuArea" align="center">
				<div id="sitemenu">
					<a href="HomeController">Home</a> |
					<a href="CalcController">사칙연산</a> |
					<a href="MartController">마트(물건값계산)</a>
				</div>
			</td>
		</tr>	
		<tr>
			<td id="sitecontent" align="center">
				<jsp:include page="${contentPage }"></jsp:include>
				<!-- 
					index.jsp가 servlet으로 바뀔때 home.jsp를 여기다 넣어라
						=> 실행 전
					include가 제대로 안되면 무한루프 : 오타 체크 / "" 체크
				 -->
			</td>
		</tr>	
	</table>
</body>
</html>