<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src ="KDYVaildChecker_v1.0.js"></script>
<script type="text/javascript" src ="numCheck.js"></script>
</head>
<body>
	<form action="HomeController"  name="nb" onsubmit="return numCheck();">
		숫자 <input name="userNum" placeholder="${param.userNum}" maxlength="3"> <p>
		<button>확인</button> <hr>
		<h1>${r}</h1>
	</form>
</body>
</html>