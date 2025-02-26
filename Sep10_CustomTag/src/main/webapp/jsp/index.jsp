<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<!-- ����� �� ������ �� ���� 		   ��� ȭ�鿡 ���߰ڴ� -->
<meta name="viewport" content="width=device-width,user-scalable=no,initial-scale=1.0">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index_css.css">
<link rel="stylesheet" href="css/jstlCore_css.css">
<link rel="stylesheet" href="css/weather_css.css">
</head>
<body>
	<%
		// PC �ػ� : 1920x1080
		// �� �ػ�  : pc���� �� ����
		//		=> ����� �� ���� ���� ����� ȭ�鿡 ����ȭ��ų �ʿ䰡 ����
		//			- viewport ����
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