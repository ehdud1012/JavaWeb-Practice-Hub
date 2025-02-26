package com.kdy.jsppooh.notice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kdy.jsppooh.member.MemberDAO;

/**
 * Servlet implementation class NoticeController
 */
@WebServlet("/NoticeController")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	// 게시판 들어갈 때
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// 		로그인 안하면 안보이게
//		if (MemberDAO.isLogined(request)) {
//			request.setAttribute("context", "notice/notice.jsp");
//		} else {
//			request.setAttribute("context", "home.jsp");
//		}
		MemberDAO.isLogined(request);
		NoticeDAO.getNdao().clearSearch(request);
		NoticeDAO.getNdao().get(1, request);
		request.setAttribute("context", "notice/notice.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

	// 검색
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO.isLogined(request);
		NoticeDAO.getNdao().search(request);
		NoticeDAO.getNdao().get(1, request);
		request.setAttribute("context", "notice/notice.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

}
