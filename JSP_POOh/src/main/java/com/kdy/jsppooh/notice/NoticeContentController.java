package com.kdy.jsppooh.notice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kdy.jsppooh.member.MemberDAO;

/**
 * Servlet implementation class NoticeGetController
 */
@WebServlet("/NoticeContentController")
public class NoticeContentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO.isLogined(request);
		if (NoticeDAO.getNdao().content(request)) {
			request.setAttribute("context", "notice/content.jsp");
		} else {
			NoticeDAO.getNdao().get(1, request);
			request.setAttribute("context", "notice/notice.jsp");
		}
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (MemberDAO.isLogined(request)) {
			NoticeDAO.getNdao().writeUpdate(request);
		}
		NoticeDAO.getNdao().content(request);
		request.setAttribute("context", "notice/content.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

}
