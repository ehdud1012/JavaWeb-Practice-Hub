<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>first</h1>
	<%
		// .jsp : V
		//	   - �����̳ʰ� �۾�
		//	   - �����̳����״� Java�� ���
		
		// CustomTag
		//		������ Java�� �ϴ��� DOM��ü ���·�
		// 		- �۾����� : DOM��ü -> Java�� �ٲ� ����		
		// 		- ���� : <���ξ�:xxx>
		//		- ����
		//			JSPǥ�ؾ׼��±� : (��ǰ).jsp���� �⺻ ��� ����
		//						  ���ξ jsp
		//			Ŀ�����±� 		: �ܺ�.jar���� �ְ� ����
		
		// �ڵ��̵�
		//		redirect : Ŀ�����±�
		//		forward  : request.getRequestDispatcher("second.jsp").forward(request, response); 
		//						��						
		//					<jsp:forward page="second.jsp"></jsp:forward> 
		
		//		include  : request.getRequestDispatcher("second.jsp").include(request, response);
		//							��						
		//					<jsp:include page="second.jsp"></jsp:include> ���ϴ� ��ġ�� ���� ����
	
	%>
	<jsp:include page="second.jsp"></jsp:include>
</body>
</html>