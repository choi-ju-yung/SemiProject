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

import com.semi.category.model.vo.Category;
import com.semi.category.model.vo.SubCategory;
import com.semi.member.model.vo.Member;
import com.semi.mypage.model.vo.MemberWishList;
import com.semi.mypage.model.vo.ProductList;
import com.semi.mypage.model.vo.Trade;
import com.semi.mypage.model.vo.WishList;
import com.semi.productpage.model.vo.Product;

public class MypageProductDao {
	private Properties sql = new Properties();

	public MypageProductDao() {
		String path = MypageMemberDao.class.getResource("/sql/mypage/productsql.properties").getPath();
		try (FileReader fr = new FileReader(path)) {
			sql.load(fr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 판매목록
	public List<ProductList> selectSellListByUserId(Connection conn, int cPage, int numPerpage, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProductList> list = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sql.getProperty("selectSellListByUserId"));
			pstmt.setString(1, userId);
			pstmt.setInt(2, (cPage - 1) * numPerpage + 1);
			pstmt.setInt(3, cPage * numPerpage);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(getProductSellList(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	// 구매목록
	public List<ProductList> selectBuyListByUserId(Connection conn, int cPage, int numPerpage, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProductList> list = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sql.getProperty("selectBuyListByUserId"));
			pstmt.setString(1, userId);
			pstmt.setInt(2, (cPage - 1) * numPerpage + 1);
			pstmt.setInt(3, cPage * numPerpage);
			rs = pstmt.executeQuery();
			while (rs.next())
				list.add(getProductBuyList(rs));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
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
			if (rs.next())
				total = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return total;
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
			if (rs.next())
				total = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return total;
	}

	// 성사된 거래수
	public int countTrade(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int trade = 0;
		try {
			pstmt = conn.prepareStatement(sql.getProperty("countTrade"));
			pstmt.setString(1, userId);
			pstmt.setString(2, "판매완료");
			rs = pstmt.executeQuery();
			if (rs.next())
				trade = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return trade;
	}

	// 구매내역 오래된순
	public List<ProductList> BuyListSortAsc(Connection conn, int cPage, int numPerpage, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProductList> list = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sql.getProperty("BuyListSortAsc"));
			pstmt.setString(1, userId);
			pstmt.setInt(2, cPage);
			pstmt.setInt(3, numPerpage);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(getProductBuyList(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	// 페이징처리(구매내역 상품 수)
	public int countBuyList(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int totalData = 0;
		try {
			pstmt = conn.prepareStatement(sql.getProperty("countBuyList"));
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if (rs.next())
				totalData = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return totalData;
	}

	// 페이징처리(판매내역 상품 수)
	public int countSellList(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int totalData = 0;
		try {
			pstmt = conn.prepareStatement(sql.getProperty("countSellList"));
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if (rs.next())
				totalData = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return totalData;
	}

	// 판매상태 변경
	public int changeSelectValue(Connection conn, String value, String productId) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql.getProperty("changeSelectValue"));
			pstmt.setString(1, value);
			pstmt.setString(2, productId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 상품삭제
	public int deleteProduct(Connection conn, String productId) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql.getProperty("deleteProduct"));
			pstmt.setString(1, productId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 판매상태가 전체인 상품 리스트
	public List<ProductList> sellStatusSell(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProductList> list = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sql.getProperty("sellStatus"));
			pstmt.setString(1, userId);
			pstmt.setString(2, "판매중");
			rs = pstmt.executeQuery();
			while (rs.next())
				list.add(getProductSellList(rs));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	// 찜목록 카운트
	public int countWishList(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int totalData = 0;
		try {
			pstmt = conn.prepareStatement(sql.getProperty("countWishList"));
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if (rs.next())
				totalData = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		} return totalData;
	}
	
	// 찜목록 리스트
	public List<MemberWishList> selectWishListByUserId(Connection conn, int cPage, int numPerpage, String userId){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberWishList> list = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sql.getProperty("selectWishListByUserId"));
			pstmt.setString(1, userId);
			pstmt.setInt(2, (cPage - 1) * numPerpage + 1);
			pstmt.setInt(3, cPage * numPerpage);
			rs = pstmt.executeQuery();
			while (rs.next())
				list.add(getMemberWishList(rs));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	private ProductList getProductSellList(ResultSet rs) throws SQLException {
		return ProductList.builder()
				.product(Product.builder()
						.productId(rs.getInt("product_Id"))
						.userId(rs.getString("user_Id"))
						.title(rs.getString("product_Title"))
						.status(rs.getString("product_Status"))
						.sellStatus(rs.getString("sell_Status"))
						.price(rs.getInt("price"))
						.registTime(rs.getDate("regist_Time"))
						.viewCount(rs.getInt("view_Count"))
						.subCategory(rs.getString("subcategory_Name")).build())
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
				.product(Product.builder()
						.productId(rs.getInt("product_Id"))
						.userId(rs.getString("user_Id"))
						.title(rs.getString("product_Title"))
						.status(rs.getString("product_Status"))
						.sellStatus(rs.getString("sell_Status"))
						.price(rs.getInt("price"))
						.registTime(rs.getDate("regist_Time"))
						.viewCount(rs.getInt("view_Count"))
						.subCategory(rs.getString("subcategory_Name")).build())
				.member(Member.builder()
						.userId(rs.getString("user_Id"))
						.nickName(rs.getString("nickName")).build())
				.subCategory(SubCategory.builder()
						.subcategoryName(rs.getString("subcategory_Name")).build())
				.category(Category.builder()
						.categoryName(rs.getString("category_Name")).build())
				.trade(Trade.builder()
						.sellDate(rs.getDate("sell_Date")).build())
				.build();
	}

	private MemberWishList getMemberWishList(ResultSet rs) throws SQLException {
		return MemberWishList.builder()
				.product(Product.builder()
						.productId(rs.getInt("product_Id"))
						.userId(rs.getString("user_Id"))
						.title(rs.getString("product_Title"))
						.status(rs.getString("product_Status"))
						.sellStatus(rs.getString("sell_Status"))
						.price(rs.getInt("price"))
						.registTime(rs.getDate("regist_Time"))
						.viewCount(rs.getInt("view_Count"))
						.subCategory(rs.getString("subcategory_Name")).build())
				.subCategory(SubCategory.builder()
						.subcategoryName(rs.getString("subcategory_Name")).build())
				.category(Category.builder()
						.categoryName(rs.getString("category_Name")).build())
				.wishList(WishList.builder()
						.productId(rs.getInt("product_Id")).build())
				.build();
	}
}
