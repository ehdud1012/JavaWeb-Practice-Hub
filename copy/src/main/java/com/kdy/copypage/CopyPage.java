package com.kdy.copypage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/CopyPage")
public class CopyPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public CopyPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("euc-kr");
		
		String path = request.getSession().getServletContext().getRealPath("파일이름");
		System.out.println(path);
//		MultipartRequest mr = new MultipartRequest(request, path, 최대용량, "euc-kr", new DefaultFileRenamePolicy());
//		String title = mr.getParameter("title");
		PrintWriter pw = response.getWriter();
		pw.println("<html><head>");
		pw.println("<meta charset=\"euc-kr\">");
		pw.println("</head><body>");
		
		pw.println("</body></html>");
		
	}

}
