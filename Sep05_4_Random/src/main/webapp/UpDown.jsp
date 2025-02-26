<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="HomeController">
		숫자 <input name="userNum" placeholder="${param.userNum}"> <p>
		<button>확인</button> <hr>
		<h1>${r}</h1>
	</form>
</body>
</html>