<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function gogogo() {
		location.href = "second.jsp?a=100&b=200"; // Get ��� ��û
	}
</script>
</head>
<body>
	<!-- 
		request (���� �̵� - ������, �ۼ��ϸ� �̵�)
			1) <a> �±� 
					- Get ��� ��û
					- �ؽ�Ʈ�κ� ������
					
			2) <form>+<button> �±� 
					- ��û���(Get/Post) ���� ���� 
					- button ������ 
					- input�� �� ���� �����ٰ� �ڵ����� �ּ� ���� ��û���ִ� �ý���
					
			3) JavaScript 
					- Get ��� ��û
					- �̵���� ���� ����
					
		request parameter 
			String ���� ����
			request ��ü �Ҽ�
			HTML���� �������
	 		- GET ���  : �ּҿ� ��ܼ� ("second.jsp?a=10&b=20")
	 		- POST ��� : ���������� ����
	 		
	 	�ڵ� �̵�
 		 	1) redirect 
 		 			- �������� ���� �۾����̾ �Ⱥ�������Ҷ� ��� (��ġ ������ �긻ó��)
					response.sendRedirect("third.jsp"); 
					
 		 	2) forward 
 		 			- redirect �����ѵ�, 
 		 			- ���� ������ �� �־ ������ �̵� �ַ����� ��� 
 		 			- first -��û-> second �� �� �� ��û������ third �� �˷���
					RequestDispatcher rd = request.getRequestDispatcher("third.jsp");
 					rd.forward(request, response);
 					
 			3) include 
 					- first -second-> third �ε� second ���뵵 �����ؼ� ��� 
 					- ��ġ ���� �Ұ��ε�
 					- ��ġ ���� ������ include �� ����
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
	
	<h2 ondblclick="gogogo();">second_GO</h2> <!-- Ŀ���� ���� �ִ� ������ �̵� -->
</body>
</html>