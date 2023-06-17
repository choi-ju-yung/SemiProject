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

import com.semi.mypage.model.vo.Category;
import com.semi.mypage.model.vo.Member;
import com.semi.mypage.model.vo.ProductList;
import com.semi.mypage.model.vo.SubCategory;
import com.semi.mypage.model.vo.Trade;

public class MypageProductDao {
	private Properties sql = new Properties();
	
	public MypageProductDao() {
		String path = MypageMemberDao.class.getResource("/sql/mypage/productsql.properties").getPath();
		try(FileReader fr = new FileReader(path)){
			sql.load(fr);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// 판매목록
	public List<ProductList> selectSellListByUserId(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProductList> list = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sql.getProperty("selectSellListByUserId"));
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(getProductSellList(rs));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		} return list;
	}
	
	// 구매목록
	public List<ProductList> selectBuyListByUserId(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProductList> list = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sql.getProperty("selectBuyListByUserId"));
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(getProductBuyList(rs));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		} return list;
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
		
		private ProductList getProductSellList(ResultSet rs) throws SQLException {
			return ProductList.builder()
					.productId(rs.getInt("product_Id"))
					.userId(rs.getString("user_Id"))
					.productTitle(rs.getString("product_Title"))
					.productStatus(rs.getString("product_Status"))
					.sellStatus(rs.getString("sell_Status"))
					.price(rs.getInt("price"))
					.registTime(rs.getDate("regist_Time"))
					.viewCount(rs.getInt("view_Count"))
					.subcategoryName(rs.getString("subcategory_Name"))
					.member(Member.builder()
							.userId(rs.getString("user_Id")).build())
					.subCategory(SubCategory.builder()
							.subcategoryName(rs.getString("subcategory_Name")).build())
					.category(Category.builder()
							.categoryName(rs.getString("category_Name")).build())
					.build();
		}
	
	private ProductList getProductBuyList(ResultSet rs) throws SQLException {
		return ProductList.builder()
				.productId(rs.getInt("product_Id"))
				.userId(rs.getString("user_Id"))
				.productTitle(rs.getString("product_Title"))
				.productStatus(rs.getString("product_Status"))
				.sellStatus(rs.getString("sell_Status"))
				.price(rs.getInt("price"))
				.registTime(rs.getDate("regist_Time"))
				.viewCount(rs.getInt("view_Count"))
				.subcategoryName(rs.getString("subcategory_Name"))
				.member(Member.builder()
						.userId(rs.getString("user_Id")).build())
				.subCategory(SubCategory.builder()
						.subcategoryName(rs.getString("subcategory_Name")).build())
				.category(Category.builder()
						.categoryName(rs.getString("category_Name")).build())
				.trade(Trade.builder()
						.sellDate(rs.getDate("sell_Date")).build())
				.build();
	}
}
