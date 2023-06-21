package com.semi.productpage.dao;

import static com.semi.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.semi.productpage.model.vo.Product;
import com.semi.productpage.model.vo.ProductComment;

public class ProductDao {

	private Properties sql = new Properties();

	public ProductDao() {
		String path=ProductDao.class.getResource("/sql/productpage/productpagesql.properties").getPath();
		try(FileReader fr=new FileReader(path);){
			sql.load(fr);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public Product selectProduct(Connection conn, int id) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Product p=null;
		String sql=this.sql.getProperty("selectProduct");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				p=getProduct(rs);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return p;
	}	
	
	public List<ProductComment> selectAllAjaxProductComment(Connection conn,int id){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<ProductComment> list=new ArrayList();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectAllAjaxProductComment"));
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			while(rs.next())
				list.add(getProductComment(rs));
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return list;
	}
	
	public ProductComment selectAjaxProductComment(Connection conn, int id) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ProductComment p=null;
		String sql=this.sql.getProperty("selectAjaxProductComment");
		
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				p=getProductComment(rs);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return p;
	}
	
	public ProductComment selectReAjaxProductComment(Connection conn, int id) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ProductComment p=null;
		String sql=this.sql.getProperty("selectReAjaxProductComment");
		
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				p=getProductComment(rs);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return p;
	}

	
	public int insertAjaxProductComment(Connection conn, ProductComment pc) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("insertAjaxProductComment"));
			pstmt.setString(1,pc.getUserId());
			pstmt.setInt(2, pc.getProductId());			
			pstmt.setInt(3,pc.getCommentLevel());
			pstmt.setString(4,pc.getContent());
			pstmt.setString(5,pc.getCommentRef()==0?null:
								String.valueOf(pc.getCommentRef()));
			pstmt.setString(6,pc.getNickName());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	public int updateAjaxProductComment(Connection conn, ProductComment pc, int cn) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("updateAjaxProductComment"));						
			pstmt.setString(1,pc.getContent());
			pstmt.setInt(2,cn);
			pstmt.setInt(3, pc.getProductId());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	public ProductComment updateSelectAjaxProductComment(Connection conn, int cn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ProductComment p=null;
		String sql=this.sql.getProperty("updateSelectAjaxProductComment");
		
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,cn);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				p=getProductComment(rs);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return p;
	}
	
	public int deleteAjaxProductComment(Connection conn,int cn) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("deleteAjaxProductComment"));						
			pstmt.setInt(1,cn);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	
	private Product getProduct(ResultSet rs) throws SQLException{
		return Product.builder()
				.productId(rs.getInt("product_id"))
				.userId(rs.getString("user_id"))
				.title(rs.getString("product_title"))
				.status(rs.getString("product_status"))
				.sellStatus(rs.getString("sell_status"))
				.price(rs.getInt("price"))
				.registTime(rs.getDate("regist_time"))
				.viewCount(rs.getInt("view_count"))
				.explanation(rs.getString("explanation"))
				.keyword(rs.getString("keyword")!=null?rs.getString("keyword").split(","):null)
				.category(rs.getString("category_name"))
				.subCategory(rs.getString("subcategory_name"))
				.areaId(rs.getInt("goonguarea_id"))
				.build();
	}
	
	private ProductComment getProductComment(ResultSet rs) throws SQLException{
		return ProductComment.builder()
				.userId(rs.getString("user_id"))
				.productId(rs.getInt("product_id"))
				.nickName(rs.getString("nickname"))
				.commentNo(rs.getInt("product_comment_no"))
				.commentLevel(rs.getInt("product_comment_level"))
				.content(rs.getString("product_comment_content"))
				.commentRef(rs.getInt("product_comment_ref"))
				.enrollDate(rs.getDate("product_comment_date"))
				.build();
	}
	
	
}
