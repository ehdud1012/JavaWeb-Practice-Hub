<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="MartController" name="martForm" method="post" onsubmit="return martCheck();">
	 	구매 <textarea class="martTA" name="martInput" rows="" cols=""></textarea> <p>
	 	<button id="calcbtn">계산</button>
	 </form>
</body>
</html>