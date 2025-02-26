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
		//	   - 디자이너가 작업
		//	   - 디자이너한테는 Java가 어렵
		
		// CustomTag
		//		기존에 Java로 하던걸 DOM객체 형태로
		// 		- 작업형태 : DOM객체 -> Java로 바뀌어서 실행		
		// 		- 문법 : <접두어:xxx>
		//		- 종류
		//			JSP표준액션태그 : (정품).jsp에서 기본 사용 가능
		//						  접두어가 jsp
		//			커스텀태그 		: 외부.jar파일 넣고 쓰는
		
		// 자동이동
		//		redirect : 커스텀태그
		//		forward  : request.getRequestDispatcher("second.jsp").forward(request, response); 
		//						▽						
		//					<jsp:forward page="second.jsp"></jsp:forward> 
		
		//		include  : request.getRequestDispatcher("second.jsp").include(request, response);
		//							▽						
		//					<jsp:include page="second.jsp"></jsp:include> 원하는 위치에 조절 가능
	
	%>
	<jsp:include page="second.jsp"></jsp:include>
</body>
</html>