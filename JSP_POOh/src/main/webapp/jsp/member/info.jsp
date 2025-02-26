<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table id="infoTable">
<form action="MemberInfoController" method="post" name="updateForm" onsubmit="return updateCheck();" enctype="multipart/form-data">
		<tr id="infoid">
			<th colspan="2">
				�� ${sessionScope.loginMember.id }�� ��
			</th>
		</tr>
		<tr>
			<td class="infoname" align="center">��й�ȣ</td>
			<td class="infolist">
				<input type="password" placeholder="���" name="pw"
					class="infoForm" value="${sessionScope.loginMember.pw }">
			</td>
		</tr>
		<tr><td class="space" colspan="2"></td></tr>
		<tr>
			<td class="infoname" align="center">��й�ȣ<br>Ȯ��</td>
			<td class="infolist">
				<input placeholder="���" name="pwchk"
					class="infoForm" value="${sessionScope.loginMember.pw }">
			</td>
		</tr>
		<tr><td class="space" colspan="2"></td></tr>
		<tr>
			<td class="infoname" align="center">�������</td>
			<td>
				&nbsp;&nbsp;<fmt:formatDate value="${sessionScope.loginMember.birthday }" pattern="yyyy�� MM�� dd�� (E)"/>
				
			</td>
		</tr>
		<tr><td class="space" colspan="2"></td></tr>
		<tr>
			<td class="infoname" align="center" valign="top">����</td>
			<td class="infolist">
				<img id="infoprofile" src="member_photo/${sessionScope.loginMember.photo }"> <p> &nbsp;&nbsp;
				<span class="infoname">���� ����</span> &nbsp;&nbsp;&nbsp;
				<input name="photo" type="file">
			</td>
		</tr>
		<tr><td class="space" colspan="2"></td></tr>
		<tr><td class="space" colspan="2"></td></tr>
		<tr>
			<td align="center" colspan="2">
				<button class="infobtn">����</button>
</form>
				<button class="infobtn" onclick="bye();">Ż��</button>
			</td>
		</tr>
	</table>
</body>
</html>