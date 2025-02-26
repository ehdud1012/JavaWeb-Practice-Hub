package com.kdy.sep121jn.second;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// request Parameter
//		V에서 만들어진 값
//		request 소속
//		String or String[]
//		Java : req.getParameter("파라메터변수명")
//		EL : ${param.파라메터변수명 }

//request Attribute
//		M에서 만들어진 값
//		request 소속
//		Object
//		Java : req.getAttribute("어트리뷰트명")
//		EL : ${어트리뷰트명 }

// session attribute
//		M에서 만들어진 값
//		session(사용자와 서버간의 연결 통로) 소속
//			서버-사용자 연결이 끊어지지만 않으면 어디서든 사용가능
//			브라우저를 닫으면 / session 유지시간(기본 30분)이 지나면 끊어짐
//									유지시간 내에 요청을 하면 갱신
//			사용자 개인의 공간

//		Object
//		Java : req.getSession().getAttribute("어트리뷰트명")
//		EL : ${sessionScope.어트리뷰트명 }

// cookie
//		M에서 만들어진 값
//		사용자 컴퓨터에 파일 형태로
//			파일 : 재부팅해도 살아있으니 -> 보안상의 위험 (요즘은 암호화)
//				유지시간 있음
//		String
//		Java : Third M으로
//		EL : ${cookie.이름.value}
public class SecondM {
	public static void test(HttpServletRequest req, HttpServletResponse res) {
		int a = Integer.parseInt(req.getParameter("a"));
		System.out.println(a);
		
		int b = 100;
		req.setAttribute("b", b);
		Object bb = req.getAttribute("b");
		int bbb = (int) bb;
		System.out.println(bbb);
		
		int cc = 200;
		HttpSession hs = req.getSession();
		hs.setMaxInactiveInterval(60); // 세션 유지 시간
		hs.setAttribute("c", cc);
		
		int dd = 300;
		String ddd = dd+"";
		Cookie dddd = new Cookie("d", ddd);
		dddd.setMaxAge(1 * 60 * 60 * 24);
		res.addCookie(dddd);
	}
}
