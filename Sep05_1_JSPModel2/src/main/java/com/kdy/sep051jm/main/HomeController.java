package com.kdy.sep051jm.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    // 첫 접속 : GET - 요청 parameter x
    // 변환하기 : GET - 요청 parameter o
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!request.getParameterNames().hasMoreElements()) {
			// 요청 parameter 이 있는가? 
			request.getRequestDispatcher("sep051_input.html").forward(request, response);
		}else {
			// 누가 변환버튼 누를 때마다 새로 만들 필요는 없으니까, singleton 으로
			UnitConverter.getUc().convert(request);
			request.getRequestDispatcher("output.jsp").forward(request, response);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
