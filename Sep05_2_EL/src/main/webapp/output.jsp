<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="Sep04_1_CSS.css">
</head>
<body>
	<table>
		<tr>
			<th colspan="2" align="center">결과</th>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<img src="Sep05_2_photo/${result.path}">
			</td>
		</tr>
		<tr>
			<td class="oo">이름</td> <td>${result.name}</td>
		</tr>
		<tr>
			<td class="oo">키</td> <td>${result.h * 100}cm</td>
		</tr>
		<tr>
			<td class="oo">몸무게</td> <td>${result.w}kg</td>
		</tr>
		<tr>
			<td class="oo">bmi</td> <td>${result.bmi}</td>
		</tr>
		<tr>
			<td colspan="2" align="center" id="result">${result.result}</td>
		</tr>
	</table>
</body>
</html>