package com.kdy.jsppooh.member;

import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import com.kdy.db.manager.KdyDBManager;
import com.kdy.jsppooh.notice.NoticeDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

// 정상적인 사진 파일을 선택해야하는데 .xls -> .png로 바꿔서 하면
// 사용자 손해
// 서버 쪽에서는 손해 X

// 만약 파일 용량이 크다면
//		=> 가입 실패 (서버쪽에서 용량 손해)
//		1) 사용자가 10M 넘는 사진 파일 선택 -> DB연결을 굳이?
//		2) 사용자가 정상 입력 -> DB서버 문제 -> 이미 업로드된 파일?
public class MemberDAO {
	
	public static String getProfile(HttpServletRequest req, String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = KdyDBManager.connect("kdyPool");
			String sql = "select pm_photo from pooh_member where pm_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			rs.next();
			String profile = rs.getString("pm_photo");
			return profile;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			KdyDBManager.close(con, pstmt, rs);
		}
	}
	
	public static void join(HttpServletRequest req) {
		MultipartRequest mr = null;
		String path = req.getSession().getServletContext().getRealPath("member_photo");
		try {
			mr = new MultipartRequest( req, path, 10 * 1024 * 1024, "euc-kr", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "가입실패 (파일용량)");
			return; // 1) 해결
		}
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = KdyDBManager.connect("kdyPool");
			req.setCharacterEncoding("euc-kr");
			
			String id = mr.getParameter("join_id");
			String pw = mr.getParameter("join_pw");
			
			String y = mr.getParameter("y");
			int m = Integer.parseInt(mr.getParameter("m"));
			int d = Integer.parseInt(mr.getParameter("d"));
			String bd = String.format("%s%02d%02d", y, m, d);

			String photo = URLEncoder.encode(mr.getFilesystemName("join_photo"), "euc-kr").replace("+", " ");
			
			String sql = "insert into pooh_member values(?, ?, to_date(?, 'YYYYMMDD'), ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, bd);
			pstmt.setString(4, photo);
			
			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("result", "가입성공");
			}
		} catch (Exception e) {
			req.setAttribute("result", "가입실패(DB서버)");
			// 이미 파일이 올라가 있는 -> 업로드된 파일 삭제
			File f = new File(path + "/" + mr.getFilesystemName("join_photo"));
			f.delete();
		}
		KdyDBManager.close(con, pstmt, null);
	}
	public static void loginCheck(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = KdyDBManager.connect("kdyPool");
			
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			
			String sql = "select * from pooh_member where pm_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString("pm_pw").equals(pw)) {
					System.out.println("성공");
					// 로그인한 회원의 정보가
					// 어떤 메뉴를 가든지 살아있어야함 / 일정시간 지나면 사라지기
					//		=> session 으로
					Member m = new Member(id, pw, rs.getDate("pm_birthday"), rs.getString("pm_photo"));
					req.getSession().setAttribute("loginMember", m);
//					req.getSession().setMaxInactiveInterval(1000);
				} else {
					System.out.println("실패");
				}
			}
			else{
				System.out.println("미가입 ID");
			}
		} catch (Exception e) {
			
		}
		KdyDBManager.close(con, pstmt, rs);
	}
	public static boolean isLogined(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		if (m != null) { // 로그인 됨
			// 이 사이트에서 로그인이 되었을때 할 작업 
			req.setAttribute("login", "member/logined.jsp");
			return true;
		}
		req.setAttribute("login", "member/login.jsp");
		return false; // 안됨
		
	}
	public static void logOut(HttpServletRequest req) {
		// session 바로 끊기 
		//		-> session 에 담아놓은거 전부 다 삭제
		//			지금이야 상관없지만,
		//			session 에 증발하면 안되는 정보가 있을 수 있어서 좋은 코드가 아님
		//			req.getSession().setMaxInactiveInterval(-1);
		
		req.getSession().setAttribute("loginMember", null);
	}
	
	// GET 방식 요청 : 파라메터 값이 주소에 -> 요청 주소만 알면 그냥 탈퇴가능하니 위험
	public static void memberDelate(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = KdyDBManager.connect("kdyPool");
			
			Member m = (Member) req.getSession().getAttribute("loginMember");
			String id = m.getId();
			System.out.println(id);
			
			String sql = "delete from pooh_member where pm_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			int memberNotionCount = NoticeDAO.getNdao().memberNotionCount(id);
			if (pstmt.executeUpdate() == 1) {
				System.out.println("탈퇴성공");
				String path = req.getSession().getServletContext().getRealPath("member_photo");
				File f = new File(path + "/" + URLDecoder.decode(m.getPhoto(), "euc-kr"));
				f.delete();
				
				NoticeDAO.getNdao().minusNoticeCount(memberNotionCount);
			}
		} catch (Exception e) {
			System.out.println("탈퇴실패");
			
		}
		KdyDBManager.close(con, pstmt, null);
	}
	
	public static void infoUpdate(HttpServletRequest req) {
		MultipartRequest mr = null;
		String path = req.getSession().getServletContext().getRealPath("member_photo");
		try {
			mr = new MultipartRequest( req, path, 10 * 1024 * 1024, "euc-kr", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "수정실패 (파일용량)");
			return;
		}
		String newphoto = null;
		String oldphoto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = KdyDBManager.connect("kdyPool");
			Member m = (Member) req.getSession().getAttribute("loginMember");
			
			String pw = mr.getParameter("pw");
			newphoto = mr.getFilesystemName("photo");
			oldphoto = m.getPhoto();
			
			if (newphoto != null) {
				newphoto = URLEncoder.encode(newphoto, "euc-kr").replace("+", " ");
			} else {
				newphoto = oldphoto;
			}
			
			String sql = "update pooh_member set pm_pw=?, pm_photo=? where pm_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pw);
			pstmt.setString(2, newphoto);
			pstmt.setString(3, m.getId());
			
			if (pstmt.executeUpdate() == 1) {
				System.out.println("업데이트 성공");
				m.setPw(pw);  m.setPhoto(newphoto);
				req.getSession().setAttribute("loginMember", m);
				if (!newphoto.equals(oldphoto)) {
					File f = new File(path + "/" + URLDecoder.decode(oldphoto, "euc-kr"));
					f.delete();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("업데이트 실패");
			if (!newphoto.equals(oldphoto)) {
				File f = new File(path + "/" + newphoto);
				f.delete();
			}
		}
		KdyDBManager.close(con, pstmt, null);
	}
}
