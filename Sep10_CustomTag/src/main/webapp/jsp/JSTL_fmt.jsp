<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		// JSTL
		//		core : ���
		//		formatting : ���� ����
		//			-> ������ core �ʿ�? xxxx
		
		//			3�ڸ� ���� ,
		// 			�Ҽ��� ���� 2�ڸ�������
		// 			��¥�� ����
	%>
	
	���� <p>
	<fmt:formatNumber value="${a }" type="number" /> <p>
	<fmt:formatNumber value="${b }" type="number" /> <hr>
	
	�� ���� <p>
	<fmt:formatNumber value="${b }" type="currency" currencySymbol="||" /> <p>
	\<fmt:formatNumber value="${b }" type="number" /> <p>
	<fmt:formatNumber value="${b }" type="number" />�� <hr>
	
	����� <p>
	<fmt:formatNumber value="${c }" type="percent" /> <hr>
	
	�Ҽ��� <p>
	<fmt:formatNumber value="${c }" pattern="#.00" /> <hr>
	
	<%
		// pattern
		//		# : ���� ������ ���, ������ ����α�
		//		0 : ���ڰ� �ֵ縻�� �� �ڸ��� ����
	%>
	
	��¥ / �ð� <p>
		<%
			// <fmt:formatDate value="${d }"/>
			// formatDate�� Java�� Date ��ü���� ��
			// ���� ��¥������ ���� String �ȴ�
			
			// java.sql.Date vs java.util.Date ���ڰ� ������
		%>
	<fmt:formatDate value="${e }"/> <p>
	<fmt:formatDate value="${e }" type="date" dateStyle="short"/> <p>
	<fmt:formatDate value="${e }" type="date" dateStyle="long"/> <p>
	
	<fmt:formatDate value="${e }" type="time" timeStyle="short"/> <p>
	<fmt:formatDate value="${e }" type="time" timeStyle="long"/> <p>
	
	<fmt:formatDate value="${e }" type="both" dateStyle="long" timeStyle="short"/> <p> 
	<fmt:formatDate value="${e }" pattern="yyyy/MM/dd(E)" /> <hr> 
	
	<img id="jstlCimg" src="img/pooh_bee.png">
</body>
</html>