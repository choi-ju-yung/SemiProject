package com.semi.mypage.dao;

import static com.semi.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.semi.mypage.model.vo.Product;

public class TradeDao {
	
	private Properties sql = new Properties();
	
	public TradeDao() {
		String path = TradeDao.class.getResource("/sql/mypage/tradesql.properties").getPath();
		try {
			sql.load(new FileReader(path));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public int selectTradeCount(Connection conn) {
		return 1;
	}
	
	// 아이디로 판매내역 가져오기
	public List<Product> selectSellListById(Connection conn, String userId){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Product> p = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sql.getProperty("selectSellListById"));
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				p.add(getProduct(rs));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		} return p;
	}
	
	// 찜 수 가져오기
	public int interestCount(Connection conn) {
		return 1;
	}
	
	// 판매상태 전체 카운트
	public int countSellStatusAll(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int total = 0;
		try {
			pstmt = conn.prepareStatement(sql.getProperty("countSellStatusAll"));
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if(rs.next()) total = rs.getInt(1);
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		} return total;
	}
	
	// 판매상태 카운트(판매중, 예약중, 판매완료)
	public int countSellStatusSell(Connection conn, String userId, String status) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int total = 0;
		try {
			pstmt = conn.prepareStatement(sql.getProperty("countSellStatus"));
			pstmt.setString(1, status);
			pstmt.setString(2, userId);
			rs = pstmt.executeQuery();
			if(rs.next()) total = rs.getInt(1);
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		} return total;
	}
	
	private static Product getProduct(ResultSet rs) throws SQLException{
		return Product.builder()
				.productId(rs.getInt("product_id"))
				.userId(rs.getString("user_id"))
				.productTitle(rs.getString("product_title"))
				.productStatus(rs.getString("product_status"))
				.sellStatus(rs.getString("sell_status"))
				.price(rs.getInt("price"))
				.registTime(rs.getDate("regist_time"))
				.viewCount(rs.getInt("view_count"))
				.explanation(rs.getString("explanation"))
				.keyword(rs.getString("keyword"))
				.subcategoryName(rs.getString("subcategory_name"))
				.goonguareaId(rs.getInt("goonguarea_id"))
				.build();
	}
	
}
