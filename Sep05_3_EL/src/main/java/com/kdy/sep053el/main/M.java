package com.kdy.sep053el.main;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class M {
	public static void makeData(HttpServletRequest request) {
		
		// 기본형급
		String c = "ㅋ";
		request.setAttribute("cc", c);
		double d = 12.456;
		request.setAttribute("dd", d);
		
		// 객체
		Dog e = new Dog("후추", 3);
		request.setAttribute("ee", e);
		
		// 컬렉션
		// [], List, Set, Map -> List 만 사용
		ArrayList<Dog> dogs = new ArrayList<Dog>();
		dogs.add(new Dog("초코", 2));
		dogs.add(new Dog("딸기", 1));
		request.setAttribute("ff", dogs);
	}
}
