<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<!-- 모바일 웹 개발할 때 설정 		   기기 화면에 맞추겠다 -->
<meta name="viewport" content="width=device-width,user-scalable=no,initial-scale=1.0">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index_css.css">
<link rel="stylesheet" href="css/jstlCore_css.css">
<link rel="stylesheet" href="css/weather_css.css">
</head>
<body>
	<%
		// PC 해상도 : 1920x1080
		// 폰 해상도  : pc보다 더 높음
		//		=> 모바일 웹 개발 때는 모바일 화면에 최적화시킬 필요가 있음
		//			- viewport 지정
	%>
	
	<table id="sitetitle">
		<tr>
			<td align="center">
				<a href="HomeController">Winnie The Pooh</a>
			</td>
		</tr>	
	</table>
	<table id="siteContent">
		<tr>
			<td align="center">
				<jsp:include page="${contentPage }"></jsp:include>
			</td>
		</tr>
	</table>
	<table id="sitemenuArea">
		<tr>
			<td align="center">
				<div id="sitemenu">
					<a href="JSTLCoreController">JSTL-Core	|</a>
					<a href="LottoController">Lotto		|</a>
					<a href="WeatherController">Weather		|</a>
					<a href="JSTL_fmtController">JSTL-fmt</a>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>