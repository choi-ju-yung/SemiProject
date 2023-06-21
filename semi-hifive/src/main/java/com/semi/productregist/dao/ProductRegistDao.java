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
import com.semi.category.model.vo.SubCategory;

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
	public List<SubCategory> selectSubCate(Connection conn, String cateId){
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		List<SubCategory> subCategorys = new ArrayList();
		try {
			pstmt=conn.prepareStatement(
					sql.getProperty("selectSubCate"));
			pstmt.setString(1, cateId);
			rs=pstmt.executeQuery(); 
			
			while(rs.next()) {
				SubCategory sc=new SubCategory();
				sc.setSubcategoryName(rs.getString("CATEGORY_NAME"));

				subCategorys.add(sc);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return subCategorys;
	}
	
	
}
