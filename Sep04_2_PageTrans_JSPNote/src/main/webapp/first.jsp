<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function gogogo() {
		location.href = "second.jsp?a=100&b=200"; // Get 방식 요청
	}
</script>
</head>
<body>
	<!-- 
		request (수동 이동 - 누르면, 작성하면 이동)
			1) <a> 태그 
					- Get 방식 요청
					- 텍스트부분 누르면
					
			2) <form>+<button> 태그 
					- 요청방식(Get/Post) 선택 가능 
					- button 누르면 
					- input에 쓴 내용 가져다가 자동으로 주소 만들어서 요청해주는 시스템
					
			3) JavaScript 
					- Get 방식 요청
					- 이동모션 선택 가능
					
		request parameter 
			String 으로 전달
			request 객체 소속
			HTML에서 만들어진
	 		- GET 방식  : 주소에 담겨서 ("second.jsp?a=10&b=20")
	 		- POST 방식 : 내부적으로 전달
	 		
	 	자동 이동
 		 	1) redirect 
 		 			- 페이지에 무언가 작업중이어서 안보여줘야할때 사용 (마치 공사중 펫말처럼)
					response.sendRedirect("third.jsp"); 
					
 		 	2) forward 
 		 			- redirect 동일한데, 
 		 			- 값을 전달할 수 있어서 페이지 이동 주력으로 사용 
 		 			- first -요청-> second 할 때 그 요청정보를 third 로 알려줌
					RequestDispatcher rd = request.getRequestDispatcher("third.jsp");
 					rd.forward(request, response);
 					
 			3) include 
 					- first -second-> third 인데 second 내용도 포함해서 출력 
 					- 위치 조절 불가인데
 					- 위치 조절 가능한 include 가 있음
	 				RequestDispatcher rd = request.getRequestDispatcher("third.jsp");
 					rd.include(request, response);
 			RequestDispatcher 
	 -->
	<h1>first</h1>
	<a href="second.jsp?a=10&b=20">second_GO</a>
	<hr>
	
	<form action="second.jsp" method="post">
		a : <input name="a"> <p>
		b : <input name="b"> <p>
		<button>second_GO</button>
	</form>
	<hr>
	
	<h2 ondblclick="gogogo();">second_GO</h2> <!-- 커서가 위에 있다 빠지면 이동 -->
</body>
</html>