package com.semi.category.dao;

import java.io.FileReader;
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
	
	public List<CategoryDto> CategoryList(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CategoryDto> categorylist = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql.getProperty("CategoryList"));
			rs = pstmt.executeQuery();
			while(rs.next()) {
				categorylist.add(getcategory(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return categorylist;
	}
}
