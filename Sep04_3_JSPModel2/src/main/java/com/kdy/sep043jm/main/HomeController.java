package com.kdy.sep043jm.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// C : 상황판단해서 흐름제어, 사이트 전체의 진입점
//		웹 환경에서 상황판단? = 요청 구분하는것 
//		요청 처리 가능한게 Servlet or JSP
//		JSP는 GET/POST 구별이 불가능
//			-> JSP Model 2 프로젝트에서 C는 Servlet

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

    // 첫 접속(주소 타이핑, 검색해서 눌러서)은 GET방식 요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// C 실행하면 바로 input.html이 화면에 뜨도록
		
		// RequestDispatcher rd = request.getRequestDispatcher("input.html");
 		// rd.forward(request, response);
		// 줄여서 ▽
		request.getRequestDispatcher("input.html").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Calculator.calculator(request);
		request.getRequestDispatcher("output.jsp").forward(request, response);
	}

}
