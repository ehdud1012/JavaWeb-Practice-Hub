package com.kdy.sep112db.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.kdy.db.manager.KdyDBManager;

public class ProductDAO {
	private int allProductCount;
	private int productPerPage;
	
	private static final ProductDAO PDAO = new ProductDAO();

	public ProductDAO() {
		productPerPage = 5;
	}

	public static ProductDAO getPdao() {
		return PDAO;
	}
	
	public void setAllProductCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = KdyDBManager.connect("kdyPool");
			
			String sql = "select count(*) from sep11_product";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			allProductCount = rs.getInt("count(*)");
			
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
			int pageCount = (int) Math.ceil(allProductCount / (double) productPerPage);
			req.setAttribute("pageCount", pageCount);
			
			int start = (page - 1) * productPerPage + 1;
			int end = page * productPerPage;
			
			
			String sql = "select * from (select rownum as rn, p_name, p_price "
					+ "from (select p_name, p_price from sep11_product order by p_name)) where rn >= ? and rn <= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			ArrayList<Product> al = new ArrayList<Product>();
			Product p = null;
			while (rs.next()) {
				p = new Product();
				p.setName(rs.getString("p_name"));
				p.setPrice(rs.getInt("p_price"));
				al.add(p);
			}
			req.setAttribute("products", al);
		} catch (Exception e) {
			
		}
		KdyDBManager.close(con, pstmt, rs);
	}
	
	public void reg(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = KdyDBManager.connect("kdyPool");
			
			req.setCharacterEncoding("euc-kr");
			String name = req.getParameter("name");
			int price = Integer.parseInt(req.getParameter("price"));
			
			String sql = "insert into sep11_product values(sep_11_product_seq.nextval, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, price);
			
			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("result", "등록성공");
				allProductCount ++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "등록실패");
		} 
		KdyDBManager.close(con, pstmt, null);
	}
}
