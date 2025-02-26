package com.kdy.jsppooh.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.kdy.db.manager.KdyDBManager;
import com.kdy.jsppooh.member.Member;
import com.kdy.jsppooh.member.MemberDAO;

public class NoticeDAO {
	private static final NoticeDAO NDAO = new NoticeDAO();
	
	private int allNoticeCount;
	private int noticePerPage;
	
	private NoticeDAO() {
		noticePerPage = 5;
	}
	
	public static NoticeDAO getNdao() {
		return NDAO;
	}
	
	public void minusNoticeCount(int i) {
		allNoticeCount -= i;
	}

	public ArrayList<Comment> getComment(String no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = KdyDBManager.connect("kdyPool");
			
			String sql = "select * from pooh_notice_comment where pc_pn_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, no);
			
			rs = pstmt.executeQuery();
			ArrayList<Comment> c = new ArrayList<Comment>();
			while (rs.next()) { 
				c.add(new Comment(
							rs.getInt("pc_no"),
							rs.getString("pc_txt"), 
							rs.getDate("pc_date"),
							rs.getString("pc_writer"),
							rs.getInt("pc_pn_no")));
			}
			return c;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			KdyDBManager.close(con, pstmt, rs);
		}
	}
	public void notionCommentWrite(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = KdyDBManager.connect("kdyPool");
			req.setCharacterEncoding("euc-kr");
			Member m = (Member) req.getSession().getAttribute("loginMember");
			
			String comment = req.getParameter("comment");
			int nno = Integer.parseInt(req.getParameter("nno"));
			String id = m.getId();
			
			String sql = "insert into pooh_notice_comment values(sep_25_comment_seq.nextval, ?, sysdate, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, comment);
			pstmt.setString(2, id);
			pstmt.setInt(3, nno);
			
			if (pstmt.executeUpdate() == 1) {
				System.out.println("댓글등록성공");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		KdyDBManager.close(con, pstmt, null);
	}
	public int memberNotionCount(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = KdyDBManager.connect("kdyPool");
			
			String sql = "select count(*) from pooh_notice where pn_writer = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt("count(*)");
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			KdyDBManager.close(con, pstmt, rs);
		}
	}
	public void notionDelete(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = KdyDBManager.connect("kdyPool");
			String no = req.getParameter("no");
			
			String sql = "delete from pooh_notice where pn_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, no);
			if (pstmt.executeUpdate() == 1) {
				System.out.println("삭제성공");
				allNoticeCount --;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("삭제실패");
		}
		KdyDBManager.close(con, pstmt, null);
	}
	public void writeUpdate(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = KdyDBManager.connect("kdyPool");
			req.setCharacterEncoding("euc-kr");
			
			String title = req.getParameter("title");
			String txt = req.getParameter("txt");
			String no = req.getParameter("no");
			
			String sql = "update pooh_notice set pn_title = ?, pn_txt = ? where pn_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, txt);
			pstmt.setString(3, no);
			
			if (pstmt.executeUpdate() == 1) {
				System.out.println("업데이트 성공");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		KdyDBManager.close(con, pstmt, null);
	}
	public boolean content(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = KdyDBManager.connect("kdyPool");
			String no = req.getParameter("no");
			
			String sql = "select * from pooh_notice where pn_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, no);
			
			rs = pstmt.executeQuery();
			// 여러 명이 사용하는 사이트이기 때문에 누군가 글을 삭제했을 경우를 대비
			if (rs.next()) { 
				Notice n = new Notice(rs.getString("pn_no"), 
						rs.getString("pn_title"), 
						rs.getString("pn_txt"), 
						rs.getDate("pn_date"), 
						rs.getString("pn_writer"));
				req.setAttribute("n", n);
				
				String id = rs.getString("pn_writer");
				String profile = MemberDAO.getProfile(req, id);
				req.setAttribute("profile", profile);
				
				ArrayList<Comment> c = getComment(no);
				req.setAttribute("c", c);
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		} finally {
			KdyDBManager.close(con, pstmt, rs);
		}
	}
	
	public void clearSearch(HttpServletRequest req) {
		req.getSession().setAttribute("searchWord", null);
	}

	public void search(HttpServletRequest req) {
		try {
			req.setCharacterEncoding("euc-kr");
			String searchWord = req.getParameter("search");
			req.getSession().setAttribute("searchWord", searchWord);
			
		} catch (Exception e) {
		}
	}
	
	private int getsearchNoticeCount(String search) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = KdyDBManager.connect("kdyPool");
			String sql = "select count(*) from pooh_notice where pn_title like '%'||?||'%' or pn_txt like '%'||?||'%' order by pn_date desc";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, search);
			pstmt.setString(2, search);
			
			rs = pstmt.executeQuery();
			rs.next();
			int count = rs.getInt("count(*)");
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			KdyDBManager.close(con, pstmt, rs);
		}
	}
	
	public void setAllNoticeCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = KdyDBManager.connect("kdyPool");
			
			String sql = "select count(*) from pooh_notice";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			allNoticeCount = rs.getInt("count(*)");
			
		} catch (Exception e) {
			
		}
		KdyDBManager.close(con, pstmt, rs);
	}
	
	public void get(int page, HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = KdyDBManager.connect("kdyPool");
			
			// 검색 중인지 아닌지
			String searchWord = (String) req.getSession().getAttribute("searchWord");
			int noticeCount = allNoticeCount;
			if (searchWord == null) {
				searchWord = ""; // 오류(nullException) 방지
			} else {
				noticeCount = getsearchNoticeCount(searchWord);
			}
			int pageCount = (int) Math.ceil(noticeCount / (double) noticePerPage);
			req.setAttribute("pageCount", pageCount);
			int start = (page - 1) * noticePerPage + 1;
			int end = page * noticePerPage;
			
			String sql = " select * from (select rownum as rn, pn_no, pn_title, pn_date "
					+ " from (select pn_no, pn_title, pn_date from pooh_notice "
					+ " where pn_title like '%'||?||'%' or pn_txt like '%'||?||'%' order by pn_date desc)) where rn >= ? and rn <= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, searchWord);
			pstmt.setString(2, searchWord);
			pstmt.setInt(3, start);
			pstmt.setInt(4, end);
			
			rs = pstmt.executeQuery();
			ArrayList<Notice> al = new ArrayList<Notice>();
			Notice n = null;
			while (rs.next()) {
				n = new Notice();
				n.setNo(rs.getString("pn_no"));
				n.setTitle(rs.getString("pn_title"));
				n.setDate(rs.getDate("pn_date"));
				al.add(n);
			}
			req.setAttribute("notices", al);
		} catch (Exception e) {
			
		}
		KdyDBManager.close(con, pstmt, rs);
	}
	public void write(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = KdyDBManager.connect("kdyPool");
			req.setCharacterEncoding("euc-kr");
			Member m = (Member) req.getSession().getAttribute("loginMember");
			
			String title = req.getParameter("title");
			String txt = req.getParameter("txt");
			// 엔터
			//	웹 : <br>
			//	textarea : \r\n
			
			String id = m.getId();
			
			String sql = "insert into pooh_notice values(sep_23_notice_seq.nextval, ?, ?, sysdate, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, txt);
			pstmt.setString(3, id);
			
			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("result", "등록성공");
				allNoticeCount ++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "등록실패");
		} 
		KdyDBManager.close(con, pstmt, null);
	}
}
