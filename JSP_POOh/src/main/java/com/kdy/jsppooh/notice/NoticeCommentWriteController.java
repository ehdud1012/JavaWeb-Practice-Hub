package com.kdy.jsppooh.notice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kdy.jsppooh.member.MemberDAO;

@WebServlet("/NoticeCommentWriteController")
public class NoticeCommentWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (MemberDAO.isLogined(request)) {
			NoticeDAO.getNdao().notionCommentWrite(request);
			NoticeDAO.getNdao().content(request);
			request.setAttribute("context", "notice/content.jsp");
		}
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
