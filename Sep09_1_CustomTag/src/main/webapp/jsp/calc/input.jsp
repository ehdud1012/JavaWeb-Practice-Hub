<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="CalcController" method="post" name="calcForm" onsubmit="return calcCheck();">
	 	<input name="x" class="calcInput" placeholder="x"> <p>
	 	<input name="y" class="calcInput" placeholder="y"> <p>
	 	<button id="calcbtn">계산</button>
	 </form>
</body>
</html>