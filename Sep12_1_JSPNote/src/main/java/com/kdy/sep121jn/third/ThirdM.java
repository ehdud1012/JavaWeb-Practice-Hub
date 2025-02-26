package com.kdy.sep121jn.third;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class ThirdM {
	public static void test(HttpServletRequest req) {
		Object ccc = req.getSession().getAttribute("c");
		int cccc = (int) ccc;
		System.out.println(cccc);
		
		// 현재 사용자의 PC에 만들어져있는 쿠키들
		Cookie[] cookies = req.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("d")) {
				System.out.println(cookie.getValue());
			}
			
		}
	}
}
