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
					<input id="regTitle" name="title" maxlength="40" placeholder="제목" autofocus="autofocus" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td align="center">
					<textarea name="txt" placeholder="내용" autocomplete="off" maxlength="450"></textarea>
				</td>
			</tr>
			<tr>
				<td align="center">
					<button>등록</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>