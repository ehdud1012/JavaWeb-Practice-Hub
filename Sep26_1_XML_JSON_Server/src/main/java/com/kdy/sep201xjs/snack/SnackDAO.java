package com.kdy.sep201xjs.snack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.kdy.db.manager.KdyDBManager;

public class SnackDAO {
	// DB에 있는거 
	//		index.jsp에 나오게 = getSnack : 내부
	//		외부에서 쓸 수 있게 - 외부인에게 (서버주소, 포트, 등등) 정보 공개..? ㄴㄴ
	//						-> DB에 있는 데이터를 외부에서 요청하면
	//							데이터만 안전하게 줄 수 있는 시스템 = XML/JSON
	//			- 안드로이드앱에는?
	//			- 외부 분석가가 분석할수있게
	//			- 외부 사이트에는?
	public static void getSnack(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = KdyDBManager.connect("kdyPool");
			
			String sql = "select * from sep26_snack";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			ArrayList<Snack> s = new ArrayList<Snack>();
			while (rs.next()) { 
				s.add(new Snack(
							rs.getString("s_name"), 
							rs.getInt("s_price")));
			}
			req.setAttribute("s", s);
		} catch (Exception e) {
			e.printStackTrace();
		}
		KdyDBManager.close(con, pstmt, rs);
		
	}
	
	// para - x
	// attr - 요청 -> 다음 요청까지 값 살아있음
	// session - 서버-사용자 -> 이 사이트 어디서든 값 사용
	// cookie - 위험
				
	// 외부 분석가가 정보가 달라? -> 4개 다 탈락
	// DB의 데이터를 String 으로 만들어서 응답
	// A랑 B가 데이터를 주고 받는중인데, 정해진 형식이 있어야 함
	//		-> 한글처리, 파싱용이
	// 서로 데이터를 주고 받을 때 쓰는 국제표준형식
	// 		- XML  : 데이터를 HTML모양으로 표현
	// 		- JSON : 데이터를 JavaScript모양으로 표현
	
	public static String getSnack_XML(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = KdyDBManager.connect("kdyPool");
			
			String sql = "select * from sep26_snack";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
		
			StringBuffer sb = new StringBuffer();
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<sep26_snack>");
			while (rs.next()) { 
				sb.append("<snack>");
				sb.append("<s_name>" + rs.getString("s_name") + "</s_name>"); 
				sb.append("<s_price>" + rs.getInt("s_price") + "</s_price>"); 
				sb.append("</snack>");
			}
			sb.append("</sep26_snack>");
			String snacks = sb.toString();
			return snacks;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			KdyDBManager.close(con, pstmt, rs);
		}
		
	}
	
	// XML vs JSON (JavaScript에서 주로 사용 => 멈ㅌ)
	// 		XML 먼저 탄생 : 데이터를 HTML 모양으로
	//			=> JS에서 사용되는데 굳이 HTML?
	//		-> JSON 탄생 : 데이터를 JS 모양
	// JSON이 파싱 쉬움, 용량 적음 => 모든 면에서 XML 상위호환
	//		=> 요즘 JSON 사용
	
	// XML이 나은 점 !
	//	가독성 -> 요즘 XML은 설정 파일에 사용
	public static String getSnack_JSON(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = KdyDBManager.connect("kdyPool");
			
			String sql = "select * from sep26_snack";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Boolean first = true;
			StringBuffer sb = new StringBuffer();
			sb.append("[");
			while (rs.next()) { 
				if (first) { 
					first = false;
				} else {
					sb.append(",");
				}
				sb.append("{");
				sb.append("\"s_name\" : \"" + rs.getString("s_name") + "\","); 
				sb.append("\"s_price\" : " + rs.getInt("s_price")); 
				sb.append("}");
			}
			sb.append("]");
			String snacks = sb.toString();
			return snacks;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			KdyDBManager.close(con, pstmt, rs);
		}
		
	}
}
