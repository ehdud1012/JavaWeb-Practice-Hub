package com.kdy.aug301ful.main;

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

@WebServlet("/FileuploadServlet")
public class FileuploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public FileuploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request.setCharacterEncoding("euc-kr");
		response.setCharacterEncoding("euc-kr");
		

		// 이클립스랑 연동된 복사본 톰캣 위치
		//		워크스페이스\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\프로젝트명\폴더명
		//		=> c드라이브가 어딧는데 상대경로로 해줘야지 !

		// 상대경로 -> 서버상의 절대경로
		String path = request.getSession().getServletContext().getRealPath("imggg");
		System.out.println(path);
		
		// 인코딩 방식 톰캣 -> cos.jar
		// 디코딩 방식도 바뀌는게 당연
		// 파일 구현 처리 완료
		MultipartRequest mr = new MultipartRequest
				(
					request,
					path,							// 파일이 업로드될 경로
					10 * 1024 * 1024,				// 업로드 허용 파일 최대 크기 (byte 단위) = 10메가
					"euc-kr",						// 요청 parameter 인코딩 방식
					new DefaultFileRenamePolicy() 	// 파일명 중복처리 (중복되면 뒤에 1234 붙이는)
				);
		
		String title = mr.getParameter("title");
		
		String p = mr.getFilesystemName("photo");
		String z = mr.getFilesystemName("zip");
		
		// 톰캣이 한글로 된 파일명 인식 못함
		//		URL인코딩 필요
		p = URLEncoder.encode(p, "euc-kr");
		// URL인코딩에서 띄어쓰기는 +로 됨 
		// "+" -> " "
		p = p.replace("+", " ");
		
		String zz = URLEncoder.encode(z, "euc-kr");
		zz = zz.replace("+", " ");
		
		PrintWriter pw = response.getWriter();
		pw.println("<html><head>");
		pw.println("<meta charset=\"euc-kr\">");
		pw.println("</head><body>");
		pw.printf("<h1>%s</h1>", title);
		pw.printf("<img src=\"imggg/%s\"><p>", p);
		pw.printf("<a href=\"imggg/%s\">%s</a>", zz,z);
		pw.println("</body></html>");
	}

}
