package com.semi.category.dao;

import java.io.FileReader;
import com.semi.product.model.dao.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static com.semi.common.JDBCTemplate.*;

import com.semi.category.model.vo.CategoryDto;
import com.semi.product.model.dao.ProductChartPageDao;
import com.semi.product.model.vo.ProductDto;

public class CategoryDao {
	private Properties sql = new Properties();
	{
		String path = ProductChartPageDao.class.getResource("/sql/product/category.sql.properties").getPath();
		
		try {
			sql.load(new FileReader(path));
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static CategoryDto getcategory(ResultSet rs) throws SQLException {
		return CategoryDto.builder()
				.categoryid(rs.getString("CATEGORY_ID"))
				.categoryname(rs.getString("CATEGORY_NAME")).build();
	}
	public static CategoryDto getselectcategory(ResultSet rs) throws SQLException {
		return CategoryDto.builder()
				.categoryid(rs.getString("CATEGORY_ID"))
				.categoryname(rs.getString("CATEGORY_NAME")).build();
	}
	
	
	// 대표카테고리만 출력해주는 메소드
	public List<CategoryDto> Category(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CategoryDto> selectcategory = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql.getProperty("Category"));
			rs = pstmt.executeQuery();
			while(rs.next()) {
				selectcategory.add(getselectcategory(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return selectcategory;
	}
	// 카테고리와 세부카테고리 두개 join한 메소드
	public List<CategoryDto> SubCategoryList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CategoryDto> subctcategory = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql.getProperty("SubCategoryList"));
			rs = pstmt.executeQuery();
			while(rs.next()) {
				subctcategory.add(getcategory(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return subctcategory;
	}
	
	// 대표카테고리 테이블에서 대표카테고리 이름을 찾아서 출력해주는 메소드
		public CategoryDto CategoryName(Connection conn, String categoryname) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			CategoryDto c = null;
			try {
				pstmt = conn.prepareStatement(sql.getProperty("CategoryName"));
				pstmt.setString(1, categoryname);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					c = getselectcategory(rs);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}return c;
		}
	
}
