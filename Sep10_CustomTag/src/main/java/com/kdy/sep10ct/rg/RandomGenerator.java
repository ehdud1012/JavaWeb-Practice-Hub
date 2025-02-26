package com.kdy.sep10ct.rg;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class RandomGenerator {
	
	private static final RandomGenerator RN = new RandomGenerator();
	private Random r;
	
	public RandomGenerator() {
		r = new Random();
	}
	
	public static RandomGenerator getRn() {
		return RN;
	}

	public void generate(HttpServletRequest req) {
		int start = Integer.parseInt(req.getParameter("start"));
		int end = Integer.parseInt(req.getParameter("end"));
		int t = r.nextInt(start, end + 1);
		req.setAttribute("result", t);
		
		// M에서 table 만들기는 에바니까
		// V가 쓰기 최대한 편한 형태로 결과 보내기
		ArrayList<String> gugudan = new ArrayList<String>();
		String s;
		for (int i = 1; i < 10; i++) {
			s = String.format("%d x %d = %d\n", t, i, t*i);
			gugudan.add(s);
		}
		req.setAttribute("gugu", gugudan);
		
		ArrayList<Snack> snacks = new ArrayList<Snack>();
		snacks.add(new Snack("새우깡", 3000));
		snacks.add(new Snack("양파링", 3500));
		snacks.add(new Snack("빼빼로", 1500));
		req.setAttribute("snacks", snacks);
	}
}
