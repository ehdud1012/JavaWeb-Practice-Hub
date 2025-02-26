package com.kdy.sep091ct.mart;

import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

public class PriceCalc {
	public static void priceCalc(HttpServletRequest request) {
		String martInput = request.getParameter("martInput");
		int sum = 0;
		
		// textArea에서 숫자값만  더하기
		StringTokenizer st = new StringTokenizer(martInput, "\r\n");
		while (st.hasMoreTokens()) {
			try {
				sum += Integer.parseInt(st.nextToken());
			} catch (Exception e) {
				// 중간에 글자 있으면 그냥 넘어가기
			}
		}
		
		request.setAttribute("priceSum", sum);
	}
}
