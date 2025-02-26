package com.kdy.sep201xjs.snack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetSnack2
 */
@WebServlet("/GetSnack2")
public class GetSnack2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		
		// 응답 내용이 웹 사이트 X, JSON이라서
		response.addHeader("Content-Type", "application/json;charset=utf-8");
		String snacks = SnackDAO.getSnack_JSON(request);
		// 응답용 빨대
		PrintWriter pw = response.getWriter();
		pw.print(snacks);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
