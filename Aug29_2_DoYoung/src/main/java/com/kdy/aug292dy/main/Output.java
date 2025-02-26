package com.kdy.aug292dy.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Output")
public class Output extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Output() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    // request parameter 값이 주소에
    // 인터넷 주소에 한글을 그대로 넣으면 안되고, URL인코딩 형태로 바꿔서 넣어야함
    //		ㅋ -URL인코딩-> %2A
    //		%2A -URL디코딩-> ㅋ
    //		인코딩/디코딩 
    //			Tomcat이 자동으로 해주는데 iso-8859-1 방식으로 함
    //				=> 톰캣 설정 바꾸기 : 다음부턴 안해도 됨
    //					Project Explorer - server (사본 설정 파일) - server.xml
    //					-> 63번 줄에 URIEncoding="euc-kr" 추가
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("euc-kr");
		
		int a = Integer.parseInt(request.getParameter("aa"));
		String name2 = request.getParameter("name"); // 인코딩 문제 
		PrintWriter pw = response.getWriter();
		pw.println("<html><head>");
		pw.println("<meta charset=\"euc-kr\">");
		pw.println("</head><body>");
		pw.println("<h1>GET방식</h1>");
		pw.printf("<h1>%d</h1>", a);
		pw.printf("<h1>%s</h1>", name2);
		
		pw.println("</body></html>");
	}
	// request parameter 값이 내부적으로 전달 
	// 		=> 보안성이 더 높음
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr"); // html 파일과 맞추기
		response.setCharacterEncoding("euc-kr");
		
		int a = Integer.parseInt(request.getParameter("aa"));
		String name2 = request.getParameter("name"); // 인코딩 문제 
		PrintWriter pw = response.getWriter();
		pw.println("<html><head>");
		pw.println("<meta charset=\"euc-kr\">");
		pw.println("</head><body>");
		pw.println("<h1>POST방식</h1>");
		pw.printf("<h1>%d</h1>", a);
		pw.printf("<h1>%s</h1>", name2);
		
		pw.println("</body></html>");
	}
}