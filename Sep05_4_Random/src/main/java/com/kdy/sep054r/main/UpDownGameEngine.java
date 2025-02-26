package com.kdy.sep054r.main;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class UpDownGameEngine {
	
	private static final UpDownGameEngine UDGE = new UpDownGameEngine(); 
	private Random core;
	private int gameAns;
	private int turn;
	private UpDownGameEngine() {
		core = new Random();
	}
	
	public static UpDownGameEngine getUdge() {
		return UDGE;
	}

	public void numPick() {
		turn = 0;
		gameAns = core.nextInt(10000) + 1;
		System.out.println(gameAns);
	}
	
	public void judge(HttpServletRequest req) {
		turn++;
		int userNum = Integer.parseInt(req.getParameter("userNum"));
		if (gameAns < userNum ) {
			req.setAttribute("r", "DOWN");
		}
		else if (gameAns > userNum ) {
			req.setAttribute("r", "UP");
		}
		else if (gameAns == userNum ){
			req.setAttribute("r", turn + "턴 만에 정답");
			numPick();
		}
		
	}
}
