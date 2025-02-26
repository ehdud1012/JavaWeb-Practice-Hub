<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Winnie The Pooh</title>
<link rel="stylesheet" href="css/index_css.css">
<link rel="stylesheet" href="css/login_css.css">
<link rel="stylesheet" href="css/join_css.css">
<link rel="stylesheet" href="css/info_css.css">
<link rel="stylesheet" href="css/notice_css.css">
<script type="text/javascript" src="js/Move.js"></script>
<script type="text/javascript" src="js/KDYVaildChecker_v1.0.js"></script>
<script type="text/javascript" src="js/pooh_vaildCheck.js"></script>
</head>
<body>
	<table id="MainArea">
		<tr>
			<td id="LogoArea" rowspan="2">
				<img id="logo" src="img/pooh11.png">
			</td>
			<td align="left" id="titleArea" colspan="2">
				<table id="title">
					<tr>
						<td>
							<a href="HomeController">Winnie The Pooh</a>
						</td>
					</tr>
				</table>
			</td>
			<td id="loginArea" align="right" rowspan="2">
				<table>
					<tr>
						<td>
							<jsp:include page="${login }"></jsp:include>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td id="menuArea" align="left">
				<table id="menu">
					<tr>
						<td>
							<a href="NoticeController">공지사항</a> &nbsp;&nbsp;&nbsp;
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<table id="contentArea">
		<tr>
			<td>
				<jsp:include page="${context }"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>