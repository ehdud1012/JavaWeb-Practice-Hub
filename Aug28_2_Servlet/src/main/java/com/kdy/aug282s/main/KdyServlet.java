package com.kdy.aug282s.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @XXX : annotation
//		원래 사람이 직접해야하는데 자동으로 처리해줌

// 원래 서블릿 만들면 tomcat에 수동 등록해야되는데
@WebServlet("/KdyServlet") // 자동 등록 해주는 친구 => 지우면 망함
public class KdyServlet extends HttpServlet { // 상속
	// Event-driven Programming
	//		1) main : Tomcat에 있음
	//		2) 실행하면 Tomcat이 KdyServlet객체를 만들고
	//		3) 이벤트루프 돌다가 
	
	// HttpServlet의 기능 
	//		요청 받으면 HTML + CSS를 만들어 응답하는 Java프로그램
	//		WAS에서만 실행됨
	
	
	// 협업하면서 버전 표시하라고 변수 하나 만들어준거 - 별 필요없음
	private static final long serialVersionUID = 1L;
    
	// Tomcat이 객체 자동 생성하니 - 별 필요없음
    public KdyServlet() { // 생성자
        super();
    }
    

    // 4) 클라이언트로부터 GET방식 요청 받으면 Tomcat이 여기 호출
    // 		주소를 직접 타이핑해서 접속
    //		<a>로 접속
    //			=> <a> : GET방식 요청 날리기
    //		=> 기본적으로 GET방식
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// 랜선에 붙어있는 서->클 응답용 빨대
		// OutputStreamWriter 개조, 기능 추가
		PrintWriter pw = response.getWriter();
		pw.println("<html><head>");
		pw.println("<meta charset=\"euc-kr\">");
		pw.println("</head><body>");
		pw.println("<marquee>^__^/</marquee>");
		pw.println("</body></html>");
		
	}

	// 4) 클라이언트로부터 POST방식 요청 받으면 Tomcat이 여기 호출
	//		특수한 상황에서만 POST방식
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST방식임");
	}
	
	// HTTP 통신 
    //		요청 -> 응답
    //		- GET방식 요청
    //		- POST방식 요청
}
