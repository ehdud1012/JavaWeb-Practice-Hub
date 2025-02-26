package com.kdy.sep061rsp.main;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class RSP_GameEngine {
	private static final RSP_GameEngine RGE = new RSP_GameEngine();
	
	private Random core;
	private int comHand;
	private int win;
	private int lose;
	private int draw;
	
	
	private RSP_GameEngine() {
		core = new Random();
	}
	
	
	public static RSP_GameEngine getRge() {
		return RGE;
	}

	public void start(HttpServletRequest req) {
		req.setAttribute("userHand", "start.gif");
		req.setAttribute("comHand", "start.gif");
	}
	
	public void judge(HttpServletRequest req) {
		comHand = core.nextInt(3) + 1;
		int userHand = Integer.parseInt(req.getParameter("userHand"));
		
		req.setAttribute("userHand", userHand + ".png");
		req.setAttribute("comHand", comHand + ".png");
		
		int t = userHand - comHand;
		if (t == 0) {
			req.setAttribute("r", "무승부");
			draw++;
		}
		else if (t == -1 || t == 2) {
			req.setAttribute("r", "패");
			lose++;
		}else {
			req.setAttribute("r", "승");
			win++;
		}
		req.setAttribute("score", win+"승"+draw+"무"+lose+"패");
		
	}
	
}
