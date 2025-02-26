package com.kdy.aug291s.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MultiplicationServlet")
public class MultiplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public MultiplicationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서버가 응답할 때 쓴 인코딩 방식을 클라이언트에게 알려줘야
		// 서 -> 				 클라이언트
		// euc-kr -> 1010 -전송-> 
		response.setCharacterEncoding("euc-kr");
		
		int d = Integer.parseInt(request.getParameter("dan"));
		PrintWriter pw = response.getWriter();
		pw.println("<html><head>");
		pw.println("<meta charset=\"euc-kr\">");
		pw.println("</head><body>");
		pw.printf("<table border=\"1\" align=\"center\"><tr><th> %d단 </th></tr>", d);
		for (int i = 1; i < 10; i++) {
			pw.printf("<tr align=\"center\"><td> %d x %d = %d </td></tr>", d, i, d*i);
		}
		pw.println("</table></body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
