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
		String result = "��ü��";
		int v = 1;
		if(bmi >= 39) { result = "����"; v = 6;}
		else if(bmi >= 32) { result = "�ߵ���"; v = 5;}
		else if(bmi >= 30) { result = "�浵��"; v = 4;}
		else if(bmi >= 24) { result = "��ü��"; v = 3;}
		else if(bmi >= 10) { result = "����"; v = 2;}
	%>
	<table>
		<tr>
			<th colspan="2" align="center">���</th>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<img src="Sep04_1_photo/<%=p %>">
			</td>
		</tr>
		<tr>
			<td class="oo">�̸�</td> <td><%=name %></td>
		</tr>
		<tr>
			<td class="oo">Ű</td> <td><%=h * 100 %>cm</td>
		</tr>
		<tr>
			<td class="oo">������</td> <td><%=w %>kg</td>
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