package com.semi.productpage.dao;

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
import com.semi.member.model.vo.Member;
import com.semi.product.model.vo.Product;
import com.semi.product.model.vo.ProductComment;
import com.semi.productpage.model.vo.AjaxProductComment;
import com.semi.productpage.model.vo.ProductCategory;
import com.semi.productpage.model.vo.ProductCommentUser;

public class ProductDao {

	private Properties sql = new Properties();

	public ProductDao() {
		String path = ProductDao.class.getResource("/sql/productpage/productpagesql.properties").getPath();
		try (FileReader fr = new FileReader(path);) {
			sql.load(fr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ProductCategory selectProduct(Connection conn, int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductCategory p = null;
		String sql = this.sql.getProperty("selectProduct");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				p = getProductCategory(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return p;
	}

	public List<ProductCommentUser> selectAllProductComment(Connection conn, int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProductCommentUser> list = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sql.getProperty("selectAllProductComment"));
			pstmt.setInt(1, id);
			pstmt.setInt(2, id);
			rs = pstmt.executeQuery();
			while (rs.next())
				list.add(getProductCommentUser(rs));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	public AjaxProductComment selectAjaxProductComment(Connection conn, int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AjaxProductComment p = null;
		String sql = this.sql.getProperty("selectAjaxProductComment");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				p = getAjaxProductComment(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return p;
	}

	public AjaxProductComment selectReAjaxProductComment(Connection conn, int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AjaxProductComment p = null;
		String sql = this.sql.getProperty("selectReAjaxProductComment");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				p = getAjaxProductComment (rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return p;
	}

	public int insertAjaxProductComment(Connection conn, ProductCommentUser pc) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql.getProperty("insertAjaxProductComment"));
			pstmt.setInt(1, pc.getProduct().getProductId());
			pstmt.setString(2, pc.getProductComment().getUserId());
			pstmt.setString(3, pc.getProductComment().getCommentRef() == 0 ? null : String.valueOf(pc.getProductComment().getCommentRef()));
			pstmt.setString(4, pc.getProductComment().getContent());
			pstmt.setInt(5, pc.getProductComment().getCommentLevel());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int updateAjaxProductComment(Connection conn, ProductCommentUser pc, int cn) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql.getProperty("updateAjaxProductComment"));
			pstmt.setString(1, pc.getProductComment().getContent());
			pstmt.setInt(2, cn);
			pstmt.setInt(3, pc.getProductComment().getProductId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public AjaxProductComment updateSelectAjaxProductComment(Connection conn, int cn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AjaxProductComment p = null;
		String sql = this.sql.getProperty("updateSelectAjaxProductComment");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cn);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				p = getAjaxProductComment(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return p;
	}

	public int deleteProductComment(Connection conn, int cn) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql.getProperty("deleteProductComment"));
			pstmt.setInt(1, cn);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	/*
	 * private Product getProduct(ResultSet rs) throws SQLException { return
	 * Product.builder() .productId(rs.getInt("product_id"))
	 * .userId(rs.getString("user_id")) .title(rs.getString("product_title"))
	 * .productStatus(rs.getString("product_status"))
	 * .sellStatus(rs.getString("sell_status")) .price(rs.getInt("price"))
	 * .registTime(rs.getDate("regist_time")) .viewCount(rs.getInt("view_count"))
	 * .explanation(rs.getString("explanation")) .keyword(rs.getString("keyword"))
	 * .subCategoryName(rs.getString("subcategory_name"))
	 * .areaName(rs.getString("area_name")) .build(); }
	 */
	private ProductCategory getProductCategory(ResultSet rs) throws SQLException {
		return ProductCategory.builder()
				.product(Product.builder()				
						.productId(rs.getInt("product_id"))
						.userId(rs.getString("user_id"))
						.title(rs.getString("product_title"))
						.productStatus(rs.getString("product_status"))
						.sellStatus(rs.getString("sell_status"))
						.price(rs.getInt("price"))
						.registTime(rs.getDate("regist_time"))
						.viewCount(rs.getInt("view_count"))
						.explanation(rs.getString("explanation"))
						.keyword(rs.getString("keyword"))
						.subCategoryName(rs.getString("subcategory_name"))
						.areaName(rs.getString("area_name"))
						.build())
				.category(Category.builder()
						.categoryName(rs.getString("category_name"))
						.build())
				.build();
	}

	private ProductComment getProductComment(ResultSet rs) throws SQLException {
		return ProductComment.builder()
				.userId(rs.getString("user_id"))
				.productId(rs.getInt("product_id"))
				.commentNo(rs.getInt("product_comment_no"))
				.commentLevel(rs.getInt("product_comment_level"))
				.content(rs.getString("product_comment_content"))
				.commentRef(rs.getInt("product_comment_ref"))
				.enrollDate(rs.getDate("product_comment_date"))
				.build();
	}
		
	private ProductCommentUser getProductCommentUser(ResultSet rs) throws SQLException {
		return ProductCommentUser.builder()
				.product(Product.builder()				
						.productId(rs.getInt("product_id"))
						.userId(rs.getString("user_id"))
						.build())
				.productComment(ProductComment.builder()
						.userId(rs.getString("user_id"))
						.productId(rs.getInt("product_id"))
						.commentNo(rs.getInt("product_comment_no"))
						.commentLevel(rs.getInt("product_comment_level"))
						.content(rs.getString("product_comment_content"))
						.commentRef(rs.getInt("product_comment_ref"))
						.enrollDate(rs.getDate("product_comment_date"))
						.build())
				.member(Member.builder()
						.nickName(rs.getString("nickname"))
						.profileImg(rs.getString("profile_img"))
						.build())
				.count(rs.getInt("comment_count"))
				.build();
	}
	
	private AjaxProductComment getAjaxProductComment(ResultSet rs) throws SQLException {
		return AjaxProductComment.builder()
				.userId(rs.getString("user_id"))
				.productId(rs.getInt("product_id"))
				.commentNo(rs.getInt("product_comment_no"))
				.commentLevel(rs.getInt("product_comment_level"))
				.content(rs.getString("product_comment_content"))
				.commentRef(rs.getInt("product_comment_ref"))
				.enrollDate(rs.getDate("product_comment_date"))
				.nickName(rs.getString("nickname"))
				.profileImg(rs.getString("profile_img"))
				.build();
	}


}
