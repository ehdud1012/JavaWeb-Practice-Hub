package com.kdy.sep10ct.c;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class DataMaker {
	public static void make(HttpServletRequest req) {
		int a =123456;
		req.setAttribute("a", a);
		
		String b = "122342325";
		req.setAttribute("b", b);
		
		double c = 123.243453;
		req.setAttribute("c", c);
		
		String d = "2004-10-12";
		req.setAttribute("d", d);
		
		Date e = new Date();
		req.setAttribute("e", e);
	}
}
