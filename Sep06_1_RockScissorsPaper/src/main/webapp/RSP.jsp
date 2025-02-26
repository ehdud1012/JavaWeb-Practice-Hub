<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="RSP_css.css">
</head>
<body>
	<h1>가위바위보</h1>
	<h3>내고 싶은 이미지를 클릭하세요 ♪</h3>
	<a href="HomeController?userHand=1">
		<img src="RSP/1.png">
	</a>
	<a href="HomeController?userHand=2">
		<img src="RSP/2.png">
	</a>
	<a href="HomeController?userHand=3">
		<img src="RSP/3.png">
	</a>
	<hr>
	<table>
		<tr>
			<td><img src="RSP/face.png"></td>
			<td><img src="RSP/${userHand }"></td>
			<td rowspan="2" id="result">
				<h1>${r}</h1>
				<h1>${score}</h1>
			</td>
		</tr>
		<tr>
			<td><img src="RSP/computer.png"></td>
			<td><img src="RSP/${comHand}"></td>
		</tr>
	</table>
</body>
</html>