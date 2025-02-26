package com.kdy.sep043jm.main;

import javax.servlet.http.HttpServletRequest;

// M : 실제 계산
//		계산만 진행하는데, 나머지 기능 (요청, <>)은 필요없음
//		-> 순수 java 클래스

public class Calculator {
	public static void calculator(HttpServletRequest request) {
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		int z = x + y;
		request.setAttribute("sum", z);
	}
}
