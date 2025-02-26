package com.kdy.sep201xjs.snack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 전통 웹 개발 - 전통, 대기업, 정부
// 
// 새 스타일 - 스타트업, 신기술like
@WebServlet("/GetSnack")
public class GetSnack extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String snacks = SnackDAO.getSnack_XML(request);
		// 응답용 빨대
		PrintWriter pw = response.getWriter();
		pw.print(snacks);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
