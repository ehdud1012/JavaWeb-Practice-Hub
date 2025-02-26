<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" %>
    
<!-- ����ǰ Ŀ�����±׸� ����ϱ� ���� �߰��ؾ��� �� | prefix : ���ξ� ���� -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		// .jsp���� Java�� ������
		// JSP Mobel 2������ ���µ� java�� ����
		//		- �� �ޱ� : EL
		//		- include : JSP ǥ�ؾ׼��±�
		//		- �⺻ ��� (if, for, switch)
		
		// CustomTag : <���ξ�:xxx>
		//		JSP ǥ�ؾ׼��±� : .jsp���� �׳� �Ǵ°� <jsp: xxx>
		//		Ŀ�����±� : .jar ���� �ְ� ���°�
		//			- JSTL (Jsp Standard Tag Library)
		//				��ǰ�� �ƴѵ� ��ǰó�� �������� / maven -> .jar ���� / <�����: xxx>
		//				- core : ���α׷��� ��� ��� | EL�� ���ǽ�����
		//				- formatting, function, ...
	%>
	<!-- JSTL core -->
	<!-- if�� -->
		<c:if test="${result > 3}"> <!-- EL�� ���ǽ����� -->
			3���� ŭ
		</c:if> <hr>
		
	<!-- switch�� ����? -->
		<c:choose>
			<c:when test="${result > 7}"> 7���� ŭ</c:when>
			<c:when test="${result > 5}"> 5���� ŭ</c:when>
			<c:when test="${result > 3}"> 3���� ŭ</c:when>
			<c:otherwise>������</c:otherwise>
		</c:choose> <hr>

	<!-- for�� 								  step�� ���� �Ұ�	-->
		<c:forEach var="i" begin="0" end="10" step="2">
			${i }
		</c:forEach> <hr>
		
	<!-- ������ -->
		<table>
			<tr>
				<th>${result }��</th>
			</tr>
			<c:forEach var="g" items="${gugu }">
				<tr>
					<td>${g }</td>
				</tr>
			</c:forEach>
		</table> <hr>
		
	<!-- snack ��ü -->
		<c:forEach var="s" items="${snacks }">
			<h4>${s.name } : ${s.price }</h4>
		</c:forEach> <hr>
		
		
		
	<img id="jstlCimg" src="img/pooh_bf2.png">
</body>
</html>