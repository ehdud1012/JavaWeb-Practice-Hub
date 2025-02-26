<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src ="KDYVaildChecker_v1.0.js"></script>
<script type="text/javascript" src ="ch.js"></script>
</head>
<body>
	<form action="ProductRegController" method="post" name="regForm" onsubmit="return productRegCheck();">
		<input name="name" placeholder="품명"> <p>
		<input name="price" placeholder="가격"> <p>
		<button>등록</button>
	</form>
</body>
</html>