<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="HomeController" method="post" name="joinForm" onsubmit="return joinCheck();"
		enctype="multipart/form-data">
		<table id="joinTable">
			<tr>
				<th>ȸ������</th>
			</tr>
			<tr>
				<td>
					<input name="join_id" placeholder="���̵�" class="joinForm">
				</td>
			</tr>
			<tr>
				<td>
					<input type="password" name="join_pw" placeholder="���" class="joinForm">
				</td>
			</tr>
			<tr>
				<td>
					<input name="join_pw_ck" placeholder="��� Ȯ��"  class="joinForm">
				</td>
			</tr>
			<tr>
				<td class="joinForm">
					<select class="dateForm" name="y">
						<c:forEach var="y" begin="${cy-100}" end="${cy }">
							<option>${y }</option>
						</c:forEach>
					</select> &nbsp;�� &nbsp;&nbsp;
					
					<select class="dateForm" name="m">
						<c:forEach var="m" begin="1" end="12">
							<option>${m }</option>
						</c:forEach>
					</select> &nbsp;�� &nbsp;&nbsp;
					
					<select class="dateForm" name="d">
						<c:forEach var="d" begin="1" end="31">
							<option>${d }</option>
						</c:forEach>
					</select> &nbsp;�� &nbsp;&nbsp;
				</td>
			</tr>
			<tr>
				<td>
					<input name="join_photo" type="file"  class="joinForm">
				</td>
			</tr>
			<tr>
				<td align="center">
					<button id="joinbtn">ȸ������</button>
				</td>
			</tr>
		</table>	
	</form>
</body>
</html>