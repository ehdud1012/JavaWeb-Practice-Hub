package com.kdy.aug302vc.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/input")
public class input extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public input() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("euc-kr");
		
		String path = request.getSession().getServletContext().getRealPath("imgggg");
		System.out.println(path);
		MultipartRequest mr = new MultipartRequest(request, path, 10485760, "euc-kr", new DefaultFileRenamePolicy());
		String i = mr.getFilesystemName("img");
		i = URLEncoder.encode(i, "euc-kr");
		i = i.replace("+", " ");
		
		String w = mr.getParameter("width");
		String h = mr.getParameter("height");
		PrintWriter pw = response.getWriter();
		pw.println("<html><head>");
		pw.println("<meta charset=\"euc-kr\">");
		pw.println("</head><body>");
		pw.printf("<img src=\"imgggg/%s\" width=\"%s\" height=\"%s\">", i, w, h);
		pw.println("</body></html>");
		
	}

}
