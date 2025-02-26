package com.kdy.jsppooh.notice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kdy.jsppooh.member.MemberDAO;

/**
 * Servlet implementation class NoticeWriterController
 */
@WebServlet("/NoticeWriteController")
public class NoticeWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 글 쓰기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(MemberDAO.isLogined(request)) {
			request.setAttribute("context", "notice/write.jsp");
		} else {
			request.setAttribute("context", "home.jsp");
		}
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

	// 글쓰고 나서
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(MemberDAO.isLogined(request)) {
			NoticeDAO.getNdao().write(request);
		}
		NoticeDAO.getNdao().clearSearch(request);
		NoticeDAO.getNdao().get(1, request);
		request.setAttribute("context", "notice/notice.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
		
	}

}
