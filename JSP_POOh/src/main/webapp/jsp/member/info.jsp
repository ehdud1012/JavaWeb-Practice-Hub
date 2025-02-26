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
				★ ${sessionScope.loginMember.id }님 ★
			</th>
		</tr>
		<tr>
			<td class="infoname" align="center">비밀번호</td>
			<td class="infolist">
				<input type="password" placeholder="비번" name="pw"
					class="infoForm" value="${sessionScope.loginMember.pw }">
			</td>
		</tr>
		<tr><td class="space" colspan="2"></td></tr>
		<tr>
			<td class="infoname" align="center">비밀번호<br>확인</td>
			<td class="infolist">
				<input placeholder="비번" name="pwchk"
					class="infoForm" value="${sessionScope.loginMember.pw }">
			</td>
		</tr>
		<tr><td class="space" colspan="2"></td></tr>
		<tr>
			<td class="infoname" align="center">생년월일</td>
			<td>
				&nbsp;&nbsp;<fmt:formatDate value="${sessionScope.loginMember.birthday }" pattern="yyyy년 MM월 dd일 (E)"/>
				
			</td>
		</tr>
		<tr><td class="space" colspan="2"></td></tr>
		<tr>
			<td class="infoname" align="center" valign="top">프사</td>
			<td class="infolist">
				<img id="infoprofile" src="member_photo/${sessionScope.loginMember.photo }"> <p> &nbsp;&nbsp;
				<span class="infoname">프사 변경</span> &nbsp;&nbsp;&nbsp;
				<input name="photo" type="file">
			</td>
		</tr>
		<tr><td class="space" colspan="2"></td></tr>
		<tr><td class="space" colspan="2"></td></tr>
		<tr>
			<td align="center" colspan="2">
				<button class="infobtn">수정</button>
</form>
				<button class="infobtn" onclick="bye();">탈퇴</button>
			</td>
		</tr>
	</table>
</body>
</html>