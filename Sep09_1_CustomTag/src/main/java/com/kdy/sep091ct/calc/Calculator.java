package com.kdy.sep091ct.calc;

import javax.servlet.http.HttpServletRequest;

public class Calculator {
	public static void calculate(HttpServletRequest request) {
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		request.setAttribute("a", x + y);
		request.setAttribute("b", x - y);
		request.setAttribute("c", x * y);
		request.setAttribute("d", x / y);
	}
}
