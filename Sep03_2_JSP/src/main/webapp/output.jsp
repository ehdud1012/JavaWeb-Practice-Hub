<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="unitChangeCSS.css">
<%!
	public String cut(double d){
		return String.format("%.1f", d);
	}
%>
</head>
<body>
	<%
		double num = Double.parseDouble(request.getParameter("input"));
		String unit = request.getParameter("unit");
		HashMap<String, String[]> units = new HashMap<String, String[]>();
		units.put("len", new String[]{"cm", "inch"});
		units.put("size", new String[]{"㎡", "평"});
		units.put("temp", new String[]{"℃", "℉"});
		units.put("spd", new String[]{"km/h", "mi/h"});
		
		double result = (double)num * 0.621371;
		if (unit.equals("len")){
			result = (double)num * 0.393701;
		}else if (unit.equals("size")){
			result = (double)num * 0.3025;
		}else if (unit.equals("temp")){
			result = (double)num * 1.8 + 32;
		}
	%> 
	<table id=<%=unit %>>
		<tr>
			<th align="center" colspan="2">변환 결과</th>
		</tr>
		<tr>
			<td align="center">
				<%=cut(num) %> <%=units.get(unit)[0] %>
			</td>
		</tr>
		<tr>
			<td align="center" colspan="2">
				↓
			</td>
		</tr>
		<tr>
			<td align="center">
				<%=cut(result)%> <%=units.get(unit)[1] %>
			</td>
		</tr>
	</table>
</body>
</html>