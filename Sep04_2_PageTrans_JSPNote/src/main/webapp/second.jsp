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
	 	// HTML에서 만들어진 parameter
	 	String a = request.getParameter("a");
	 	int aa = Integer.parseInt(a);
	 	
	 	int b = Integer.parseInt(request.getParameter("b"));
	 	
	 	// request attribute
	 	//		Object으로 전달
	 	//		request 객체 소속
	 	// 		Java에서 만들어진 
	 	String cccc = "ㅋㅋㅋ";
	 	double dddd = 12.4556;
	 	request.setAttribute("c", cccc); // "이름", 값
	 	request.setAttribute("d", dddd);
	 	
 		RequestDispatcher rd = request.getRequestDispatcher("third.jsp");
 		rd.forward(request, response);
	 %>
	 
	<h1>second</h1>
	<%=aa %>, <%=b %>
</body>
</html>