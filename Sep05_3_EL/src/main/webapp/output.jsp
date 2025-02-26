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
		// JSP Model 2 : 분업하려고 -> 완벽하지 않음
		// .jsp는 v라서 디자이너가 작업하는 파일인데 Java소스가?
		// 		-> .jsp에서 Java소스를 없애서 분업을 완성시키자	
		
		// JSP Model 2에서 .jsp에 Java 소스 쓸 일?
		//		- 값 받을때
		//		- if, for 같은 기본 제어문
		//		- 출력 형식 관련 소스
		//		- 흐름 제어
		
		// => 해결
		// 		EL - 값 받을때
		// 		CustomTag - if, for 같은 기본 제어문 / 출력 형식 관련 소스 / 흐름 제어
		
		// EL (Expression Language)
		//		값 받을 때 사용
		//		${...} -> .jsp가 Servlet으로 바뀔 때 java 소스로 바뀌어서 실행
		//			연산자 사용가능
		//			형변환 자동
		//			import 안해도됨
		
		// 		req parameter 받을 때
		//			${param.이름}
		
		//		req attribute 받을 때
		//			기본형급	: ${이름}
		//			객체급	: ${이름.멤버변수명} = getter 호출
		//			객체List	: ${이름[인덱스].멤버변수명}
	%>
	<h1>아앙아아아앙</h1>
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