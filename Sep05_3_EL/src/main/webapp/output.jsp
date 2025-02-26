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
		// JSP Model 2 : �о��Ϸ��� -> �Ϻ����� ����
		// .jsp�� v�� �����̳ʰ� �۾��ϴ� �����ε� Java�ҽ���?
		// 		-> .jsp���� Java�ҽ��� ���ּ� �о��� �ϼ���Ű��	
		
		// JSP Model 2���� .jsp�� Java �ҽ� �� ��?
		//		- �� ������
		//		- if, for ���� �⺻ ���
		//		- ��� ���� ���� �ҽ�
		//		- �帧 ����
		
		// => �ذ�
		// 		EL - �� ������
		// 		CustomTag - if, for ���� �⺻ ��� / ��� ���� ���� �ҽ� / �帧 ����
		
		// EL (Expression Language)
		//		�� ���� �� ���
		//		${...} -> .jsp�� Servlet���� �ٲ� �� java �ҽ��� �ٲ� ����
		//			������ ��밡��
		//			����ȯ �ڵ�
		//			import ���ص���
		
		// 		req parameter ���� ��
		//			${param.�̸�}
		
		//		req attribute ���� ��
		//			�⺻����	: ${�̸�}
		//			��ü��	: ${�̸�.���������} = getter ȣ��
		//			��üList	: ${�̸�[�ε���].���������}
	%>
	<h1>�ƾӾƾƾƾ�</h1>
	${param.a}<p>
	${param.b}<hr>
	${param.a + 5}<p>
	${param.a > 5}<p>
	${cc}<p>
	${dd}<hr>
	${ee.name }<p>
	${ee.age }<hr>
	${ff[0].name }, ${ff[0].age }<p>
	${ff[1].name }, ${ff[1].age }<hr>
	
	
</body>
</html>