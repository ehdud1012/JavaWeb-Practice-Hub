package com.kdy.aug293iop.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JoinServlet")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public JoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setCharacterEncoding("euc-kr");
		String id = request.getParameter("id");
		String pw2 = request.getParameter("pw");
		String gd = request.getParameter("gender");
		String ad = request.getParameter("address");
		
		// checkbox 쓰려면 post 이여야 함 : 값을 주소에 넣어야하는 Get 방식 (,) 불가
		String[] inter = request.getParameterValues("inter");
		
		// textarea 에서 엔터치면 \r\n
		// HTML에서 줄바꿈 = <br>
		// 입력한거를 java or textarea 에서 쓸거면 그대로 냅두고,
		// 웹에서 쓸꺼면 <br>, <p> 등으로 변경해야함
		String it = request.getParameter("introduce");
		it = it.replace("\r\n", "<br>");
		PrintWriter pw = response.getWriter();
		pw.println("<html><head>");
		pw.println("<meta charset=\"euc-kr\">");
		pw.println("</head><body>");
		pw.printf("<h1>%s</h1>", id);
		pw.printf("<h1>%s</h1>", pw2);
		pw.printf("<h1>%s</h1>", gd);
		pw.printf("<h1>%s</h1>", ad);
		if(inter != null) {
			for (String string : inter) {
				pw.printf("<h1>%s</h1>", string);
			}
		}
		pw.printf("<h1>%s</h1>", it);
		
		pw.println("</body></html>");
	}

}
