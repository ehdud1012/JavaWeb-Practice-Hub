<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function gogogo() {
		location.href = "SecondController?a=20";
	}
</script>

</head>
<body>
	<img src="pooh_balloon.png"> <hr>
	<a href="SecondController?a=10">a</a> <hr> 
	
	<form action="SecondController">
		<input name="a" placeholder="a">
		<button>form</button>
	</form>
	<hr>
	<h1 ondblclick="gogogo();">script</h1>
	<hr>
	${sessionScope.c }
	${cookie.d.value }
</body>
</html>