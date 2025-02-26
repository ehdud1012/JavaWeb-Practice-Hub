<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table id="loginTable">
		<form action="Logincontroller" name="loginForm" 
			method="post" onsubmit="return loginCheck();">
			<tr>
				<td>
					<input name="id" maxlength="10" autocomplete="off"
						placeholder="아이디를 입력하세요" class="loginForm">
				</td>
			</tr>
			<tr>
				<td>
					<input name="pw" maxlength="10" autocomplete="off"
						placeholder="비밀번호를 입력하세요" class="loginForm">
				</td>
			</tr>
			<tr>
				<td align="center">
					<button class="loginbtn">로그인</button>
				</td>
			</tr>
		</form>
			<tr>
				<td align="center">
					<button class="loginbtn" onclick="goJoin();">회원가입</button>
				</td>
			</tr>
	</table>
		
</body>
</html>