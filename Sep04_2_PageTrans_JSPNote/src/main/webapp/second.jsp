<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	 <%
	 	// HTML���� ������� parameter
	 	String a = request.getParameter("a");
	 	int aa = Integer.parseInt(a);
	 	
	 	int b = Integer.parseInt(request.getParameter("b"));
	 	
	 	// request attribute
	 	//		Object���� ����
	 	//		request ��ü �Ҽ�
	 	// 		Java���� ������� 
	 	String cccc = "������";
	 	double dddd = 12.4556;
	 	request.setAttribute("c", cccc); // "�̸�", ��
	 	request.setAttribute("d", dddd);
	 	
 		RequestDispatcher rd = request.getRequestDispatcher("third.jsp");
 		rd.forward(request, response);
	 %>
	 
	<h1>second</h1>
	<%=aa %>, <%=b %>
</body>
</html>