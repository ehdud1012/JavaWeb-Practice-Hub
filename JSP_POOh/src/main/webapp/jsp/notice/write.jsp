<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="NoticeWriteController" method="post" name="regForm">
		<table id="noticeRegTable">
			<tr>
				<td align="center">
					<input id="regTitle" name="title" maxlength="40" placeholder="����" autofocus="autofocus" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td align="center">
					<textarea name="txt" placeholder="����" autocomplete="off" maxlength="450"></textarea>
				</td>
			</tr>
			<tr>
				<td align="center">
					<button>���</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>