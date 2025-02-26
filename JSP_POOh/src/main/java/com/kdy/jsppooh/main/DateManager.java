package com.kdy.jsppooh.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class DateManager {
	public static void getCurYear(HttpServletRequest req) {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		
		String curYear = sdf.format(now);
		int curYear2 = Integer.parseInt(curYear);
		req.setAttribute("cy", curYear2);
	}
}
