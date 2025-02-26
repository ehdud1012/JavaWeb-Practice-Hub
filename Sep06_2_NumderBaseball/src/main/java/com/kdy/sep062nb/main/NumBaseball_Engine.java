package com.kdy.sep062nb.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class NumBaseball_Engine {
	private static final NumBaseball_Engine NBE = new NumBaseball_Engine();
	
	private Random r;
	private String comNum; // 숫자 계산할 것이 아니기 때문에 String 으로 해야 편함
	private int turn;
	
	public NumBaseball_Engine() {
		r = new Random();
	}

	public static NumBaseball_Engine getNbe() {
		return NBE;
	}
	
	public void numPick() {
		int t = r.nextInt(976) + 12; // 12 ~ 987
		comNum = String.format("%03d", t);
		// 0-1/1-2/0-2 
		if (comNum.charAt(0) == comNum.charAt(1) 
				|| comNum.charAt(1) == comNum.charAt(2) 
				|| comNum.charAt(0) == comNum.charAt(2)) {
			numPick();
		}
		System.out.println(comNum);
	}
	
	public void judge(HttpServletRequest req) {
		int strike = 0;
		int ball = 0;
		String userNum = req.getParameter("userNum");
		if (userNum.equals(comNum)) {
			req.setAttribute("r", turn + "번만에 정답! 숫자가 변경되었습니다");
			turn = 0;
			numPick();
		} else {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (comNum.charAt(i) == userNum.charAt(j)) {
						if (i == j) {
							strike++;
						} else {
							ball++;
						} break;
					}
				}
			}
			req.setAttribute("r", strike + "S " + ball + "B");
			turn++;
		}
		
	}
}
