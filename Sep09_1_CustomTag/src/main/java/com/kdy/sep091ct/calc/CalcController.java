package com.kdy.sep091ct.calc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcController
 */
@WebServlet("/CalcController")
public class CalcController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 계산하러가기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("contentPage", "calc/input.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

	// 계산하기
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Calculator.calculate(request);
		request.setAttribute("contentPage", "calc/output.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
		
	}

}