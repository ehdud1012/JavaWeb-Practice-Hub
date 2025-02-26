package com.kdy.aug291s.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MathSErvlet
 */
@WebServlet("/MathSErvlet")
public class MathSErvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public MathSErvlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    // request parameter
    // 		클라이언트가 서버한테 요청할 때 보내는 정보
    // http://주소:포트번호/폴더명/.../파일명?변수명=값&변수명=값&...
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("euc-kr");
		
		// 클라이언트가 보내준 요청 parameter aa, bb
		
		String aaa = request.getParameter("aa"); // String
		int x = Integer.parseInt(aaa); // String -> int
		
		int y = Integer.parseInt(request.getParameter("bb")); // 줄여쓰기 
		
		// int x = Integer.parseInt("aa"); <= 실수 주의
		PrintWriter pw = response.getWriter();
		pw.println("<html><head>");
		pw.println("<meta charset=\"euc-kr\">");
		pw.println("</head><body>");
		
		pw.println("<table border=\"1\"><tr><th> 사칙연산 </th></tr>");
		pw.printf("<tr align=\"center\"><td> %d + %d = %d </td></tr>", x, y, x+y);
		pw.printf("<tr align=\"center\"><td> %d - %d = %d </td></tr>", x, y, x-y);
		pw.printf("<tr align=\"center\"><td> %d x %d = %d </td></tr>", x, y, x*y);
		pw.printf("<tr align=\"center\"><td> %d / %d = %d </td></tr>", x, y, x/y);
		pw.println("</table>");
		pw.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
