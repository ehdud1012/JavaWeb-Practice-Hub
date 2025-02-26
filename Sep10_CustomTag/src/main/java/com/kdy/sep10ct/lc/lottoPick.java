package com.kdy.sep10ct.lc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class lottoPick {
	private static final lottoPick LP = new lottoPick();
	private Random r;
	
	public lottoPick() {
		r = new Random();
	}

	public static lottoPick getLp() {
		return LP;
	}
	
	public void numPick(HttpServletRequest req) {
		HashSet<Integer> lottoNum = new HashSet<Integer>();
		while (lottoNum.size() != 6) {
			lottoNum.add(r.nextInt(45) + 1);
		}
		
		ArrayList<Integer> al = new ArrayList<Integer>(lottoNum);
		al.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
		req.setAttribute("lotto", al);
	}
	
}
