package com.semi.productregist.dao;

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
import com.semi.product.model.vo.Product;
import com.semi.product.model.vo.ProductFile;

public class ProductRegistDao {
	private Properties sql=new Properties(); // Properties 파일객체 만듬
	{
		String path=ProductRegistDao.class.getResource("/sql/productregist/productregist_sql.properties").getPath();
		try {
			sql.load(new FileReader(path)); // 해당경로에 객체 파일 연결
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	// 카테고리 전체를 조회하는 작업
	public List<Category> selectAll(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		List<Category> categorys = new ArrayList();
		try {
			pstmt=conn.prepareStatement(
					sql.getProperty("selectAll"));

			rs=pstmt.executeQuery(); 
			
			while(rs.next()) {
				Category c=new Category();
				c.setCategoryId(rs.getString("CATEGORY_ID"));
				c.setCategoryName(rs.getString("CATEGORY_NAME"));
				categorys.add(c);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return categorys;
	}
	
	
	// 서브카테고리 조회하는 작업
	public List<String> selectSubCate(Connection conn, String cateId){
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		List<String> subCategorys = new ArrayList();
		try {
			pstmt=conn.prepareStatement(
					sql.getProperty("selectSubCate"));
			pstmt.setString(1, cateId);
			rs=pstmt.executeQuery(); 
			
			while(rs.next()) {
				String sc="";
				sc = rs.getString("SUBCATEGORY_NAME");

				subCategorys.add(sc);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return subCategorys;
	}
	
	
	
	public int insertProduct(Connection conn, Product p, String userId){
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("insertProduct"));
			pstmt.setString(1, userId);
			pstmt.setString(2, p.getTitle());
			pstmt.setString(3, p.getProductStatus());
			pstmt.setInt(4, p.getPrice());
			pstmt.setString(5, p.getExplanation());
			pstmt.setString(6, p.getKeyword());
			pstmt.setString(7, p.getSubCategoryName());
			pstmt.setString(8, p.getAreaName());
	
			
			result=pstmt.executeUpdate(); 
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	
//	public int selectSequenceNo(Connection conn) {
//		PreparedStatement pstmt = null;
//		int result = 0;
//		ResultSet rs=null;
//		try {
//			pstmt=conn.prepareStatement(sql.getProperty("selectSequenceNo"));
//			
//			rs=pstmt.executeQuery();
//			if(rs.next()) {
//				result = rs.getInt(1);
//			}
//			
//			result=pstmt.executeUpdate(); 
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}finally {
//			close(pstmt);
//		}return result;
//	}
	
	
	
	public int insertProductFile(Connection conn, ProductFile f) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			// ProudctFile 안의  상품아이디는 SEQ_PRODUCT_ID.CURRVAL 를 통해서 넣어줌 (현재 시퀀스값)
			pstmt=conn.prepareStatement(sql.getProperty("insertProductFile"));
			pstmt.setString(1, f.getImageName());
			pstmt.setString(2, String.valueOf(f.getMainImageYn()));
			
			result=pstmt.executeUpdate(); 
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	
	
}
