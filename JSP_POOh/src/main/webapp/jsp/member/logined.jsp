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
				<button class="profilebtn" onclick="goMemberInfo();">ȸ������<br>Ȯ��</button>
			</td>
		</tr>
		<tr align="center" >
			<td>
				<button class="profilebtn" onclick="goLogout();">�α׾ƿ�</button>
			</td>
		</tr>
		<tr align="center">
			<td colspan="2">
				${sessionScope.loginMember.id }�� �ȴ�
			</td>
		</tr>
	</table>
</body>
</html>