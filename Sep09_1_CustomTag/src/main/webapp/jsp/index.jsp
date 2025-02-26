<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Sep09_1_CustomTag</title>
<link rel="stylesheet" href="css/index_css.css">
<link rel="stylesheet" href="css/calc_css.css">
<link rel="stylesheet" href="css/mart_css.css">
<script type="text/javascript" src ="js/KDYVaildChecker_v1.0.js"></script>
<script type="text/javascript" src ="js/sep091Check.js"></script>
<%
	// �� �������� ���������� ���ؼ� ȭ�鿡 ���� ��
	//		=> ���� ��
	// JSP Model 2 (Dynamic project - tomcat�� ����)
	//		��� : .jsp���� X -> webapp���� �������� 
			
	//		css/js/�׸�/... : webapp���� ����
	//		include		   : index.jsp ����
%>
</head>
<body>
	<table id="site">
		<tr>
			<td id="sitetitle" align="center">Sep09_1_CustomTag</td>
		</tr>	
		<tr>
			<td id="sitemenuArea" align="center">
				<div id="sitemenu">
					<a href="HomeController">Home</a> |
					<a href="CalcController">��Ģ����</a> |
					<a href="MartController">��Ʈ(���ǰ����)</a>
				</div>
			</td>
		</tr>	
		<tr>
			<td id="sitecontent" align="center">
				<jsp:include page="${contentPage }"></jsp:include>
				<!-- 
					index.jsp�� servlet���� �ٲ� home.jsp�� ����� �־��
						=> ���� ��
					include�� ����� �ȵǸ� ���ѷ��� : ��Ÿ üũ / "" üũ
				 -->
			</td>
		</tr>	
	</table>
</body>
</html>