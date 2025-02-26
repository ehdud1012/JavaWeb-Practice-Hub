<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table id="profileArea">
		<tr align="center">
			<td rowspan="2">
				<img id="profile" src="member_photo/${loginMember.photo }">
			</td>
			<td>
				<button class="profilebtn" onclick="goMemberInfo();">회원정보<br>확인</button>
			</td>
		</tr>
		<tr align="center" >
			<td>
				<button class="profilebtn" onclick="goLogout();">로그아웃</button>
			</td>
		</tr>
		<tr align="center">
			<td colspan="2">
				${sessionScope.loginMember.id }님 안뇽
			</td>
		</tr>
	</table>
</body>
</html>