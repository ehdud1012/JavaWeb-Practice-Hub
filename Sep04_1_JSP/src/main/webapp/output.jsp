<%@page import="java.net.URLEncoder"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="Sep04_1_CSS.css">
<%!
	public String cut(double d){
		return String.format("%.1f", d);
	}
%>
</head>
<body>
	<%
		String path = request.getSession().getServletContext().getRealPath("Sep04_1_photo");
		MultipartRequest mr = new MultipartRequest(request, path, 10485760, "euc-kr", new DefaultFileRenamePolicy());	
		String p = mr.getFilesystemName("photo");
		p = URLEncoder.encode(p, "euc-kr");
		p = p.replace("+", " ");
		
		String name = mr.getParameter("name");
		Double h = Double.parseDouble(mr.getParameter("height"));
		h = h / 100;
		Double w = Double.parseDouble(mr.getParameter("weight"));
		Double bmi = w / (h*h);
		String result = "저체중";
		int v = 1;
		if(bmi >= 39) { result = "고도비만"; v = 6;}
		else if(bmi >= 32) { result = "중도비만"; v = 5;}
		else if(bmi >= 30) { result = "경도비만"; v = 4;}
		else if(bmi >= 24) { result = "과체중"; v = 3;}
		else if(bmi >= 10) { result = "정상"; v = 2;}
	%>
	<table>
		<tr>
			<th colspan="2" align="center">결과</th>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<img src="Sep04_1_photo/<%=p %>">
			</td>
		</tr>
		<tr>
			<td class="oo">이름</td> <td><%=name %></td>
		</tr>
		<tr>
			<td class="oo">키</td> <td><%=h * 100 %>cm</td>
		</tr>
		<tr>
			<td class="oo">몸무게</td> <td><%=w %>kg</td>
		</tr>
		<tr>
			<td class="oo">bmi</td> <td><%=cut(bmi) %></td>
		</tr>
		<tr>
			<td colspan="2" align="center" id="result"><%=result %></td>
		</tr>
	</table>
</body>
</html>