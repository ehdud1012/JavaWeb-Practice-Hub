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
		���� <input name="userNum" placeholder="${param.userNum}"> <p>
		<button>Ȯ��</button> <hr>
		<h1>${r}</h1>
	</form>
</body>
</html>